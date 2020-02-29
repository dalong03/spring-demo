package com.fb.webdemo.common.exception;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 2268956063916478714L;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

}
