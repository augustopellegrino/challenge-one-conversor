package com.conversor.combMonedas;

import com.conversor.Redondear;

public class LibraEuro implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorLibra = ValorMoneda.LIBRA.getValor();
		double valorEuro = ValorMoneda.EURO.getValor();
		resultado = (valor * valorLibra) / valorEuro;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
