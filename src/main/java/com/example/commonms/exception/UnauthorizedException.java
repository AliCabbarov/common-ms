package com.example.commonms.exception;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(ExceptionService service) {
        super(service);
    }
}
