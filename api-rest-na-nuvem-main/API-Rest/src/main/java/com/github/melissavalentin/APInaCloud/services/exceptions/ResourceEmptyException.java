package com.github.melissavalentindev.desafioapi.services.exceptions;

public class ResourceEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceEmptyException(String message) {
		super(message);
	}
}
