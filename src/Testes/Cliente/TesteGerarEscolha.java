package Testes.Cliente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;

import org.junit.Test;

import Cliente.GerarEscolha;

public class TesteGerarEscolha {
	GerarEscolha escolha = new GerarEscolha();

	@Test
	public void deveRetornarVerdadeiroParaNovaPecaNavio(){
		//GerarEscolha escolha = new GerarEscolha();
		assertEquals(true, escolha.gerarNavio1Peca(1));
	}
	@Test
	public void deveRetornarVerdadeiroParaNovaPecaNavio2(){
		assertEquals(true, escolha.gerarNavio2Peca(2));
	}
	@Test
	public void deveRetornarVerdadeiroParaNovaPecaNavio3(){
		assertEquals(true, escolha.gerarNavio2Peca(3));
	}
	@Test
	public void deveRetornarVerdadeiroParaNovaPecaNavio4(){
		assertEquals(true, escolha.gerarNavio2Peca(4));
	}
	@Test
	public void deveRetornarVerdadeiroParaNovaPecaNavio5(){
		assertEquals(true, escolha.gerarNavio2Peca(5));
	}
	@Test
	public void deveRetornarFalsoParaNovaPeca(){
		assertEquals(true, escolha.gerarNavio1Peca(1));
		assertEquals(false, escolha.gerarNavio1Peca(1));
		assertEquals(false, escolha.gerarNavio2Peca(1));
	}
	@Test
	public void deveRetornarFalsoParaNovoNavioDeformado(){
		escolha.zerarPosicoesNavios();
		escolha.gerarNavio1Peca(15);
		escolha.gerarNavio2Peca(16);
		assertEquals(false,escolha.gerarNavio3Peca(17));
	}
	@Test
	public void deveRetornarHashMapCompleto(){
		escolha.zerarPosicoesNavios();
		escolha.gerarNavio1Peca(1);
		HashMap<Integer, String> posicoes= new HashMap<>();
		assertFalse(posicoes.containsKey(escolha.getHash()));
	}

}
