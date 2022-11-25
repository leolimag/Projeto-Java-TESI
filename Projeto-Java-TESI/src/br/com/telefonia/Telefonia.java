package br.com.telefonia;

import java.util.GregorianCalendar;

public class Telefonia {
	private PrePago[] prepagos;
	private PosPago[] pospagos;
	private int numPrePagos;
	private int numPosPagos;

	public Telefonia(int numPrePagos, int numPosPagos) {
		super();
		this.prepagos = new PrePago[numPrePagos]; 
		this.pospagos = new PosPago[numPosPagos];
		this.numPosPagos = numPosPagos;
		this.numPrePagos = numPrePagos;
	}

	public boolean cadastrarAssinante(String nome, long cpf, int numero, int numChamadas, int numRecargas, float creditos) {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i] == null) {
				PrePago pre = new PrePago(cpf, nome, numero, numChamadas, numRecargas, creditos);
				this.prepagos[i] = pre;
				//this.numPrePagos++;
				return true;
			} else {
				return false; //mensagem na main
			}
		}
		return false;
	}

	public boolean cadastrarAssinante(String nome, long cpf, int numero, float assinatura, int numChamadas) {
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] == null) {
				PosPago pos = new PosPago(cpf, nome, numero, assinatura, numChamadas);
				this.pospagos[i] = pos;
				//this.numPosPagos++;
				return true;
			} else {
				return false; // mensagem na main 
			}
		}
		return false;
	}
	
	public String listarAssinantes() {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i] != null) {
				return this.prepagos[i].toString();
			}
		}
		System.out.println(); //verificar
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] != null) {
				return this.pospagos[i].toString();
			}	
		}
		return null;
	}
	
	public String fazerChamada(int tipo, long cpf, int duracao, GregorianCalendar data) {
		if (tipo == 1) { //prepago
			if (this.localizarPrePago(cpf) != null) {
				PrePago ass = this.localizarPrePago(cpf);
				ass.fazerChamada(data, duracao);
				return "Chamada realizada!";
			} else {
				return "Assinante não encontrado. Tente outro CPF.";
			}
		} else if (tipo == 2) {
			if (this.localizarPosPago(cpf) != null) {
				PosPago ass = this.localizarPosPago(cpf);
				ass.fazerChamada(data, duracao);
				return "Chamada realizada!";
			} else {
				return "Assinante não encontrado. Tente outro CPF.";
			}
		} else {
			return "Opção inválida. Escolha outra opção.";
		}
	}
	
	public String fazerRecarga(long cpf, float valor, GregorianCalendar data) {
		if (this.localizarPrePago(cpf) != null) {
			PrePago ass = this.localizarPrePago(cpf);
			ass.recarregar(data, valor);
			return "Recarga realizada!"; //essa mensagem ou a do método "recarregar"? //todas as mensagens no main?
		} else {
			return "Assinante não encontrado. Tente outro CPF.";
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
	
	public void imprimirFaturas(int mes) {
		for (int i = 0; i < this.prepagos.length; i++) {
			this.prepagos[i].imprimirFatura(mes);
		}
		for (int i = 0; i < this.pospagos.length; i++) {
			this.pospagos[i].imprimirFatura(mes);
		}
	}
	
	
	
	
	


}