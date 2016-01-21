package Cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private ControleCadastro controle;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
			if (e.getActionCommand().equals("Confirmar")) {
				if (!textField.getText().trim().isEmpty()
						&& !passwordField.getText().trim().isEmpty()
						&& passwordField.getText().trim()
								.equals(passwordField_1.getText().trim())) {
					Socket meuSocket;
					try {
						meuSocket = SocketFactory.getSocket();
						boolean resultado = controle.cadastrarUsuario(
								textField, passwordField_1, meuSocket);
						if (resultado) {
							JOptionPane.showMessageDialog(contentPane,
									"Cadastro realizado com sucesso");
							meuSocket.close();
							setVisible(false);
							TelaLogin tela = new TelaLogin();
							tela.main(null);
						} else {
							JOptionPane
									.showMessageDialog(contentPane,
											"Este usu�rio j� encontra-se cadastrado\nPor favor informe outros dados.");
							meuSocket.close();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane,
							"Dados informados inv�lidos!");

				}
			}
			if (e.getActionCommand().equals("Limpar Dados")) {
				passwordField.setText("");
				passwordField_1.setText("");
				textField.setText("");
			}
			if (e.getActionCommand().equals("Cancelar")) {
				TelaLogin tela = new TelaLogin();
				tela.setVisible(true);
				// System.exit(0);
				setVisible(false);
			}

		}
	};

	public TelaCadastro() {
		controle = new ControleCadastro();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(443, 264, -435, -269);
		contentPane.add(desktopPane);

		JLabel lblInformeSeuLogin = new JLabel("Informe seu login:");
		lblInformeSeuLogin.setBounds(54, 75, 135, 15);
		contentPane.add(lblInformeSeuLogin);

		textField = new JTextField();
		textField.setBounds(239, 73, 152, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblInformeSuaSenha = new JLabel("Informe sua senha:");
		lblInformeSuaSenha.setBounds(48, 102, 152, 15);
		contentPane.add(lblInformeSuaSenha);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setToolTipText("Informe sua senha");
		passwordField.setBounds(268, 130, 100, 20);
		contentPane.add(passwordField);

		JLabel lblInformeSuaSenha_1 = new JLabel("Informe sua senha novamente:");
		lblInformeSuaSenha_1.setBounds(12, 132, 221, 15);
		contentPane.add(lblInformeSuaSenha_1);

		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Informe sua senha");
		passwordField_1.setEchoChar('*');
		passwordField_1.setBounds(268, 104, 100, 20);
		contentPane.add(passwordField_1);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(146, 181, 117, 25);
		btnConfirmar.setToolTipText("Confirmar dados");
		contentPane.add(btnConfirmar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(48, 218, 117, 15);
		btnCancelar.setToolTipText("Cancelar operação");
		contentPane.add(btnCancelar);

		JButton btnLimparDados = new JButton("Limpar Dados");
		btnLimparDados.setToolTipText("Limpar os dados do formulário");
		btnLimparDados.setBounds(200, 218, 168, 15);
		contentPane.add(btnLimparDados);

		btnCancelar.addActionListener(acao);
		btnConfirmar.addActionListener(acao);
		btnLimparDados.addActionListener(acao);
	}

}
