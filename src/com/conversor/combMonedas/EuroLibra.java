package com.conversor.combMonedas;

import com.conversor.Redondear;

public class EuroLibra implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorEuro = ValorMoneda.EURO.getValor();
		double valorLibra = ValorMoneda.LIBRA.getValor();
		resultado = (valor * valorEuro) / valorLibra;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
