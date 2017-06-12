package br.com.alura.argentum.modelo;

import java.time.LocalDateTime;

import org.junit.Test;

public class TestaNegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-20.0, 2, LocalDateTime.now());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeNegativa() {
		new Negociacao(20.0, -3, LocalDateTime.now());
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula(){
		new Negociacao(20, 3, null);
	}
}
