package com.flux.backend.shared.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class ValidationError extends ApiError {

    private final Map<String, String> fieldErrors = new HashMap<>();

    public ValidationError(
        Instant timestamp,
        Integer status,
        String error,
        String message,
        String path
    ) {
        super(timestamp, status, error, message, path);
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void addFieldError(String fieldName, String message) {
        fieldErrors.put(fieldName, message);
    }
}
