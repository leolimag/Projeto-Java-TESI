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
		this.prepagos = new PrePago[50];
		this.pospagos = new PosPago[50];
	}

	public void cadastrarAssinante(int opcao, String nome, long cpf, long numero, float creditos, float assinatura) {
		if (opcao == 1) {
			this.numPrePagos++;
			for (int i = 0; i < this.numPrePagos; i++) {
				if (this.prepagos[i] == null) {
					PrePago pre = new PrePago(cpf, nome, numero, creditos);
					this.prepagos[i] = pre;
					System.out.println("Cadastro realizado.\n");
				} 
			}
		} else if (opcao == 2) {
			this.numPosPagos++;
			for (int i = 0; i < this.numPosPagos; i++) {
				if (this.pospagos[i] == null) {
					PosPago pos = new PosPago(cpf, nome, numero, assinatura);
					this.pospagos[i] = pos;
					System.out.println("Cadastro realizado.\n");
				}
			}
		} else {
			System.out.println("Opção inexistente.\n");
		}
	}


	public void listarAssinantes() {
		System.out.println("Assinantes Pré-Pago: \n");
		if (this.numPrePagos == 0) {
			System.out.println("Não há assinantes pré-pago cadastrados.\n");
		} else {
			for (int i = 0; i < this.numPrePagos; i++) {
				if (this.prepagos[i] != null) {
					System.out.println(this.prepagos[i].toString());
					System.out.println();
				}
			}
		}
		System.out.println("Assinantes Pós-Pago: \n");
		if (this.numPosPagos == 0) {
			System.out.println("Não há assinantes pós-pago cadastrados.\n");
		} else {
			for (int i = 0; i < this.numPosPagos; i++) {
				if (this.pospagos[i] != null) {
					System.out.println(this.pospagos[i].toString());
					System.out.println();
				}
			}
		}
	}

	public void fazerChamada(int tipo, long cpf, int duracao, GregorianCalendar data) {
		if (tipo == 1) {
			if (this.localizarPrePago(cpf) != null) {
				PrePago ass = this.localizarPrePago(cpf);
				System.out.println(ass.fazerChamada(data, duracao));
			} else {
				System.out.println("Assinante não encontrado. Tente outro CPF.\n");
			}
		} else if (tipo == 2) {
			if (this.localizarPosPago(cpf) != null) {
				PosPago ass = this.localizarPosPago(cpf);
				System.out.println(ass.fazerChamada(data, duracao));
			} else {
				System.out.println("Assinante não encontrado. Tente outro CPF.\n");
			}
		} else {
			System.out.println("Opção inválida. Escolha outra opção.\n");
		}
	}

	public void fazerRecarga(long cpf, float valor, GregorianCalendar data) {
		if (this.localizarPrePago(cpf) != null) {
			PrePago ass = this.localizarPrePago(cpf);
			System.out.println(ass.recarregar(data, valor));
		} else {
			System.out.println("Assinante não encontrado. Tente outro CPF.\n");
		}
		
	}

	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < this.numPrePagos; i++) {
			if (this.prepagos[i].getCpf() == cpf) {
				return this.prepagos[i];
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < this.numPosPagos; i++) {
			if (this.pospagos[i].getCpf() == cpf) {
				return this.pospagos[i];
			}
		}
		return null;
	}

	public void imprimirFaturas(int mes) {
		if (this.numPrePagos == 0) {
			System.out.println("Não há assinantes pré-pago cadastros.\n");
		}
		if (this.numPosPagos == 0) {
			System.out.println("Não há assinantes pós-pago cadastros.\n");
		}
		
		for (int i = 0; i < this.numPrePagos; i++) {
			if (this.prepagos[i].numChamadas > 0) {
				this.prepagos[i].imprimirFatura(mes);
			} else {
				System.out.println("Assinantes Pré-Pago: \n");
				System.out.println(this.prepagos[i].toString() + "\n" + "Não há movimentações deste assinante.\nCréditos: " + this.prepagos[i].creditos + "\n");	
			}

		}
		for (int i = 0; i < this.numPosPagos; i++) {
			if (this.pospagos[i].numChamadas > 0) {
				this.pospagos[i].imprimirFatura(mes);
			} else {
				System.out.println("Assinantes Pós-Pago: \n");
				System.out.println(this.pospagos[i].toString() + "\n" + "Não há movimentações deste assinante.\nAssinatura: " + this.pospagos[i].assinatura + "\n");	
			}
		}
	}

	public static void main(String[] args) {
		float creditos = 0;
		long cpf = 0;
		int tipo;
		String nome = "";
		long numTelefone = 0;
		GregorianCalendar calendar;
		float assinatura = 0;
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int opcao = 1;
		Telefonia t = new Telefonia(10, 10);
		while (opcao != 0) {
			System.out.println("Escolha uma opção: ");
			System.out.println(
					"1- Cadastrar assinante \n2- Listar assinantes \n3- Fazer chamada \n4- Recarregar \n5- Imprimir faturas\n0- Sair\n");
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Qual o tipo de assinante?\n 1- Pré Pago\n 2- Pós Pago ");
				tipo = s.nextInt();
				s.nextLine();
				if (tipo == 1) {
					System.out.println("Insira seu nome: ");
					nome = s.nextLine();
					System.out.println("Insira seu CPF: ");
					cpf = s.nextLong();
					System.out.println("Insira seu número de telefone: ");
					numTelefone = s.nextLong();
					System.out.println("Insira a quantidade de créditos: ");
					creditos = s.nextFloat();
				} else if (tipo == 2) {
					System.out.println("Insira seu nome: ");
					nome = s.nextLine();
					System.out.println("Insira seu CPF: ");
					cpf = s.nextLong();
					System.out.println("Insira seu número de telefone: ");
					numTelefone = s.nextLong();
					System.out.println("Insira sua assinatura: ");
					assinatura = s.nextFloat();
				} else {
					System.out.println("Opção inexistente.\n");
				}
				t.cadastrarAssinante(tipo, nome, cpf, numTelefone, creditos, assinatura);
				break;
			case 2:
				t.listarAssinantes();
				break;
			case 3:
				System.out.println("Qual o tipo de assinante?\n 1- Pré Pago\n 2- Pós Pago");
				tipo = s.nextInt();
				System.out.println("Insira seu CPF: ");
				cpf = s.nextLong();
				calendar = new GregorianCalendar();
				System.out.println("Insira a duração da ligação: ");
				int duracao = s.nextInt();
				t.fazerChamada(tipo, cpf, duracao, calendar);
				break;
			case 4:
				System.out.println("Insira seu CPF: ");
				cpf = s.nextLong();
				System.out.println("Insira o valor da recarga:");
				float valor = s.nextFloat();
				calendar = new GregorianCalendar();
				t.fazerRecarga(cpf, valor, calendar);
				break;
			case 5:
				System.out.println("Insira o número do mês correspondente à lista: \n0-JAN; \n1-FEV; \n2-MAR; \n3-ABR; \n4-MAI; \n5-JUN; \n6-JUL; \n7-AGO; \n8-SET; \n9-OUT; \n10-NOV; \n11-DEZ.");
				int mes = s.nextInt();
				if (mes >= 0 && mes <= 11) {
					t.imprimirFaturas(mes);
				} else {
					System.out.println("Insira um número correspondente ao mês da lista.");
				}
				break;
			case 0:
				System.out.println("Encerrando sistema.");
				break;
			default:
				System.out.println("Insira uma opção válida.\n");
			}
		}

	}

}