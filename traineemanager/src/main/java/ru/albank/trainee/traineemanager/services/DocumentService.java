package ru.albank.trainee.traineemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import ru.albank.trainee.traineemanager.exceptions.DocumentStorageException;
import ru.albank.trainee.traineemanager.models.Document;
import ru.albank.trainee.traineemanager.repo.DocumentRepo;


@Service
public class DocumentService {

    private Path fileStorageLocation = Path.of("C:/uploads");

    private DocumentRepo documentRepo;

    @Autowired
    public DocumentService(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public String storeFile(MultipartFile file, Long userId, String docType) {

        // Normalize file name
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = "";

        try {
            // Check if the file's name contains invalid characters
            if (originalFileName.contains("..")) {
                throw new DocumentStorageException("Sorry! Filename contains invalid path sequence " + originalFileName);
            }

            String fileExtension = "";

            try {
                fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
            } catch (Exception e) {
                fileExtension = "";
            }
            fileName = userId + "_" + docType + fileExtension;

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            Document doc = documentRepo.checkDocumentByUserId(userId, docType);
            if(doc != null) {
                doc.setDocFormat(file.getContentType());
                doc.setFileName(fileName);
                doc.setUploadDir(String.valueOf(fileStorageLocation));
                documentRepo.save(doc);
            } else {
                Document newDoc = new Document();
                newDoc.setUserId(userId);
                newDoc.setDocFormat(file.getContentType());
                newDoc.setFileName(fileName);
                newDoc.setDocType(docType);
                newDoc.setUploadDir(String.valueOf(fileStorageLocation));
                documentRepo.save(newDoc);
            }

            return fileName;
        } catch (IOException ex) {
            throw new DocumentStorageException("Couldn't store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName) throws Exception {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName);
        }
    }

    public String getDocumentName(Long userId, String docType) {
        return documentRepo.getUploadDocumentPath(userId, docType);
    }
}

