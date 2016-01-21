package Cliente;

//essa classe manipula caracteres que são usados
//constantemente no jogo
public class ControleDeCaracteres {
	
	public char[] cadeiaDe10Posicoes(){
		char aux[] = new char[10];
		aux[0] = 'A';
		aux[1] = 'B';
		aux[2] = 'C';
		aux[3] = 'D';
		aux[4] = 'E';
		aux[5] = 'F';
		aux[6] = 'G';
		aux[7] = 'H';
		aux[8] = 'I';
		aux[9] = 'J';
		return aux;
	}
	
	public int enviaPosicaoBotao(String posicao) {
		if (posicao.charAt(0) == 'A') {
			char aux2 = posicao.charAt(1);
			int valor = 0 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'B') {
			char aux2 = posicao.charAt(1);
			int valor = 10 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'C') {
			char aux2 = posicao.charAt(1);
			int valor = 20 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'D') {
			char aux2 = posicao.charAt(1);
			int valor = 30 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'E') {
			char aux2 = posicao.charAt(1);
			int valor = 40 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'F') {
			char aux2 = posicao.charAt(1);
			int valor = 50 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'G') {
			char aux2 = posicao.charAt(1);
			int valor = 60 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'H') {
			char aux2 = posicao.charAt(1);
			int valor = 70 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else if (posicao.charAt(0) == 'I') {
			char aux2 = posicao.charAt(1);
			int valor = 80 + Integer.parseInt("" + aux2 + "");
			return valor;
		} else {
			char aux2 = posicao.charAt(1);
			int valor = 90 + Integer.parseInt("" + aux2 + "");
			return valor;
		}

	}

}
