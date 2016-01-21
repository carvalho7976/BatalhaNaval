package Servidor2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

	public static void main(String[] args) {
		GerenciaConexoes gerenciador = new GerenciaConexoes();
		CadastrarUsuarioSocket cadastrar = new CadastrarUsuarioSocket();
		Thread cadatrarThread = new Thread(cadastrar);
		cadatrarThread.start();

		try {
			ServerSocket socket = new ServerSocket(5001);

			while (true) {
				Socket c = socket.accept();
				BufferedReader entrada = new BufferedReader(
						new InputStreamReader(c.getInputStream()));
				PrintStream saida = new PrintStream(c.getOutputStream());
				System.out.println("aki");
				String login = entrada.readLine();
				String senha = entrada.readLine();
				System.out.println(login + " " + senha);
				LoginSenhaDao autentica = new LoginSenhaDao();
				
				if (!autentica.validaLoginEsenha(login, senha)) {
					saida.println("nao");
					c.close();
				} else {
					saida.println("sim");
					String valor2 = entrada.readLine();
					System.out.println(c.getRemoteSocketAddress());
					System.out.println("valor " + valor2);
					System.out.println(" ------ > " + valor2);
					if (valor2.equals("1")) {
						System.out.println("single");
						SinglePlayer single = new SinglePlayer(c);
						Thread t = new Thread(single);
						t.start();
					} else if (valor2.equals("2")) {
						System.out.println("mut");
						gerenciador.addConexao(c);

					}

				}

			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
