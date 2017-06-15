package br.com.alura.argentum.modelo;

import java.util.List;

public class SerieTemporal {
	
	private List<Candle> candles;
	
	public SerieTemporal(List<Candle> Candles){
		this.candles = Candles;
	}
	
	public Candle getCandles(int posicao){
		return this.candles.get(posicao);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size()-1;
	}
}
