package br.com.alura.argentum.modelo;

import java.util.List;

public class SerieTemporal {
	
	private List<Candlestick> candles;
	
	public SerieTemporal(List<Candlestick> Candles){
		this.candles = Candles;
	}
	
	public Candlestick getCandles(int posicao){
		return this.candles.get(posicao);
	}
	
	public int getUltimaPosicao(){
		return this.candles.size()-1;
	}
}
