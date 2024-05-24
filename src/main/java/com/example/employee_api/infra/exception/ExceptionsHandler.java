package com.example.employee_api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> exceptionHandler404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Void> exceptionHandler404Optional() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DataValidationError>> exceptionHandler400(MethodArgumentNotValidException exception) {
        List<DataValidationError> validationErrorList = exception.getFieldErrors().stream()
                .map(DataValidationError::new)
                .toList();

        return ResponseEntity.badRequest().body(validationErrorList);
    }

    public record DataValidationError(String field, String message) {
        public DataValidationError(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
