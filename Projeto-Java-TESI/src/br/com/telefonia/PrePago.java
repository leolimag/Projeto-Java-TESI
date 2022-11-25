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

	public String fazerChamada(GregorianCalendar data, int duracao) {
		float custo = duracao * 1.45f;
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i] == null) {
				if (this.creditos > custo) {
					Chamada c = new Chamada(data, duracao);
					this.chamadas[i] = c;
					// this.numChamadas++;
					this.creditos = this.creditos - custo;
					return "Chamada concluída.";
				} else {
					return "Créditos insuficientes. Recarregue para fazer mais ligações!";
				}
			} else {
				return "Não é possível realizar mais ligações. Limite alcançado."; // se for false, imprimir uma mensagem no main
			}
		}
		return null;
	}	

	public String imprimirFatura(int mes) {
		float totalC = 0;
		float totalR = 0;
		for (int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					int duracao = this.chamadas[i].getDuracao();
					float custo = duracao * 1.45f;
					totalC += custo;
					return "Assinante - " + this.toString() + "|" + "Chamada - " + this.chamadas.toString();
				}
			} else {
				return null;
			}
		}
		for (int i = 0; i < this.recargas.length; i++) {
			if (this.recargas[i] != null) {
				if (this.recargas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					float valor = this.recargas[i].getValor();
					totalR += valor;
					return "Recarga - " + this.recargas.toString();
				}	
			} else {
				return null;
			}
		}
		return "Total chamada: " + totalC + " | " + "Total recarga: " + totalR + " | " + this.creditos;
	}

}