package com.conversor.combMonedas;

import com.conversor.Redondear;

public class LibraDolar implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorLibra = ValorMoneda.LIBRA.getValor();
		double valorDolar = ValorMoneda.DOLAR.getValor();
		resultado = (valor * valorLibra) / valorDolar;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
