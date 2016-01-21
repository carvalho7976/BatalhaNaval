package Testes.Cliente;

import static org.junit.Assert.*;

import org.junit.Test;

import Cliente.MapLayoutes;

public class TestMapLayoute {
	MapLayoutes map = new MapLayoutes();

	@Test
	public void esperaPaginaInicialJPEGparaPaginaInicial() {
		assertEquals("paginaInicial.jpeg", map.retornaLayoute("Pagina Inicial"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaInvero() {
		assertEquals("inverno.gif", map.retornaLayoute("Inverno"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaMemes() {
		assertEquals("memes.jpg", map.retornaLayoute("Memes"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaGuerraDeTitas() {
		assertEquals("navio.jpeg", map.retornaLayoute("Guerra de Titas"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaInstintoAnimal() {
		assertEquals("onca.jpg", map.retornaLayoute("Instinto Animal"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaPiratas() {
		assertEquals("piratas.jpg", map.retornaLayoute("Piratas"));
	}
	
	@Test
	public void esperaPaginaInicialJPEGparaVascoDaGama() {
		assertEquals("vasco.jpg", map.retornaLayoute("Vasco da Gama"));
	}

}
