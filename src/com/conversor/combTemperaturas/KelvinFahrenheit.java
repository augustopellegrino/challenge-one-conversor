package com.conversor.combTemperaturas;

import com.conversor.Redondear;
import com.conversor.combLongitud.Longitud;

public class KelvinFahrenheit implements Longitud {

	@Override
	public double calculo(double valor) {
		double conversionFah = ValorTemperatura.FAHRENHEIT.getValor();
		double conversionKel = ValorTemperatura.KELVIN.getValor();
		double resultado = (valor - conversionKel) * conversionFah + 32;
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}


}
