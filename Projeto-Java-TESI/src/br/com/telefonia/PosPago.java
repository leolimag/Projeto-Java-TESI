package br.com.telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private float assinatura;

	public PosPago(long cpf, String nome, int numero, float assinatura,int numChamadas) {
		super(cpf, nome, numero, numChamadas);
		this.assinatura = assinatura;
	}
	
	public boolean fazerChamada(GregorianCalendar data, int duracao) {
		float custo = duracao * 1.04f;
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i] == null) {
				Chamada c = new Chamada(data, duracao);
				this.chamadas[i] = c;
				//this.numChamadas++;
				return true;
			} else {
				return false; //se for false, imprimir uma mensagem no main
			}
		}
		return false;
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