package com.conversor.combTemperaturas;

import com.conversor.Redondear;
import com.conversor.combLongitud.Longitud;

public class CelsiusKelvin implements Longitud {

	@Override
	public double calculo(double valor) {
		double conversion = ValorTemperatura.KELVIN.getValor();
		double resultado = valor + conversion;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}
}
