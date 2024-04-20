package com.satish.apps.exception;

public class UserServiceException extends RuntimeException {

	private static final long serialVersionUID = -3533005592910308732L;

	public UserServiceException(String message) {
		super(message);
	}
}
