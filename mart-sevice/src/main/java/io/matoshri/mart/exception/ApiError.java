package io.matoshri.mart.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
final class ApiError {

    private String message;
    private HttpStatus status;
    private String path;

    public ApiError(String message, HttpStatus status, String path) {
        this.message = message;
        this.status = status;
        this.path = path;
    }
}
