package br.com.telefonia;

import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// teste do método toString
		Date d = new Date();
		Chamada  c = new Chamada(d, 50);
		System.out.println(c.toString());
	}

}
