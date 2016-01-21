package Servidor2;

import java.util.ArrayList;
import java.util.Random;

public class JogadorMaquina {
	private ArrayList<Integer> tentavivas;
	private int indice;

	public JogadorMaquina() {
		this.indice = 0;
		this.tentavivas = new ArrayList<>();
	}
	
	public boolean addTentativa(int tentativa){
		if(tentavivas.contains(tentativa)){
			return false;
		}else{
			tentavivas.add(tentativa);
			return true;
		}
	}

	public int geraPosicaoDaMaquina() {
		Random r = new Random();

		indice = r.nextInt(100);
		while (tentavivas.contains(indice)) {
			indice = r.nextInt(100);
		}

		return indice;
	}

}
