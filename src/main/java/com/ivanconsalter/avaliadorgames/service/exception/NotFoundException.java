package com.ivanconsalter.avaliadorgames.service.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public NotFoundException(Long id, String className) {
		super("Recurso não encontrado. Id: " + id + ", Tipo: " + className);
	}

}
