package com.livares.product.exception;

import lombok.Getter;
import lombok.Setter;

/**
* The response that will be reflected in the API in case of any error/expection.
*/
@Getter
@Setter
public class ErrorResponse {

    private int errorCode;

    private String message;

    private Boolean success;

    private Object errorData;
}
