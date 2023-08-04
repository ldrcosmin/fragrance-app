package com.fragranceapp.fragranceapp.exceptions.categoryExceptions;

import com.fragranceapp.fragranceapp.exceptions.ApiGeneralFormatError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FragranceCategoryExceptionHandler {

    @ExceptionHandler(FragranceCategoryNotFoundException.class)
    public ResponseEntity<ApiGeneralFormatError> handleFragranceCategoryNotFoundException(FragranceCategoryNotFoundException e,
                                                                                          HttpServletRequest request) {
        StringBuilder requestURL = new StringBuilder(request.getRequestURL().toString());
        String queryString = request.getQueryString();
        String path = requestURL.append("?").append(queryString).toString();
        ApiGeneralFormatError apiError = new ApiGeneralFormatError(400, e.getMessage(), path);

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
