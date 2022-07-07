package ru.albank.trainee.traineemanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.albank.trainee.traineemanager.responses.UploadFileResponse;
import ru.albank.trainee.traineemanager.services.DocumentService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public UploadFileResponse uploadFile(@RequestParam("file")MultipartFile file,
                                         @RequestParam("userId") Long userId,
                                         @RequestParam("docType") String docType) {
        String fileName = documentService.storeFile(file, userId, docType);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/download?userId=")
                .path(String.valueOf(userId))
                .path("&docType=")
                .path(docType)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam("userId") Long userId,
                                                 @RequestParam("docType") String docType,
                                                 HttpServletRequest request) {
        String fileName = documentService.getDocumentName(userId, docType);
        Resource resource = null;
        if (fileName != null && !fileName.isEmpty()) {
            try {
                resource = documentService.loadFileAsResource(fileName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            // Try to determine file's content type
            String contentType = null;
            try {
                contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException ex) {
                //couldn't determine file type
            }
            // Fallback to the default content type if type couldn't be determined
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
