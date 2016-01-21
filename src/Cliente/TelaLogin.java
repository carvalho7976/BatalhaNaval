package Cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private ControleLogin controle;
	private static SocketFactory fabricaSocket;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//aki inicia o socket pela primeir vez
					fabricaSocket = new SocketFactory();
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	ActionListener acao = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Entrar")){
					if((!textField.getText().trim().isEmpty() && !passwordField
							.getPassword().toString().trim().isEmpty())) {
				Socket meuSocket;
				meuSocket = SocketFactory.getSocket();
				boolean resultado = controle.login(textField,
						passwordField, meuSocket);
				if (resultado) {
					setVisible(false);
					
				} else if (!resultado) {
					textField.setText("");
					passwordField.setText("");
					JOptionPane.showMessageDialog(contentPane,
							"Login e/ou senha errados.");
				}
					}else{
						textField.setText("");
						passwordField.setText("");
						JOptionPane.showMessageDialog(contentPane,
								"Campos de login e/ou senha vazios");
					}
			} else if (e.getActionCommand().equals("Realizar Cadastro")) {
				TelaCadastro cadastro = new TelaCadastro();
				cadastro.main(null);
				setVisible(false);
			}

		}

	};

	public TelaLogin() {
		controle = new ControleLogin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(447, 265, -443, -270);
		contentPane.add(desktopPane);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(108, 76, 70, 15);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(108, 116, 70, 15);
		contentPane.add(lblSenha);

		textField = new JTextField();
		textField.setToolTipText("Insira seu login");
		textField.setBounds(174, 74, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("insira sua senha");
		passwordField.setBounds(174, 114, 114, 20);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(264, 158, 78, 25);
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(acao);

		JButton btnRealizarCadastro = new JButton("Realizar Cadastro");
		btnRealizarCadastro.setBounds(239, 12, 197, 15);
		contentPane.add(btnRealizarCadastro);
		btnRealizarCadastro.addActionListener(acao);
	}

}
