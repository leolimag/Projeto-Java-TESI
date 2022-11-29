package br.com.telefonia;

import java.util.GregorianCalendar;
import java.util.Random;
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
	}

	public void cadastrarAssinante(String nome, long cpf, long numero, int numChamadas, int numRecargas,
			float creditos) {
		this.numPrePagos++;
		for (int i = 0; i < this.numPrePagos; i++) {
			if (this.prepagos[i] == null) {
				PrePago pre = new PrePago(cpf, nome, numero, numChamadas, numRecargas, creditos);
				this.prepagos[i] = pre;
				System.out.println("Cadastro realizado.");
				//return true;
			} //else {
				//return false;
			//}
		}
		//return false;
	}

	public void cadastrarAssinante(String nome, long cpf, long numero, float assinatura, int numChamadas) {
		this.numPosPagos++;
		for (int i = 0; i < this.numPosPagos; i++) {
			if (this.pospagos[i] == null) {
				PosPago pos = new PosPago(cpf, nome, numero, assinatura, numChamadas);
				this.pospagos[i] = pos;
				System.out.println("Cadastro realizado.");
			} 
		}
	}

	public void listarAssinantes() {
		for (int i = 0; i < this.numPrePagos; i++) {
			if (this.prepagos[i] != null) {
				//return this.prepagos[i].toString();
				System.out.println(this.prepagos[i].toString());
				System.out.println();
			} else {
				System.out.println("Não há assinantes pré-pago cadastrados.");
			}
		}
		for (int i = 0; i < this.numPosPagos; i++) { 
			if (this.pospagos[i] != null) {
				//return this.pospagos[i].toString();
				System.out.println(this.pospagos[i].toString());
				System.out.println();
			} else {
				System.out.println("Não há assinantes pós-pago cadastrados.");
			}
		}
	}

	public String fazerChamada(int tipo, long cpf, int duracao, GregorianCalendar data) {
		if (tipo == 1) { 
			if (this.localizarPrePago(cpf) != null) {
				PrePago ass = this.localizarPrePago(cpf);
				ass.fazerChamada(data, duracao);
				return "Chamada realizada!\n";
			} else {
				return "Assinante não encontrado. Tente outro CPF.\n";
			}
		} else if (tipo == 2) {
			if (this.localizarPosPago(cpf) != null) {
				PosPago ass = this.localizarPosPago(cpf);
				ass.fazerChamada(data, duracao);
				return "Chamada realizada!\n";
			} else {
				return "Assinante não encontrado. Tente outro CPF.\n";
			}
		} else {
			return "Opção inválida. Escolha outra opção.\n";
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
			} 
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i].getCpf() == cpf) {
				return this.pospagos[i];
			} 
		}
		return null;
	}

	public void imprimirFaturas(int mes) {
		for (int i = 0; i < this.prepagos.length; i++) {
			if (this.prepagos[i] != null) {
				//this.prepagos[i].imprimirFatura(mes);
				System.out.println(this.prepagos[i].imprimirFatura(mes));
			}

		}
		for (int i = 0; i < this.pospagos.length; i++) {
			if (this.pospagos[i] != null) {
				System.out.println(this.pospagos[i].imprimirFatura(mes));
				//this.pospagos[i].imprimirFatura(mes);
			}
		}
	}

	public static void main(String[] args) {
		long cpf;
		int tipo;
		String nome;
		long numTelefone;
		GregorianCalendar calendar;
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
					tipo = s.nextInt();
					if (tipo == 1) {
						System.out.println("Insira seu nome: ");
						nome = s.next();
						System.out.println("Insira seu CPF: ");
						cpf = s.nextLong();
						System.out.println("Insira seu número de telefone: ");
						numTelefone = s.nextLong();
						t.cadastrarAssinante(nome, cpf, numTelefone, 10, 10, 50);
					} else if (tipo == 2) {
						System.out.println("Insira seu nome: ");
						nome = s.next();
						System.out.println("Insira seu CPF: ");
						cpf = s.nextLong();
						System.out.println("Insira seu número de telefone: ");
						numTelefone = s.nextLong();
						t.cadastrarAssinante(nome, cpf, tipo, numTelefone, opcao);
					} else {
						System.out.println("Opção inexistente.");
					}
					break;
				case 2: 
					t.listarAssinantes();
					break;
				case 3: 
					System.out.println("Insira seu CPF: ");
					cpf = s.nextLong();
					System.out.println("Qual o tipo de assinante?\n 1- Pré Pago\n 2- Pós Pago");
					tipo = s.nextInt();
					calendar = new GregorianCalendar();
					Random r = new Random();
					System.out.println(t.fazerChamada(tipo, cpf, r.nextInt(60), calendar));
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
					if (mes >= 0 && mes <= 11 ) {
						System.out.println("Faturas impressas: \n");
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