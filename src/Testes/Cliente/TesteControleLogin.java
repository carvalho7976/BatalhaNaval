package Testes.Cliente;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;

import Cliente.ControleCadastro;
import Cliente.ControleLogin;
import Servidor2.ServidorSocket;

public class TesteControleLogin {

	@Test
	public void esperaFalseParaLoginInvalido() throws UnknownHostException, IOException {
		Socket meuSocket = new Socket("127.0.0.1", 5001);
		JTextField login = new JTextField();
		login.setText("leusonMario");
		JPasswordField senha = new JPasswordField();
		senha.setText("123");
		ControleLogin controle = new ControleLogin();
		assertEquals(false, controle.login(login, senha, meuSocket));
	}	
	
	@Test
	public void esperaTrueParaLoginInvalido() throws UnknownHostException, IOException {
		Socket meuSocket = new Socket("127.0.0.1", 5001);
		JTextField login = new JTextField();
		login.setText("leu");
		JPasswordField senha = new JPasswordField();
		senha.setText("123123");
		ControleLogin controle = new ControleLogin();
		assertEquals(true, controle.login(login, senha, meuSocket));
	}	

}
