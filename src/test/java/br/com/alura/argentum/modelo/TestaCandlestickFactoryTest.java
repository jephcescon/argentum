package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestaCandlestickFactoryTest {

	@Test
	public void sequenciaDeNegociacoesSimples() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.geraClandleParaData(negociacoes, hoje);

		Assert.assertEquals(20.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(20.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(14000.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void geraCandlestickComApenasUmaNegociacao() {
		LocalDateTime data = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(40.0, 100, data);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.geraClandleParaData(negociacoes, data);

		Assert.assertEquals(40.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(40.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(4000.0, candle.getVolume(), 0.00001);
	}

	@Test
	public void geraCandlestickComZerosEmCasoDeNenhumaNegociacao() {
		LocalDateTime data = LocalDateTime.now();

		List<Negociacao> negociacoes = new ArrayList<>();

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.geraClandleParaData(negociacoes, data);

		Assert.assertEquals(0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0, candle.getMaximo(), 0.00001);
		Assert.assertEquals(0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0, candle.getVolume(), 0.00001);
	}

	@Test
	public void negociacaoDeTresDiasDiferentesGeraTresCandlesDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();
		Negociacao negociacao1 = new Negociacao(50.0, 20, hoje);
		Negociacao negociacao2 = new Negociacao(100.0, 20, hoje);
		Negociacao negociacao3 = new Negociacao(150.0, 20, hoje);

		LocalDateTime amanha = hoje.plusDays(1);
		Negociacao negociacao4 = new Negociacao(50.0, 20, amanha);
		Negociacao negociacao5 = new Negociacao(10.0, 20, amanha);

		LocalDateTime depois = amanha.plusDays(1);
		Negociacao negociacao6 = new Negociacao(35.0, 20, depois);
		Negociacao negociacao7 = new Negociacao(35.0, 20, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,
				negociacao6, negociacao7);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		
		List<Candlestick> candlesticks = fabrica.constroiCandles(negociacoes);
		
		Assert.assertEquals(3, candlesticks.size());
		Assert.assertTrue(negociacoes.get(0).isMesmoDia(candlesticks.get(0).getData()));
		Assert.assertTrue(negociacoes.get(3).isMesmoDia(candlesticks.get(1).getData()));
		Assert.assertTrue(negociacoes.get(5).isMesmoDia(candlesticks.get(2).getData()));
		
		Assert.assertEquals(6000.0, candlesticks.get(0).getVolume(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(0).getMinimo(), 0.00001);
		Assert.assertEquals(150.0, candlesticks.get(0).getMaximo(), 0.00001);
		Assert.assertEquals(50.0, candlesticks.get(0).getAbertura(), 0.00001);
		Assert.assertEquals(150.0, candlesticks.get(0).getFechamento(), 0.00001);
	}
}
