package com.example.commonms.model.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Errors {

    LOCALIZED_HANDLING_EXCEPTION(HttpStatus.CONFLICT, "localize your exception code");

    private final String message;
    private final HttpStatus status;

    Errors(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
