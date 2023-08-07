package com.conversor.combLongitud;

import com.conversor.Redondear;

public class MilimetroMetro implements Longitud{

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorMilimetro = ValorLongitud.MILIMETRO.getValor();
		resultado = valor * valorMilimetro;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
