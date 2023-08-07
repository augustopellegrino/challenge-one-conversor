package com.conversor.combTemperaturas;

import com.conversor.Redondear;
import com.conversor.combLongitud.Longitud;

public class FahrenheitCelsius implements Longitud {

	@Override
	public double calculo(double valor) {
		double conversion = ValorTemperatura.FAHRENHEIT.getValor();
		double resultado = (valor - 32) * (1 / conversion);
		Redondear redondear = new Redondear();
		return redondear.redondearValor(resultado);
	}

}
