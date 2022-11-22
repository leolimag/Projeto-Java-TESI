package br.com.telefonia;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private float creditos;
	private int numRecargas;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero, int numChamadas, int numRecargas, float creditos) {
		super(cpf, nome, numero, numChamadas);
		this.recargas = new Recarga[numRecargas];
		this.creditos = creditos;
		this.numRecargas = numRecargas;
	}

	public boolean recarregar(GregorianCalendar data, float valor) {
		for (int i = 0; i < this.recargas.length; i++) {
			if (this.recargas[i] == null) {
				Recarga r = new Recarga(data, valor);
				this.recargas[i] = r;
				this.creditos = this.creditos + valor;
				// this.numRecargas++;
				return true;
			} else {
				return false; // se for falso, imprimir uma mensagem no main
			}
		}
		return false;
	}

	public boolean fazerChamada(GregorianCalendar data, int duracao) {
		float custo = duracao * 1.45f;
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i] == null && this.creditos > custo) {
				Chamada c = new Chamada(data, duracao);
				this.chamadas[i] = c;
				// this.numChamadas++;
				this.creditos = this.creditos - custo;
				return true;
			} else {
				return false; // se for false, imprimir uma mensagem no main
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
		for (int i = 0; i < this.recargas.length; i++) {
			if (this.recargas[i].getData().get(GregorianCalendar.MONTH) == mes) {
				return "Recarga - " + this.recargas.toString();
			}
		}
		return null;
		// imprimir ainda o valor total de todas as ligações e recargas, além dos
		// créditos
	}

}
