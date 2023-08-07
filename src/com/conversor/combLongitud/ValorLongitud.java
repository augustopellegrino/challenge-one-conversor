package com.conversor.combLongitud;

public enum ValorLongitud {

	MILIMETRO(0.001),
	CENTIMETRO(0.01),
	METRO(1);
	
	private final double valor;

	ValorLongitud(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
}