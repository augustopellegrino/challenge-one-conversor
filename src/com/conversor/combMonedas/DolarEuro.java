package com.conversor.combMonedas;

import com.conversor.Redondear;

public class DolarEuro implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorDolar = ValorMoneda.DOLAR.getValor();
		double valorEuro = ValorMoneda.EURO.getValor();
		resultado = (valor * valorDolar) / valorEuro;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
