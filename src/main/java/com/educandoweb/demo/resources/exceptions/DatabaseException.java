package com.educandoweb.demo.resources.exceptions;

public class DatabaseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String m) {
		super(m);
	}

}
