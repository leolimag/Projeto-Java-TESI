package br.com.telefonia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Recarga {
	
	private GregorianCalendar data;
	private float valor;
	
	public Recarga(GregorianCalendar data, float valor) {
		super();
		this.data = data;
		this.valor = valor;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString(){
		Date data = this.data.getTime();
;		String novaData = new SimpleDateFormat("dd/MM/yyyy").format(data);
		return "Data: " + novaData + ", valor de R$" + this.valor + ".";
	}
	
	
}
