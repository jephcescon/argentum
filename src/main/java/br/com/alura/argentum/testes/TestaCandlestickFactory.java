package br.com.alura.argentum.testes;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import br.com.alura.argentum.modelo.Candlestick;
import br.com.alura.argentum.modelo.CandlestickFactory;
import br.com.alura.argentum.modelo.Negociacao;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		
		Candlestick candle = fabrica.geraClandleParaData(negociacoes, hoje);
		
		System.out.println("Data da abertura: " + candle.getAbertura());
		System.out.println("Data da fechamento: " + candle.getFechamento());
		System.out.println("Data da Minimo: " + candle.getMinimo());
		System.out.println("Data da Maximo: " + candle.getMaximo());
		System.out.println("Data da Volume: " + candle.getVolume());
	}

}
