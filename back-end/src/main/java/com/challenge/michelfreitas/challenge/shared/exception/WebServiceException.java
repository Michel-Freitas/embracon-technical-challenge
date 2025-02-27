package com.challenge.michelfreitas.challenge.shared.exception;

import org.springframework.http.HttpStatus;

public class WebServiceException extends BaseException {

    public WebServiceException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
