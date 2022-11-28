package br.com.telefonia;

import java.util.GregorianCalendar;
import java.util.Scanner;

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

	public boolean cadastrarAssinante(String nome, long cpf, int numero, int numChamadas, int numRecargas,
			float creditos) {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i] == null) {
				PrePago pre = new PrePago(cpf, nome, numero, numChamadas, numRecargas, creditos);
				this.prepagos[i] = pre;
				// this.numPrePagos++;
				return true;
			} else {
				return false; // mensagem na main
			}
		}
		return false;
	}

	public boolean cadastrarAssinante(String nome, long cpf, int numero, float assinatura, int numChamadas) {
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] == null) {
				PosPago pos = new PosPago(cpf, nome, numero, assinatura, numChamadas);
				this.pospagos[i] = pos;
				// this.numPosPagos++;
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
		System.out.println(); // verificar
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] != null) {
				return this.pospagos[i].toString();
			}
		}
		return null;
	}

	public String fazerChamada(int tipo, long cpf, int duracao, GregorianCalendar data) {
		if (tipo == 1) { // prepago
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
			if (ass.recarregar(data, valor)) {
				ass.recarregar(data, valor);
				return "Recarga realizada!";
			} else {
				return "Não é possível fazer mais recargas.";
			}
		} else {
			return "Assinante não encontrado. Tente outro CPF.";
		}
	}

	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i].getCpf() == cpf) {
				return this.prepagos[i];
			} else {
				return null; // precisa?
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
			if (this.prepagos[i] != null) {
				this.prepagos[i].imprimirFatura(mes);
			}

		}
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] != null) {
				this.pospagos[i].imprimirFatura(mes);
			}
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int opcao = 1;
		Telefonia t = new Telefonia(10,10);
		while (opcao != 0) {
			System.out.println("Escolha uma opção: ");
			System.out.println("1- Cadastrar assinante \n2- Listar assinantes \n3- Fazer chamada \n4- Recarregar \n5- Imprimir faturas\n0- Sair\n");
			opcao = s.nextInt();
			switch (opcao) {
				case 1:
					System.out.println("Qual o tipo de assinante?\n 1- Pré Pago\n 2- Pós Pago ");
					int tipo = s.nextInt();
					if (tipo == 1) {
						boolean cadastro = t.cadastrarAssinante("Beatriz", 39898360, 1399787, 10, 10, 50);
						if (cadastro == true) {
							t.cadastrarAssinante("Beatriz", 39898360, 1399787, 10, 10, 50);	
							System.out.println("Cadastro completo.");
						} else {
							System.out.println("Cadastro incompleto.");
						}
						
					} else if (tipo == 2) {
						boolean cadastro = t.cadastrarAssinante("Leonardo", 475731378, 139811, 40f, 10);
						if (cadastro == true) {
							t.cadastrarAssinante("Leonardo", 475731378, 139811, 40f, 10);
							System.out.println("Cadastro completo.");
						} else {
							System.out.println("Cadastro incompleto.");
						}
					} else {
						System.out.println("Opção inexistente.");
					}
					break;
				case 2: 
					System.out.println(t.listarAssinantes());
					System.out.println();
					break;
				case 3: 
					long cpf = s.nextLong();
					int tip = s.nextInt();
					GregorianCalendar c = new GregorianCalendar();
					t.fazerChamada(tip, cpf, 10, c);
			}
		}

	}

}