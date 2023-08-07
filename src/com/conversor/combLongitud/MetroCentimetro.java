package com.conversor.combLongitud;

import com.conversor.Redondear;

public class MetroCentimetro implements Longitud{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorReferencia = ValorLongitud.CENTIMETRO.getValor();
		resultado = valor / valorReferencia;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
