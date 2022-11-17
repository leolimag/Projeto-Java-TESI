package br.com.telefonia;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// teste do método toString
		Calendar ca = Calendar.getInstance();
		Date d = ca.getTime();
		Chamada  c = new Chamada(d, 50);
		System.out.println(c.toString());
	}

}
