package br.com.telefonia;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Chamada {
	
	private Calendar data;
	private int duracao;

	
	public Chamada(Calendar data, int duracao) {
		super();
		this.data = data;
		this.duracao = duracao;
	}

	public Calendar getData() {
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
		String novaData = new SimpleDateFormat("dd/MM/yyyy").format(data);
		return "data: " + novaData + ", " + this.duracao + " minutos de duração.";
	}
	/*
	public static void main(String[]args) {
		Calendar ca = Calendar.getInstance();
		Date d = ca.getTime();
		Chamada c = new Chamada(d, 50);
		System.out.println(c.toString());
	}
	*/
	
}
