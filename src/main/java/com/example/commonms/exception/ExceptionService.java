package com.example.commonms.exception;

import org.springframework.http.HttpStatus;

public interface ExceptionService {

    HttpStatus getStatus();

    String getCode();

    Object[] getArgs();

    String getMessage();

}
