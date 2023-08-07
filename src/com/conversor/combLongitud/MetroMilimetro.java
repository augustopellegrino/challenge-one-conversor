package com.conversor.combLongitud;

import com.conversor.Redondear;

public class MetroMilimetro implements Longitud{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorReferencia = ValorLongitud.MILIMETRO.getValor();
		resultado = valor / valorReferencia;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
