package com.pazienza.friendsapi;

import org.springframework.http.HttpStatus;

public class ApiErrorResponse {

	private final String message;

	private final HttpStatus status;

	public ApiErrorResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
}
