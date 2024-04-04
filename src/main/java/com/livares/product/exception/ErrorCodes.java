package com.livares.product.exception;

public enum ErrorCodes {
	
	    NOT_FOUND(404),
	    BAD_REQUEST(400),
	    UNAUTHORIZED(401),
	    FORBIDDEN(403),
	    INTERNAL_SERVER_ERROR(500);

	    private final int code;

	    ErrorCodes(int code) {
	        this.code = code;
	    }

	    public int getCode() {
	        return code;
	    }
	

}
