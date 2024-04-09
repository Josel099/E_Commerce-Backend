package com.livares.product.response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler<T> {
//
//    public static CustomResponse generateResponse(CustomResponse response, Object data,
//            String successMessage, String errorMessage) {
//        if (data != null) {
//            response.setSuccess(true);
//            response.setData(data);
//            response.setMessage(successMessage);
//        } else {
//            throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
//        }
//        return response;
//    }


    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
       
    	CustomResponse<Object> response = new CustomResponse<Object>();
    	response.setMessage(message);
    	response.setStatus(status);
    	response.setData(responseObj);
            return new ResponseEntity<Object>(response,status);
    }


} 