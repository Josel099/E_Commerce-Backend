package com.livares.product.response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomResponse {

	public String message;
	public int status;
	public Object responseObj;
}
