package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {
	
	private Indicador outroIndicar = new IndicadorFechamento();
	
	public MediaMovelPonderada() {
	
	}
	
	public MediaMovelPonderada(Indicador outroIndicar) {
		this.outroIndicar = outroIndicar;
	}
	
	@Override
	public double calcula(int posicao, SerieTemporal serie){
		
		double soma = 0;
		double peso = 3;
		
		for (int i = posicao; i > posicao - 3; i--) {
			soma += outroIndicar.calcula(i, serie) * peso;
			peso--;
		}
		return soma / 6;
	}
	
	@Override
	public String toString() {
		return "MMP de " + outroIndicar.toString();
	}
}
