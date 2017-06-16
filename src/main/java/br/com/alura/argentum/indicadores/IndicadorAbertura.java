package br.com.alura.argentum.indicadores;

import br.com.alura.argentum.modelo.SerieTemporal;

public class IndicadorAbertura implements Indicador{

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandles(posicao).getAbertura();
	}

	@Override
	public String toString() {
		return "Indicador de Abertura";
	}
}
