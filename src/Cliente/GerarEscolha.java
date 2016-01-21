package Cliente;

import java.util.HashMap;

public class GerarEscolha {
	private HashMap<Integer, String> posicoesNavios;

	public GerarEscolha() {
		posicoesNavios = new HashMap<>();
	}
	
	public HashMap<Integer, String> getHash (){
		return posicoesNavios;
	}

	public boolean gerarNavio1Peca(int posicao) {
		if(posicoesNavios.containsKey(posicao)){
			return false;
		}else{
		posicoesNavios.put(posicao, "A1");
		return true;
		}
	}

	public boolean gerarNavio2Peca(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 1)
				|| (posicao % 10 > (posicao + 1) % 10)) {
			return false;
		} else {
			posicoesNavios.put(posicao, "B1");
			posicoesNavios.put(posicao + 1, "B2");
			return true;
		}
	}

	public boolean gerarNavio2PecaVertical(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 10) || posicao >= 100
				|| (posicao + 10) >= 100) {
			return false;
		} else {
			posicoesNavios.put(posicao, "VB1");
			posicoesNavios.put(posicao + 10, "VB2");
			return true;
		}
	}

	public boolean gerarNavio3Peca(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 1)
				|| posicoesNavios.containsKey(posicao + 2)
				|| (posicao % 10 > (posicao + 2) % 10)) {
			return false;
		} else {
			posicoesNavios.put(posicao, "C1");
			posicoesNavios.put(posicao + 1, "C2");
			posicoesNavios.put(posicao + 2, "C3");
			return true;
		}
	}

	public boolean gerarNavio3PecaVertical(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 10)
				|| posicoesNavios.containsKey(posicao + 20) || posicao >= 100
				|| (posicao + 20) >= 100) {
			return false;
		} else {
			posicoesNavios.put(posicao, "VC1");
			posicoesNavios.put(posicao + 10, "VC2");
			posicoesNavios.put(posicao + 20, "VC3");
			return true;
		}
	}

	public boolean gerarNavio4Peca(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 1)
				|| posicoesNavios.containsKey(posicao + 2)
				|| posicoesNavios.containsKey(posicao + 3)
				|| (posicao % 10 > (posicao + 3) % 10)) {
			return false;
		} else {
			posicoesNavios.put(posicao, "D1");
			posicoesNavios.put(posicao + 1, "D2");
			posicoesNavios.put(posicao + 2, "D3");
			posicoesNavios.put(posicao + 3, "D4");
			return true;
		}
	}

	public boolean gerarNavio4PecaVertical(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 10)
				|| posicoesNavios.containsKey(posicao + 20)
				|| posicoesNavios.containsKey(posicao + 30) || posicao >= 100
				|| (posicao + 30) >= 100) {
			return false;
		} else {
			posicoesNavios.put(posicao, "VD1");
			posicoesNavios.put(posicao + 10, "VD2");
			posicoesNavios.put(posicao + 20, "VD3");
			posicoesNavios.put(posicao + 30, "VD4");
			return true;
		}
	}

	public boolean gerarNavio5Peca(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 1)
				|| posicoesNavios.containsKey(posicao + 2)
				|| posicoesNavios.containsKey(posicao + 3)
				|| posicoesNavios.containsKey(posicao + 4)
				|| (posicao % 10 > (posicao + 4) % 10)) {
			return false;
		} else {
			posicoesNavios.put(posicao, "E1");
			posicoesNavios.put(posicao + 1, "E2");
			posicoesNavios.put(posicao + 2, "E3");
			posicoesNavios.put(posicao + 3, "E4");
			posicoesNavios.put(posicao + 4, "E5");
			return true;
		}
	}

	public boolean gerarNavio5PecaVertical(int posicao) {
		if (posicoesNavios.containsKey(posicao)
				|| posicoesNavios.containsKey(posicao + 10)
				|| posicoesNavios.containsKey(posicao + 20)
				|| posicoesNavios.containsKey(posicao + 30)
				|| posicoesNavios.containsKey(posicao + 40) || posicao >= 100
				|| (posicao + 40) >= 100) {
			return false;
		} else {
			posicoesNavios.put(posicao, "VE1");
			posicoesNavios.put(posicao + 10, "VE2");
			posicoesNavios.put(posicao + 20, "VE3");
			posicoesNavios.put(posicao + 30, "VE4");
			posicoesNavios.put(posicao + 40, "VE5");
			return true;
		}
	}
	public void zerarPosicoesNavios(){
		for(int i = 0; i<100;i++)
			if(posicoesNavios.containsKey(i))
				posicoesNavios.remove(i);
	}

}
