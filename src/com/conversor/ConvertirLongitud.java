package com.conversor;

import java.util.HashMap;
import java.util.Map;

import com.conversor.combLongitud.CentimetroMetro;
import com.conversor.combLongitud.CentimetroMilimetro;
import com.conversor.combLongitud.Longitud;
import com.conversor.combLongitud.MetroCentimetro;
import com.conversor.combLongitud.MetroMilimetro;
import com.conversor.combLongitud.MilimetroCentimetro;
import com.conversor.combLongitud.MilimetroMetro;


public class ConvertirLongitud {

	private String longitud_1;
	private String longitud_2;

	private double valor_1;
	private double resultado;

	public ConvertirLongitud(String longitud_1, String longitud_2, String textField_1) {
		this.longitud_1 = longitud_1;
		this.longitud_2 = longitud_2;
		this.valor_1 = Double.parseDouble(textField_1);
	}
	
	public double Calcular() {
		
		String combinacionLongitud = this.longitud_1 + this.longitud_2;
		
		if (this.longitud_1 != this.longitud_2) {
		
		Map<String, Longitud> conversionMap = new HashMap<>();
		conversionMap.put("METROMILIMETRO", new MetroMilimetro());
		conversionMap.put("METROCENTIMETRO", new MetroCentimetro());
		conversionMap.put("MILIMETROCENTIMETRO", new MilimetroCentimetro());
		conversionMap.put("MILIMETROMETRO", new MilimetroMetro());
		conversionMap.put("CENTIMETROMILIMETRO", new CentimetroMilimetro());
		conversionMap.put("CENTIMETROMETRO", new CentimetroMetro());

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



 
