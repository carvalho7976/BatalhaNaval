package Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class TelaInicial extends javax.swing.JFrame {
	private DesktopPersonalizado planoDeFundo;
	private JLabel informeNome;
	private JLabel preparadoTexto;
	private JLabel escolhaOpcao;
	private JTextField textoNome;
	private JButton multiPlayer;
	private JButton singlePlayer;
	private int opcaoJogo;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaInicial inst = new TelaInicial();
				// inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public TelaInicial() {
		super("DestroyES - Batalha Naval");
		initGUI();

	}

	ActionListener acao = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			ControleInicial controle = new ControleInicial();
			if (e.getActionCommand().equals("SinglePlayer")) {
				controle.instanciaModoJogo(1, textoNome.getText());
				planoDeFundo.setVisible(false);
				setVisible(false);
			}
			if (e.getActionCommand().equals("MultiPlayer")) {
				controle.instanciaModoJogo(2, textoNome.getText());
				planoDeFundo.setVisible(false);
				setVisible(false);
			}

		}
	};

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			System.out.println("estou aqui agr");
			planoDeFundo = new DesktopPersonalizado("Pagina Inicial");

			getContentPane().add(planoDeFundo, BorderLayout.CENTER);
			singlePlayer = new JButton();
			planoDeFundo.add(singlePlayer, JLayeredPane.DEFAULT_LAYER);
			singlePlayer.setText("SinglePlayer");
			singlePlayer.setBounds(85, 222, 124, 22);
			singlePlayer.addActionListener(acao);

			multiPlayer = new JButton();
			planoDeFundo.add(multiPlayer, JLayeredPane.DEFAULT_LAYER);
			multiPlayer.setText("MultiPlayer");
			multiPlayer.setBounds(247, 222, 126, 22);
			multiPlayer.addActionListener(acao);

			textoNome = new JTextField();
			planoDeFundo.add(textoNome, JLayeredPane.DEFAULT_LAYER);
			textoNome.setBounds(85, 138, 217, 22);

			informeNome = new JLabel();
			planoDeFundo.add(informeNome, JLayeredPane.DEFAULT_LAYER);
			informeNome.setText("Informe seu nome abaixo:");
			informeNome.setBounds(85, 103, 186, 15);

			escolhaOpcao = new JLabel();
			planoDeFundo.add(escolhaOpcao, JLayeredPane.DEFAULT_LAYER);
			escolhaOpcao.setText("Escolha o modo de jogo desejado:");
			escolhaOpcao.setBounds(85, 186, 250, 15);

			preparadoTexto = new JLabel();
			planoDeFundo.add(preparadoTexto, JLayeredPane.DEFAULT_LAYER);
			preparadoTexto
					.setText("Você estar preparado para mais esse desafio?");
			preparadoTexto.setBounds(85, 37, 371, 15);

			pack();
			this.setSize(485, 343);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
