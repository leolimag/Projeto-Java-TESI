package br.com.telefonia;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* teste 
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int c = 0;
		int x = 0;
		Chamada[] chamada = new Chamada[10];
		while (c != 1) {
			System.out.println("digite uma opção: /n");
			c = s.nextInt();
			if (c == 2) {
				System.out.println("digite a duração: /n");
				int d = s.nextInt();
				GregorianCalendar ca = new GregorianCalendar();
				Chamada ch = new Chamada(ca, d);
				System.out.println(ch.toString());
				chamada[x] = ch;
				x++;
			}
		}
		for (int i = 0; i < chamada.length; i++) {
			System.out.println(chamada[i]);
		}
		*/
		
		Telefonia t = new Telefonia(10, 10);
		t.cadastrarAssinante("Leonardo", 475731378, 139811, 40f, 10);
		t.cadastrarAssinante("Beatriz", 39898360, 1399787, 10, 10, 50);

		System.out.println(t.listarAssinantes());
		
		/*
		for (int i = 0; i < t.pospagos.length; i++) {
			System.out.println(t.pospagos[i]);
		}
		*/
		
		t.imprimirFaturas(1);
		
		
		
		
		
		
		
		
		
	}

}