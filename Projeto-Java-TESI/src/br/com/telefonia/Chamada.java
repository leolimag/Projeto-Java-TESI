package br.com.telefonia;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Chamada {
		
	private GregorianCalendar data;
	private int duracao;

	
	public Chamada(GregorianCalendar data, int duracao) {
		super();
		this.data = data;
		this.duracao = duracao;
	}

	public GregorianCalendar getData() {
		return data;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	@Override
	public String toString() {
		Date data = this.data.getTime();
		String novaData = new SimpleDateFormat("dd/MM/yyyy").format(data);
		return "data: " + novaData + ", " + this.duracao + " minutos de duração.";
	}
	
}
