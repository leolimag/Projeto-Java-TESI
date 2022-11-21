package br.com.telefonia;

import java.util.GregorianCalendar;

public class Telefonia {
	private PrePago[] prepagos;
	private PosPago[] pospagos;
	private int numPrePagos;
	private int numPosPagos;

	public Telefonia() {
		super();
		this.prepagos = new PrePago[this.numPrePagos]; // verificar tamanho do vetors
		this.pospagos = new PosPago[this.numPosPagos];
	}

	public boolean cadastrarAssinante(String nome, long cpf, int numero) {
		if (this.prepagos.length < 10) {
			PrePago pre = new PrePago(cpf, nome, numero);
			this.prepagos[this.prepagos.length - 1] = pre;
			this.numPrePagos++;
			return true;
		} else {
			return false; //mensagem na main
		}

	}

	public boolean cadastrarAssinante(String nome, long cpf, int numero, float assinatura) {
		if (this.pospagos.length < 10) {
			PosPago pos = new PosPago(cpf, nome, numero, assinatura);
			this.pospagos[this.pospagos.length - 1] = pos;
			this.numPosPagos++;
			return true;
		} else {
			return false; // mensagem na main
		}
	}
	
	public String listarAssinantes() {
		for (int i = 0; i < this.prepagos.length; i++) {
			return this.prepagos[i].toString();
		}
		System.out.println(); //verificar
		for (int i = 0; i < this.pospagos.length; i++) {
			return this.pospagos[i].toString();
		}
		return null;
	}
	
	public void fazerChamada(int tipo, long cpf, int duracao, GregorianCalendar data) {
		if (tipo == 1) { //prepago
			if (this.localizarPrePago(cpf) != null) {
				
			}
		}
	}
	
	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i].getCpf() == cpf) {
				return this.prepagos[i];
			} else {
				return null; //precisa?
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i].getCpf() == cpf) {
				return this.pospagos[i];
			} else {
				return null;
			}
		}
		return null;
	}
	
	
	
	
	
	
	


}