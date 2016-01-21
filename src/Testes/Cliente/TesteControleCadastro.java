package Testes.Cliente;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.Test;

import Servidor2.ServidorSocket;

import Cliente.ControleCadastro;

public class TesteControleCadastro {
	

	@Test
	public void esperaFalseParaCadastroInvalido() throws UnknownHostException, IOException {
		Socket meuSocket = new Socket("127.0.0.1", 5002);
		JTextField login = new JTextField();
		login.setText("test01");
		JPasswordField senha = new JPasswordField();
		senha.setText("1234");
		ControleCadastro controle = new ControleCadastro();
		assertEquals(false, controle.cadastrarUsuario(login, senha, meuSocket));
	}
	
	
}
