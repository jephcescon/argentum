package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class CandleTest {

	@Test
	public void test() {
		new Candle(10.0, 10.0, 10.0, 10.0, 100.0, LocalDateTime.now());
		
		new CandleBuilder()
			.comAbertura(10.0)
			.comFechamento(30.0)
			.comMaximo(35.0)
			.comMinimo(21.0)
			.comVolume(100.0)
			.comData(LocalDateTime.now())
			.geraCandle();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorQueMinimo(){
		CandleBuilder builder = new CandleBuilder();
				
				Candle candle = builder
									.comAbertura(10.0)
									.comFechamento(30.0)
									.comMinimo(25.0)
									.comMaximo(15.0)				
									.comVolume(200.0)
									.comData(LocalDateTime.now())
									.geraCandle();
	}

	@Test
	public void ehAltaSeFechamentoForIgualAbertura(){
		CandleBuilder builder = new CandleBuilder();
		
		Candle candle = builder
							.comAbertura(30.0).comFechamento(30.0)
							.comMinimo(25.0).comMaximo(50.0)				
							.comVolume(200.0)
							.comData(LocalDateTime.now())
							.geraCandle();
		
		Assert.assertTrue(candle.isAlta());
	}
}
