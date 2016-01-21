package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleLogin {

	public boolean login(JTextField login, JPasswordField senha,
			Socket meuSocket) {

		try {

			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					meuSocket.getInputStream()));
			PrintStream saida = new PrintStream(meuSocket.getOutputStream());
			
				String meuLogin = login.getText().trim();
				String minhaSenha = senha.getText().trim();
				System.out.println("login " + meuLogin + " senha " + minhaSenha);
				System.out.println(meuLogin + "--- " + minhaSenha);
				saida.println(meuLogin);
				saida.println(minhaSenha);
				String resposta = entrada.readLine();
				System.out.println("r  -- " + resposta);
				if (resposta.equals("sim")) {
					TelaInicial tela = new TelaInicial();
					tela.main(null);
					return true;

				} else {
					return false;

				
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
