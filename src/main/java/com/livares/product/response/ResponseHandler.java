package com.livares.product.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler<T> {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,
        Object responseObj) {

        CustomResponse<Object> response = new CustomResponse<Object>();
        response.setMessage(message);
        response.setStatus(status);
        response.setData(responseObj);
        return new ResponseEntity<Object>(response, status);
    }

}