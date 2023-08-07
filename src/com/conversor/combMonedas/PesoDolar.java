package com.conversor.combMonedas;

import com.conversor.Redondear;

public class PesoDolar implements Monedas{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorCambio = ValorMoneda.DOLAR.getValor();
		resultado = valor / valorCambio;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
