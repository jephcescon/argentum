package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie){
		
		double soma = 0;
		
		for (int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandles(i).getFechamento();
		}
		
		return soma/3;
	}
	
	@Override
	public String toString() {
		return "MMS - Fechamento";
	}
}
