package com.conversor.combTemperaturas;

import com.conversor.Redondear;
import com.conversor.combLongitud.Longitud;

public class FahrenheitKelvin implements Longitud {

	@Override
	public double calculo(double valor) {
		double conversionFah = ValorTemperatura.FAHRENHEIT.getValor();
		double conversionKel = ValorTemperatura.KELVIN.getValor();
		double resultado = (valor - 32) * (1 / conversionFah) + conversionKel;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}

}
