package Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControleCadastro {

	public boolean cadastrarUsuario(JTextField login, JTextField senha,
			Socket meuSocket) {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(
					meuSocket.getInputStream()));
			PrintStream saida = new PrintStream(meuSocket.getOutputStream());
			saida.println(login.getText());
			saida.println(senha.getText());
			String resposta = entrada.readLine();
			if (resposta.equals("sim")) {
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
