package Servidor2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.text.TabableView;

public class SinglePlayer implements Runnable {
	private Socket jogador1;
	private ArrayList<Integer> tentativasCertas;
	private HashMap<Integer, String> tabuleiroJogador1;
	private JogadorMaquina jogadorMaquina;
	private int jogadorPontos;
	private int maquinaPontos;
	private ConfiguraNaviosJogador configuraNavios;
	private GerenciadorTabuleiro gerenciador;
	private BufferedReader input;
	private PrintStream output;

	public SinglePlayer(Socket socket) throws IOException {
		this.jogador1 = socket;
		this.jogadorMaquina = new JogadorMaquina();
		this.tentativasCertas = new ArrayList<Integer>();
		this.jogadorPontos = 0;
		this.maquinaPontos = 0;
		this.configuraNavios = new ConfiguraNaviosJogador();
		this.gerenciador = new GerenciadorTabuleiro();
		this.input = new BufferedReader(new InputStreamReader(
				jogador1.getInputStream()));
		this.output = new PrintStream(jogador1.getOutputStream());

	}

	public String vezMaquina(String valor, int valorInt) throws IOException {
		valorInt = jogadorMaquina.geraPosicaoDaMaquina();
		output.println(valorInt);
		jogadorMaquina.addTentativa(valorInt);
		while (tabuleiroJogador1.containsKey(valorInt)) {
			if (tabuleiroJogador1.containsKey(valorInt)) {
				maquinaPontos++;
			}
			tabuleiroJogador1.remove(valorInt);
			tentativasCertas.add(valorInt);
			System.out.println("maquina pontos " + maquinaPontos);
			if (maquinaPontos == 15) {
				return "MAQUINA GANHOU";
			}
			valorInt = jogadorMaquina.geraPosicaoDaMaquina();
			output.println(valorInt);
			jogadorMaquina.addTentativa(valorInt);
		}
		jogadorMaquina.addTentativa(valorInt);
		output.println("sim");
		return "VEZ JOGADOR";
	}

	public String vezJogador(String valor, int valorInt) throws IOException {
		while (gerenciador.verificaPosicao(valorInt)) {
			output.println("sim");
			jogadorPontos++;
			if (jogadorPontos == 15) {
				return "JOGADOR VENCEU";
			}
			output.println(gerenciador.chaveHash(valorInt));
			valor = input.readLine();
			valorInt = Integer.parseInt(valor);
		}
		return "VEZ DA MAQUINA";

	}

	@Override
	public void run() {
		try {

			output.println("pode");
			String pos = input.readLine();

			tabuleiroJogador1 = new HashMap<>();
			System.out.println(pos);
			int aux = pos.indexOf("-");
			configuraNavios.recebeValores(aux, pos, tabuleiroJogador1);

			int maquinaPontos = 0;
			int jogadorPontos = 0;
			output.println("sim");

			System.out.println("entrado no while");
			while (jogadorPontos < 15 && maquinaPontos < 15) {
				String valor = input.readLine();
				int valorInt = Integer.parseInt(valor);
				
				String resultado = vezJogador(valor, valorInt);
				if (resultado.equals("JOGADOR VENCEU")) {
					output.println("venceu");
					jogador1.close();
				} else if (resultado.equals("VEZ DA MAQUINA")) {
					output.println("agua");
					output.println("nao");
					resultado = vezMaquina(valor, valorInt);
					if (resultado.equals("MAQUINA GANHOU")) {
						output.println("perdeu");
						jogador1.close();
					}
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
