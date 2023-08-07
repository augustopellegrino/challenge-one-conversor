package com.conversor.combMonedas;

public enum ValorMoneda {
	PESO(1),
	DOLAR(276),
	EURO(304),
	LIBRA(352);
	
	private final double valor;

	ValorMoneda(int valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
}

//la palabra final previene que el valor sea modificado una vez que es
//asignado por el constructor