package com.ratanaphoneshop.phoneshop.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends APIExecption{

	public ResourceNotFoundException(String resourcename, Integer id) {
		super(HttpStatus.NOT_FOUND, "Brand id = %d not found".formatted(id));
		// TODO Auto-generated constructor stub
	}
	
}
