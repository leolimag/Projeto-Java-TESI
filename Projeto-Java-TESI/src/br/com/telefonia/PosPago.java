package br.com.telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}
	
	public boolean fazerChamada(GregorianCalendar data, int duracao) {
		float custo = duracao * 1.04f;
		if (this.chamadas.length < 10) { //ver aqui
			Chamada c = new Chamada(data, duracao); 
			this.chamadas[this.chamadas.length -1] = c;
			this.numChamadas++; //ou --?
			return true;
		} else {
			return false; //se for false, imprimir uma mensagem no main 
		}
	}
	
	public String imprimirFatura(int mes) {
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
				return "Assinante - " + this.toString() + "|" + "Chamada - " + this.chamadas.toString();
			}
		}
		return "Valor total da fatura: " + this.assinatura; //imprimir total (calcular ligações)
	}

}