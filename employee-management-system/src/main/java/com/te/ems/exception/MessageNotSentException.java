package com.te.ems.exception;

public class MessageNotSentException extends RuntimeException {

	public MessageNotSentException(String message) {
		super(message);
	}
}
