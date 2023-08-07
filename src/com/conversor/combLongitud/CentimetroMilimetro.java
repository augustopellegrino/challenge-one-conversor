package com.conversor.combLongitud;

import com.conversor.Redondear;

public class CentimetroMilimetro implements Longitud {

	private double resultado;
	
	@Override
	public double calculo(double valor) {
		double valorMilimetro = ValorLongitud.MILIMETRO.getValor();
		double valorCentimetro = ValorLongitud.CENTIMETRO.getValor();
		resultado = (valor * valorCentimetro) / valorMilimetro;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}	
	
}
