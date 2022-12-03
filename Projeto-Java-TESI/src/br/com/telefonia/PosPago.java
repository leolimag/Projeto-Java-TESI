package br.com.telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	protected float assinatura;

	public PosPago(long cpf, String nome, long numero, float assinatura) {
		super(cpf, nome, numero);
		this.assinatura = assinatura;
	}

	public String fazerChamada(GregorianCalendar data, int duracao) {
		this.numChamadas++;
		for (int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] == null) { 
				Chamada c = new Chamada(data, duracao);
				this.chamadas[i] = c;
				return "Chamada concluída.\n";
			}
		}
		return "Chamada não efetuada.\n";
	}

	public void imprimirFatura(int mes) {
		float totalC = 0;
		System.out.println("Assinantes Pós-Pago: \n");
		for (int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					int duracao = this.chamadas[i].getDuracao();
					float custo = duracao * 1.04f;
					totalC += custo;
					System.out.println(this.toString() + "\n" + "Chamada - " + this.chamadas[i].toString() + "\n");
				} else {
					System.out.println("Nenhuma chamada realizada neste mês.\n");
				}
			}
		}
		System.out.println("Valor total da fatura: " + this.assinatura + totalC + " | " + "Assinatura: " + this.assinatura + "\n");
	}

}