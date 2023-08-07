package com.conversor.combLongitud;

import com.conversor.Redondear;

public class CentimetroMetro implements Longitud{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorCentimetro = ValorLongitud.CENTIMETRO.getValor();
		resultado = valor * valorCentimetro;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
