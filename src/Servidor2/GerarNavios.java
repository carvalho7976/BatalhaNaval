package Servidor2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GerarNavios {
	HashMap<Integer, String> posicoesNavios;

	public HashMap<Integer, String> criarNavios() {
		this.posicoesNavios = new HashMap<>();
		gerarPecasNavio();
		return posicoesNavios;
	}

	private void gerarPecasNavio() {
		Random random = new Random();
		
			gerarNavio1Peca();		
			int opcao = random.nextInt(2);
			if (opcao == 0) {
				gerarNavio2Peca();
			} else {
				gerarNavio2PecaVertical();
			}
			opcao = random.nextInt(2);
			if (opcao == 0) {
				gerarNavio3Peca();
			} else {
				gerarNavio3PecaVertical();
			}
			opcao = random.nextInt(2);
			if (opcao == 0) {
				gerarNavio4Peca();
			} else {
				gerarNavio4PecaVertical();
			}
			opcao = random.nextInt(2);
			if (opcao == 0) {
				gerarNavio5Peca();
			} else {
				gerarNavio5PecaVertical();
			}
			for(int i=0; i < 200; i++){
				if(posicoesNavios.containsKey(i)){
					System.out.print(" "+i+" ");
				}
			}
			System.out.println();
		

	}

	private void gerarNavio1Peca() {
		Random random = new Random();
		int i = random.nextInt(100) + 1;
		posicoesNavios.put(i, "A1");
	}

	private void gerarNavio2Peca() {
		Random random = new Random();
		int i = random.nextInt(99);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 1) || (i % 10 > (i + 1) % 10)) {
			i = random.nextInt(99);
		}
		posicoesNavios.put(i, "B1");
		posicoesNavios.put(i + 1, "B2");
	}

	private void gerarNavio2PecaVertical() {
		Random random = new Random();
		int i = random.nextInt(99);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 10) || i >= 100
				|| (i + 10) >= 100) {
			i = random.nextInt(99);
		}
		posicoesNavios.put(i, "VB1");
		posicoesNavios.put(i + 10, "VB2");
	}

	private void gerarNavio3Peca() {
		Random random = new Random();
		int i = random.nextInt(98);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 1)
				|| posicoesNavios.containsKey(i + 2) || (i % 10 > (i + 2) % 10)) {
			i = random.nextInt(98);
		}
		posicoesNavios.put(i, "C1");
		posicoesNavios.put(i + 1, "C2");
		posicoesNavios.put(i + 2, "C3");
	}

	private void gerarNavio3PecaVertical() {
		Random random = new Random();
		int i = random.nextInt(98) ;
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 10)
				|| posicoesNavios.containsKey(i + 20) || i >= 100
				|| (i + 20) >= 100) {
			i = random.nextInt(98);
		}
		posicoesNavios.put(i, "VC1");
		posicoesNavios.put(i + 10, "VC2");
		posicoesNavios.put(i + 20, "VC3");
	}

	private void gerarNavio4Peca() {
		Random random = new Random();
		int i = random.nextInt(97);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 1)
				|| posicoesNavios.containsKey(i + 2)
				|| posicoesNavios.containsKey(i + 3) || (i % 10 > (i + 3) % 10)) {
			i = random.nextInt(97);
		}
		posicoesNavios.put(i, "D1");
		posicoesNavios.put(i + 1, "D2");
		posicoesNavios.put(i + 2, "D3");
		posicoesNavios.put(i + 3, "D4");
	}

	private void gerarNavio4PecaVertical() {
		Random random = new Random();
		int i = random.nextInt(97);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 10)
				|| posicoesNavios.containsKey(i + 20)
				|| posicoesNavios.containsKey(i + 30) || i >= 100
				|| (i + 30) >= 100) {
			i = random.nextInt(97);
		}
		posicoesNavios.put(i, "VD1");
		posicoesNavios.put(i + 10, "VD2");
		posicoesNavios.put(i + 20, "VD3");
		posicoesNavios.put(i + 30, "VD4");
	}

	private void gerarNavio5Peca() {
		Random random = new Random();
		int i = random.nextInt(96);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 1)
				|| posicoesNavios.containsKey(i + 2)
				|| posicoesNavios.containsKey(i + 3)
				|| posicoesNavios.containsKey(i + 4) || (i % 10 > (i + 4) % 10)) {
			i = random.nextInt(96);
		}
		posicoesNavios.put(i, "E1");
		posicoesNavios.put(i + 1, "E2");
		posicoesNavios.put(i + 2, "E3");
		posicoesNavios.put(i + 3, "E4");
		posicoesNavios.put(i + 4, "E5");
	}

	private void gerarNavio5PecaVertical() {
		Random random = new Random();
		int i = random.nextInt(96);
		while (posicoesNavios.containsKey(i)
				|| posicoesNavios.containsKey(i + 10)
				|| posicoesNavios.containsKey(i + 20)
				|| posicoesNavios.containsKey(i + 30)
				|| posicoesNavios.containsKey(i + 40) || i >= 100
				|| (i + 40) >= 100) {
			i = random.nextInt(96);
		}
		posicoesNavios.put(i, "VE1");
		posicoesNavios.put(i + 10, "VE2");
		posicoesNavios.put(i + 20, "VE3");
		posicoesNavios.put(i + 30, "VE4");
		posicoesNavios.put(i + 40, "VE5");
	}

}