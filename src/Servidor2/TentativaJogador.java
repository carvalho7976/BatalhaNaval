package Servidor2;

public class TentativaJogador {
	
	public String leTentativa(String entrada, GerenciadorTabuleiro gerenciador){
			int valorInt = Integer.parseInt(entrada);
			if (gerenciador.verificaPosicao(valorInt)) {
				return "sim";
			}else{
				return "nao";
			}	
	}

}
