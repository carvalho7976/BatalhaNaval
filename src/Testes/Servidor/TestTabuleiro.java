package Testes.Servidor;


import static org.junit.Assert.*;

import org.junit.Test;

import Servidor2.Tabuleiro;

public class TestTabuleiro {

	
	@Test
	public void esperaTabuleiroIgual() {
		Tabuleiro tabuleiro = new Tabuleiro();
		Integer[][] aux = new Integer[10][10];
		
		int contador=1;
		for(int i=0; i < 10; i++){
			for(int j=0; j < 10; j++){
				aux[i][j] = contador;
				contador++;
			}			
		}
		
		assertEquals(aux, tabuleiro.getTabuleiro());
	}

}
