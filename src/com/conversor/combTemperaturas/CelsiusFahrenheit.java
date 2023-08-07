package com.conversor.combTemperaturas;

import com.conversor.Redondear;
import com.conversor.combLongitud.Longitud;

public class CelsiusFahrenheit implements Longitud {

	@Override
	public double calculo(double valor) {
		double conversion = ValorTemperatura.FAHRENHEIT.getValor();
		double resultado = (valor * conversion) + 32;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}

}
