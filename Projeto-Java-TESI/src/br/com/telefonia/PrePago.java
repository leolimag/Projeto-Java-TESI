package br.com.telefonia;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	
	private float creditos;
	private int numRecargas;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero) {
		super(cpf, nome, numero);
		this.recargas = new Recarga[numRecargas];
		//this.creditos = creditos;
		//this.numRecargas = numRecargas;
	}
	
	public boolean recarregar(GregorianCalendar data, float valor) {
		if (this.recargas.length < this.numRecargas) { //ver aqui 
			Recarga r = new Recarga(data,valor);
			this.recargas[this.recargas.length - 1] = r;
			this.numRecargas++;
			this.creditos = this.creditos + valor;
			return true;
		} else {
			return false; //se for falso, imprimir uma mensagem no main 
		}
	}
	
	public boolean fazerChamada(GregorianCalendar data, int duracao) { 
		float custo = duracao * 1.45f;
		if (this.chamadas.length < 10 && this.creditos > 1.45f) { //ver aqui
			Chamada c = new Chamada(data, duracao);
			this.chamadas[this.chamadas.length - 1] = c;
			this.numChamadas++; //ou --?
			this.creditos = this.creditos - custo;
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
		for (int i = 0; i < this.recargas.length; i++) {
			if (this.recargas[i].getData().get(GregorianCalendar.MONTH) == mes) {
				return "Recarga - " + this.recargas.toString();
			}
		}
		return null;
		// imprimir ainda o valor total de todas as ligações e recargas, além dos créditos
	}

}