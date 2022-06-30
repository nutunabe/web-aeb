package ru.albank.trainee.traineemanager.exceptions;

public class DocumentStorageException extends RuntimeException {
    public DocumentStorageException(String message) {
        super(message);
    }

    public DocumentStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
