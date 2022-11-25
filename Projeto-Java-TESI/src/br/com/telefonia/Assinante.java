package br.com.telefonia;

public abstract class Assinante {
	private long cpf;
	private String nome;
	private int numero;
	protected int numChamadas;
	protected Chamada[] chamadas; 
	
	public Assinante(long cpf, String nome, int numero, int numChamadas) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.numero = numero;
		this.numChamadas = numChamadas;
		this.chamadas = new Chamada[numChamadas];
	}

	public long getCpf() {
		return cpf;
	}
	
	@Override
	public String toString(){
		return "nome: " + nome + "; número: " + numero + "; cpf: " + cpf;
	}
	
}