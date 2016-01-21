package Testes.Servidor;




import org.junit.Test;

import Cliente.TelaLogin;
import Servidor2.GerenciadorTabuleiro;
import Servidor2.Tabuleiro;

public class TestGerenciadortabuleiro {

	@Test
	public void esperaTabuleiroDeJogadorUm() {
		GerenciadorTabuleiro gerenciador = new GerenciadorTabuleiro();
		Tabuleiro tabuleiro = new Tabuleiro();
		TelaLogin tela = new TelaLogin();
		//assertEquals(tabuleiro.estadoTabuleiro(), gerenciador.getTabuleiro().estadoTabuleiro());
	}

}
