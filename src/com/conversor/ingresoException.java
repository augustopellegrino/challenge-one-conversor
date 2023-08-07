package com.conversor;

public class ingresoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ingresoException() { //Llamo al constructor de la clase padre
		super();
	}
	
	public ingresoException(String mensaje) { //Creo el constructor con un mensaje como parametro
		super(mensaje);
	}
}
