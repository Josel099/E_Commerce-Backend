package com.livares.product.response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.livares.product.Dto.UserDTO;
import com.livares.product.exception.CustomException;
import com.livares.product.exception.ErrorCode;

public class ResponseHandler<T> {

    public static CustomResponse createResponse(CustomResponse response, Object data,
            String successMessage, String errorMessage) {
        if (data != null) {
            response.setSuccess(true);
            response.setData(data);
            response.setMessage(successMessage);
        } else {
            throw new CustomException(ErrorCode.INTERNAL_SERVER_ERROR, errorMessage);
        }
        return response;
    }


}