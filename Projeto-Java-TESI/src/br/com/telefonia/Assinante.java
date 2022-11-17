package br.com.telefonia;

public class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected int numChamadas;
	private Chamada[] chamadas; 
	
	public Assinante(long cpf, String nome, int numero, int numChamadas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = numChamadas;
		this.chamadas = new Chamada[this.numChamadas];
	}

	public long getCpf() {
		return cpf;
	}
	
	public String toString(){
		return "nome: " + nome + "; número: " + numero + "; cpf: " + cpf;
	}
	
}
