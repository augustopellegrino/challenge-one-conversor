package com.conversor;

import java.util.HashMap;
import java.util.Map;

import com.conversor.combMonedas.DolarEuro;
import com.conversor.combMonedas.DolarLibra;
import com.conversor.combMonedas.DolarPeso;
import com.conversor.combMonedas.EuroDolar;
import com.conversor.combMonedas.EuroLibra;
import com.conversor.combMonedas.EuroPeso;
import com.conversor.combMonedas.LibraDolar;
import com.conversor.combMonedas.LibraEuro;
import com.conversor.combMonedas.LibraPeso;
import com.conversor.combMonedas.Monedas;
import com.conversor.combMonedas.PesoDolar;
import com.conversor.combMonedas.PesoEuro;
import com.conversor.combMonedas.PesoLibra;

public class ConvertirMonedas {

	private String moneda_1;
	private String moneda_2;

	private double valor_1;
	private double resultado;

	public ConvertirMonedas(String moneda_1, String moneda_2, String textField_1) {
		this.moneda_1 = moneda_1;
		this.moneda_2 = moneda_2;
		this.valor_1 = Double.parseDouble(textField_1);
	}
	
	public double Calcular() {
		
		String combinacionMonedas = this.moneda_1 + this.moneda_2;
		
		if (this.moneda_1 != this.moneda_2) {
			
			Map<String, Monedas> conversionMap = new HashMap<>();
			conversionMap.put("PESODOLAR", new PesoDolar());
			conversionMap.put("PESOEURO", new PesoEuro());
			conversionMap.put("PESOLIBRA", new PesoLibra());
			conversionMap.put("DOLARPESO", new DolarPeso());
			conversionMap.put("DOLAREURO", new DolarEuro());
			conversionMap.put("DOLARLIBRA", new DolarLibra());
			conversionMap.put("EUROPESO", new EuroPeso());
			conversionMap.put("EURODOLAR", new EuroDolar());
			conversionMap.put("EUROLIBRA", new EuroLibra());
			conversionMap.put("LIBRAPESO", new LibraPeso());
			conversionMap.put("LIBRADOLAR", new LibraDolar());
			conversionMap.put("LIBRAEURO", new LibraEuro());
			
			Monedas convertirMoneda = conversionMap.get(combinacionMonedas);
			resultado = convertirMoneda.calculo(this.valor_1);
			return resultado;
			
		} else {
			
			Redondear redondear = new Redondear();
			double valorRedondeado = redondear.redondearValor(this.valor_1);
			return valorRedondeado;
		}
		
		
	}	

}



 
