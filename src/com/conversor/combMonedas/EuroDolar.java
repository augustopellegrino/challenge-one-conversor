package com.conversor.combMonedas;

import com.conversor.Redondear;

public class EuroDolar implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorEuro = ValorMoneda.EURO.getValor();
		double valorDolar = ValorMoneda.DOLAR.getValor();
		resultado = (valor * valorEuro) / valorDolar;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
