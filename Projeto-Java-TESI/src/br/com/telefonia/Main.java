package br.com.telefonia;

public class Main {

	public static void main(String[] args) {
		// teste do método toString
		Data d = new Date();
		Chamada  c = new Chamada(d, 50);
		System.out.println(c.toString());
	}

}
