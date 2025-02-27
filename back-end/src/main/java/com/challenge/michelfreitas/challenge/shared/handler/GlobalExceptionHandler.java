package com.challenge.michelfreitas.challenge.shared.handler;

import com.challenge.michelfreitas.challenge.shared.exception.BaseException;
import com.challenge.michelfreitas.challenge.shared.exception.WebServiceException;
import com.challenge.michelfreitas.challenge.shared.response.ApiResponse;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerGlobalException(RuntimeException exception) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerGlobalException(BaseException exception) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);

        return new ResponseEntity<>(apiResponse, exception.getHttpStatus());
    }

    @ExceptionHandler(WebServiceException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handlerGlobalException(WebServiceException exception) {
        ApiResponse apiResponse = new ApiResponse(exception.getMessage(), false);

        return new ResponseEntity<>(apiResponse, exception.getHttpStatus());
    }
}
