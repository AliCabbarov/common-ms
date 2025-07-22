package com.example.commonms.exception;

import com.example.commonms.model.enums.Errors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ExceptionServiceHandler implements ExceptionService {

    private HttpStatus status;
    private String code;
    private Object[] args;
    private String message;



    public ExceptionServiceHandler(HttpStatus status, String message) {
        this.message = message;
        this.status = status;
    }

    public ExceptionServiceHandler(Errors errors) {
        this.message = errors.getMessage();
        this.status = errors.getStatus();
    }

    public ExceptionServiceHandler(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public ExceptionServiceHandler(String code, HttpStatus status, Object... args) {
        this.code = code;
        this.status = status;
        this.args = args;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
//test
