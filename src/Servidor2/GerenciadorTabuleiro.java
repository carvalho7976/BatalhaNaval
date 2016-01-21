package Servidor2;

import java.util.HashMap;
import java.util.List;

public class GerenciadorTabuleiro {
	private HashMap<Integer, String> posicoesNavios;
	private GerarNavios gerarNavios;
	private Tabuleiro jogadorUm;
	
	public GerenciadorTabuleiro(){
		this.gerarNavios = new GerarNavios();
		this.posicoesNavios = gerarNavios.criarNavios();
		this.jogadorUm = new Tabuleiro();
		todasPosicoes();
	}
	
	private void todasPosicoes(){
		for(int i = 0; i<100;i++){
			if(posicoesNavios.containsKey(i)){
				setarNavios(i);
			}
		}
	}
	
	public void setarNavios(int posicao){
		if(posicoesNavios.containsKey(posicao)){
			jogadorUm.setTabuleiro(posicao/10, posicao%10);
		}
		
	}
	
	public void setarNaviosTiroAgua (int posicao){
		jogadorUm.setTabuleiroAgua(posicao/10, posicao%10);
	}
	
	public boolean verificaPosicao(int posicao){
		return posicoesNavios.containsKey(posicao);
	}
	public String chaveHash(int posicao){
		return posicoesNavios.get(posicao);
	}
	public Tabuleiro getTabuleiro(){
		return jogadorUm;
	}
	
		
}