package com.conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Redondear {

	public double redondearValor(double valor) {
		BigDecimal bigd = new BigDecimal(valor).setScale(3, RoundingMode.HALF_EVEN);
		valor = bigd.doubleValue();
		return valor;
	}
	
}
