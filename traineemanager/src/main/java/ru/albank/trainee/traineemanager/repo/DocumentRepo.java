package ru.albank.trainee.traineemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.albank.trainee.traineemanager.models.Document;

public interface DocumentRepo extends JpaRepository<Document, Long> {
    @Query("SELECT a from Document a WHERE user_id = ?1 and doc_type = ?2")
    Document checkDocumentByUserId(Long userId, String docType);

    @Query("SELECT fileName from Document a WHERE user_id = ?1 and doc_type = ?2")
    String getUploadDocumentPath(Long userId, String docType);
}
