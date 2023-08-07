package com.conversor.combMonedas;

import com.conversor.Redondear;

public class DolarLibra implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorDolar = ValorMoneda.DOLAR.getValor();
		double valorLibra = ValorMoneda.LIBRA.getValor();
		resultado = (valor * valorDolar) / valorLibra;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
