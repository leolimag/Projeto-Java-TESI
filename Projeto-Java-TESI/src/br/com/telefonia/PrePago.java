package br.com.telefonia;

import java.util.Date;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
	
	private float creditos;
	private int numRecargas;
	private Recarga[] recargas;

	public PrePago(long cpf, String nome, int numero, int numChamadas, float creditos, int numRecargas) {
		super(cpf, nome, numero, numChamadas);
		this.recargas = new Recarga[numRecargas];
		this.creditos = creditos;
		this.numRecargas = numRecargas;
	}
	
	public void recarregar(GregorianCalendar data, float valor) {
		
	}
	
	public boolean fazerChamada(Date data, int duracao) {
		if(duracao > 10 ) {
			return true;
		}
		return false;
	}
	
	public void imprimirFatura(int mes) {
		
	}

}
