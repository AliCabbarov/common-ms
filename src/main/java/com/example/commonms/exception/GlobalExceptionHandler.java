package com.example.commonms.exception;

import com.example.commonms.service.LocalizeService;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    private final LocalizeService localizeService;

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handle(BaseException ex, WebRequest webRequest, Locale locale) {
        String localizeMessage = localizeService.getLocalizeMessage(ex.getCode(), locale, ex.getArgs());
        log(localizeMessage);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(localizeMessage == null ? ex.getMessage() : localizeMessage)
                .path(extractPath(webRequest))
                .status(ex.getStatus().value())
                .build();
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResponse> handle(ClientException ex, WebRequest webRequest, Locale locale) {
        log(ex);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ex.getMessage())
                .path(extractPath(webRequest))
                .status(ex.getStatus().value())
                .build();
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }


    private String extractPath(WebRequest webRequest) {
        return ((ServletWebRequest) webRequest).getRequest().getRequestURI();
    }

    private void log(Exception e) {
        e.printStackTrace();
        log.error(e.getMessage());
    }

    private void log(String e) {
        log.error("exception happened: [{}]", e);
    }

}
