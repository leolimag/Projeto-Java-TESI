package br.com.telefonia;

import java.util.GregorianCalendar;

public class PrePago extends Assinante {

	private float creditos;
	private int numRecargas;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, long numero, float creditos) {
		super(cpf, nome, numero);
		this.recargas = new Recarga[50];
		this.creditos = creditos;
	}

	public String recarregar(GregorianCalendar data, float valor) {
		this.numRecargas++;
		for (int i = 0; i < this.numRecargas; i++) {
			if (this.recargas[i] == null) {
				Recarga r = new Recarga(data, valor);
				this.recargas[i] = r;
				this.creditos = this.creditos + valor;
				return "Crédito no valor de R$" + valor + ",00 inserido.\n";
			}
		}
		return "Crédito não efetuado.\n";
	}

	public String fazerChamada(GregorianCalendar data, int duracao) {
		float custo = duracao * 1.45f;
		this.numChamadas++;
		for (int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] == null && this.creditos > custo) {
					Chamada c = new Chamada(data, duracao);
					this.chamadas[i] = c;
					this.creditos = this.creditos - custo;
					return "Chamada concluída.";
			} else if (this.chamadas[i] == null && this.creditos < custo) {
				this.numChamadas--;
				return "Créditos insuficientes. Recarregue para fazer mais ligações!\n";
			}
		}
		return "Não é possível realizar mais ligações. Limite alcançado.\n";
	}

	public void imprimirFatura(int mes) {
		float totalC = 0;
		float totalR = 0;
		System.out.println("Assinantes Pré-Pago: \n");
		for (int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					int duracao = this.chamadas[i].getDuracao();
					float custo = duracao * 1.45f;
					totalC += custo;
					System.out.println(this.toString() + "\n" + "Chamada - " + this.chamadas[i].toString() + "\n");
				} else {
				System.out.println("Nenhuma chamada realizada neste mês.\n");
				}
			} 


		}
		for (int i = 0; i < this.numRecargas; i++) {
			if (this.recargas[i] != null) {
				if (this.recargas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					float valor = this.recargas[i].getValor();
					totalR += valor;
					System.out.println("Recarga - " + this.recargas[i].toString() + "\n");
				} 
			} else {
					System.out.println("Nenhuma recarga realizada neste mês.\n");
				}
		}
		System.out.println("Total chamada: " + totalC + " | " + "Total recarga: " + totalR + " | " + "Créditos: "
				+ this.creditos + "\n");
	}

}