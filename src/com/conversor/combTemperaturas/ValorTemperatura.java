package com.conversor.combTemperaturas;

public enum ValorTemperatura {

	CELSIUS(1),
	FAHRENHEIT(1.8),
	KELVIN(273.15);
	
	private final double valor;

	ValorTemperatura(double valor) {
		this.valor = valor;
	}

	public double getValor() {
		return valor;
	}
	
}