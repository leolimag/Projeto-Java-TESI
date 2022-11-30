package br.com.telefonia;

import java.util.GregorianCalendar;

public class PosPago extends Assinante {
	private float assinatura;

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
				return "Chamada concluída.";
			}
		}
		return "Chamada não efetuada.";
	}

	public void imprimirFatura(int mes) {
		System.out.println("Assinantes Pós-Pago: \n");
		for (int i = 0; i < this.numChamadas; i++) {
			if (this.chamadas[i] != null) {
				if (this.chamadas[i].getData().get(GregorianCalendar.MONTH) == mes) {
					System.out.println(this.toString() + "\n" + "Chamada - " + this.chamadas[i].toString());
				} else {
					System.out.println("Nenhuma chamada realizada neste mês.\n");
				}
			}
		}
		System.out.println("Valor total da fatura: " + this.assinatura + "\n");
	}

}