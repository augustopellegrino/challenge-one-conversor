package com.conversor;

public enum TipoConversor {
	MONEDAS, LONGITUD, TEMPERATURA;
	
	private String tipo;

	void ValorMoneda(String tipo) {
		this.tipo = tipo;
	}
	
	public String getValor() {
		return tipo;
	}
}
