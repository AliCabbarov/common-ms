package com.example.commonms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends RuntimeException {

    private final HttpStatus status;
    private final String code;
    private final Object[] args;
    private final String message;

    public BaseException(ExceptionService service) {
        status = service.getStatus();
        code = service.getCode();
        args = service.getArgs();
        message = service.getMessage();
    }


}
