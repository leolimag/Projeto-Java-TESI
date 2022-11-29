package br.com.telefonia;

public abstract class Assinante {
	private long cpf;
	private String nome;
	private long numero;
	protected int numChamadas;
	protected Chamada[] chamadas; 
	
	public Assinante(long cpf, String nome, long numero, int numChamadas) {
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
		return "Nome: " + nome + "\nNúmero: " + numero + "\nCPF: " + cpf;
	}
	
}