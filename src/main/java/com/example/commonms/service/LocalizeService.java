package com.example.commonms.service;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Lazy
@Slf4j
public class LocalizeService {

    private final MessageSource messageSource;

    public String getLocalizeMessage(String code, Locale locale, Object... args) {
        try {
            return messageSource.getMessage(code, args, locale);
        } catch (Exception e) {


            final String message = "localize your code {}";
            log.warn(message, code);
            return null;
        }
    }

}
