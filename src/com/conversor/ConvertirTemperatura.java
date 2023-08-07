package com.conversor;

import java.util.HashMap;
import java.util.Map;

import com.conversor.combLongitud.Longitud;
import com.conversor.combTemperaturas.CelsiusFahrenheit;
import com.conversor.combTemperaturas.CelsiusKelvin;
import com.conversor.combTemperaturas.FahrenheitCelsius;
import com.conversor.combTemperaturas.FahrenheitKelvin;
import com.conversor.combTemperaturas.KelvinCelsius;
import com.conversor.combTemperaturas.KelvinFahrenheit;


public class ConvertirTemperatura {

	private String temperatura_1;
	private String temperatura_2;

	private double valor_1;
	private double resultado;

	public ConvertirTemperatura(String longitud_1, String longitud_2, String textField_1) {
		this.temperatura_1 = longitud_1;
		this.temperatura_2 = longitud_2;
		this.valor_1 = Double.parseDouble(textField_1);
	}
	
	public double Calcular() {
		
		String combinacionLongitud = this.temperatura_1 + this.temperatura_2;
		
		if (this.temperatura_1 != this.temperatura_2) {
		
		Map<String, Longitud> conversionMap = new HashMap<>();
		conversionMap.put("CELSIUSFAHRENHEIT", new CelsiusFahrenheit());
		conversionMap.put("CELSIUSKELVIN", new CelsiusKelvin());
		conversionMap.put("FAHRENHEITCELSIUS", new FahrenheitCelsius());
		conversionMap.put("FAHRENHEITKELVIN", new FahrenheitKelvin());
		conversionMap.put("KELVINCELSIUS", new KelvinCelsius());
		conversionMap.put("KELVINFAHRENHEIT", new KelvinFahrenheit());

		Longitud convertirLongitud = conversionMap.get(combinacionLongitud);
		resultado = convertirLongitud.calculo(this.valor_1);
		return resultado;
		
		} else {
			
			Redondear redondear = new Redondear();
			double valorRedondeado = redondear.redondearValor(this.valor_1);
			return valorRedondeado;
			
		}
	}	

}



 
