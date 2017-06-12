package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class CandlestickTest {

	@Test
	public void test() {
		new Candlestick(10.0, 10.0, 10.0, 10.0, 100.0, LocalDateTime.now());
		
		new CandleBuilder()
			.comAbertura(10.0)
			.comFechamento(30.0)
			.comMaximo(35.0)
			.comMinimo(21.0)
			.comVolume(100.0)
			.comData(LocalDateTime.now())
			.geraCandle();
	}

}
