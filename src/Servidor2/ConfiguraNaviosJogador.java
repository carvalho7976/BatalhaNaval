package Servidor2;

import java.util.HashMap;

public class ConfiguraNaviosJogador {

	public void recebeValores(int aux, String pos,
			HashMap<Integer, String> tabuleiroJogador1) {
		for (int i = 0; i < 15; i++) {
			System.out.println(aux);
			String aux2 = pos.substring(0, aux);
			System.out.println(aux2);
			int barra = aux2.indexOf("/");
			System.out.println(barra);
			String first = aux2.substring(0, barra);
			String second = aux2.substring(barra + 1, aux2.length());
			System.out.println(" firt " + first + "second " + second);
			pos = pos.substring(aux + 1, pos.length());
			aux = pos.indexOf("-");

			tabuleiroJogador1.put(Integer.parseInt(first), second);
		}
	}

}
