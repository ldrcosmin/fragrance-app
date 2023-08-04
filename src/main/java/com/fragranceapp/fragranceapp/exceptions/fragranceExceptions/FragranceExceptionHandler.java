package com.fragranceapp.fragranceapp.exceptions.fragranceExceptions;

import com.fragranceapp.fragranceapp.exceptions.ApiGeneralFormatError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

 @ControllerAdvice
public class FragranceExceptionHandler {

     @ExceptionHandler(FragranceNotFoundException.class)
     public ResponseEntity<ApiGeneralFormatError> handleFragranceNotFoundException(FragranceNotFoundException e, HttpServletRequest request) {
         StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
         String querryString = request.getQueryString();
         String path = requestURL.append('?').append(querryString).toString();
         ApiGeneralFormatError apiError = new ApiGeneralFormatError(400, e.getMessage(), path);

         return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);

     }
 }
