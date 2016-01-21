package Testes.Servidor;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Servidor2.JogadorMaquina;

public class TestJogadorMaquina {

	@Test
	public void esperaTrueParaAddTentativaUnica() {
		JogadorMaquina maquina = new JogadorMaquina();
		assertEquals(true, maquina.addTentativa(3));
		assertEquals(true, maquina.addTentativa(4));
	}
	
	@Test
	public void esperaFalseParaAddTentativaExistente() {
		JogadorMaquina maquina = new JogadorMaquina();
		assertEquals(true, maquina.addTentativa(3));
		assertEquals(false, maquina.addTentativa(3));
	}

}
