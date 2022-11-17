package br.com.telefonia;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Chamada {
	
	private Date data;
	private int duracao;

	
	public Chamada(Date data, int duracao) {
		super();
		this.data = data;
		this.duracao = duracao;
	}

	public Date getData() {
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
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		return "data: " + data;
	}
	/*
	public static void main(String[]args) {
		Date d = new Date();
		Chamada c = new Chamada(d, 50);
		System.out.println(c.toString());
	}
	*/
	
}
