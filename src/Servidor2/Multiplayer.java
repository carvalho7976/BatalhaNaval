package Servidor2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Multiplayer implements Runnable {
	private HashMap<Integer, String> tabuleiroJogador1;
	private HashMap<Integer, String> tabuleiroJogador2;
	private Socket jogador1;
	private Socket jogador2;
	private ConfiguraNaviosJogador configuraNavios;
	private BufferedReader entradaJogador1;
	private BufferedReader entradaJogador2;
	private PrintStream saidaJogador1;
	private PrintStream saidaJogador2;
	private int pontosJogador1;
	private int pontosJogador2;

	public Multiplayer(Socket jogador1, Socket jogador2) throws IOException {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.pontosJogador1 = 0;
		this.pontosJogador2 = 0;
		this.configuraNavios = new ConfiguraNaviosJogador();
		this.entradaJogador1 = new BufferedReader(new InputStreamReader(
				jogador1.getInputStream()));
		this.saidaJogador1 = new PrintStream(jogador1.getOutputStream());
		System.out.println(jogador2.getInetAddress());

		this.entradaJogador2 = new BufferedReader(new InputStreamReader(
				jogador2.getInputStream()));
		this.saidaJogador2 = new PrintStream(jogador2.getOutputStream());
	}

	public String vezJogadorUm(String valor, int valorInt) throws IOException {
		while (tabuleiroJogador2.containsKey(valorInt)) {
			System.out.println("dentro do while jogador1 103");
			saidaJogador1.println("sim");
			saidaJogador1.println(tabuleiroJogador2.get(valorInt));
			saidaJogador2.println(valor);
			pontosJogador1++;
			if (pontosJogador1 == 15) {
				return "JOGADOR1 GANHOU";
			}
			valor = entradaJogador1.readLine();
			valorInt = Integer.parseInt(valor);
			System.out.println("valor lido jogador1: " + valor);
		}
		return "VEZ JOGADOR2";
	}

	public String vezJogadorDois(String valor, int valorInt) throws IOException {
		while (tabuleiroJogador1.containsKey(valorInt)) {
			System.out.println("dentro do while jogador2 120");
			saidaJogador2.println("sim");
			saidaJogador2.println(tabuleiroJogador1.get(valorInt));
			saidaJogador1.println(valor);
			pontosJogador2++;
			if (pontosJogador2 == 15) {
				return "JOGADOR2 GANHOU";
			}
			valor = entradaJogador2.readLine();
			valorInt = Integer.parseInt(valor);
			System.out.println("valor lido jogador2: " + valor);
		}
		return "VEZ JOGADOR1";
	}

	@Override
	public void run() {

		System.out.println("jogador2 " + jogador2);
		System.out.println("jogador1" + jogador1);
		try {

			tabuleiroJogador1 = new HashMap<>();
			tabuleiroJogador2 = new HashMap<>();
			saidaJogador1.println("pode");
			saidaJogador2.println("pode");

			String pos = entradaJogador1.readLine();
			System.out.println("jogador1 " + pos);
			String pos2 = entradaJogador2.readLine();
			System.out.println("jogador2 " + pos2);

			System.out.println(pos);
			int aux = pos.indexOf("-");
			configuraNavios.recebeValores(aux, pos, tabuleiroJogador1);

			System.out.println("chegando no jogador2");
			System.out.println(pos2);
			aux = pos2.indexOf("-");
			configuraNavios.recebeValores(aux, pos2, tabuleiroJogador2);

			saidaJogador1.println("sim");
			saidaJogador2.println("nao");

			System.out.println("a brincadeira começou");
			while (pontosJogador1 < 15 && pontosJogador2 < 15) {
				String valor = entradaJogador1.readLine();
				System.out.println("valor recebido: " + valor);
				int valorInt = Integer.parseInt(valor);
				String resultado = vezJogadorUm(valor, valorInt);
				if (resultado.equals("JOGADOR1 GANHOU")) {
					saidaJogador1.println("venceu");
					saidaJogador2.println("perdeu");
					jogador1.close();
					jogador2.close();
					break;
				} else if (resultado.equals("VEZ JOGADOR2")) {
					saidaJogador1.println("agua");
					saidaJogador2.println(valor);
					saidaJogador1.println("nao");
					saidaJogador2.println("sim");

					valor = entradaJogador2.readLine();
					valorInt = Integer.parseInt(valor);
					System.out.println("valor lido jogador2: " + valor);
					resultado = vezJogadorDois(valor, valorInt);
					if (resultado.equals("JOGADOR2 GANHOU")) {
						saidaJogador2.println("venceu");
						saidaJogador1.println("perdeu");
						jogador2.close();
						jogador1.close();
						break;
					}

				}
				saidaJogador2.println("agua");
				saidaJogador1.println(valor);
				saidaJogador1.println("sim");
				saidaJogador2.println("nao");

			}

		} catch (Exception e) {
			try {
				jogador1.close();
				jogador2.close();
				System.out.println("fechando conexao");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
