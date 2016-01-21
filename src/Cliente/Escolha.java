package Cliente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

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
public class Escolha extends javax.swing.JFrame {
	/**
  * 
  */
	private static final long serialVersionUID = 1L;

	private JDesktopPane jDesktopPane1;
	private JButton[][] tabuleiro;
	private GerarEscolha gerarEscolha;
	private JButton ok;
	private JButton visualizar;
	private ButtonGroup navio2;
	private JRadioButton vertical2;
	private JRadioButton horizontal2;
	private ButtonGroup navio3;
	private JRadioButton vertical3;
	private JRadioButton horizontal3;
	private ButtonGroup navio4;
	private JRadioButton vertical4;
	private JRadioButton horizontal4;
	private ButtonGroup navio5;
	private JRadioButton vertical5;
	private JRadioButton horizontal5;
	private int opcaoJogo;
	private JComboBox<String> opcoesLayoute;
	private JComboBox<String> opcoes1;
	private JComboBox<String> opcoes2;
	private JComboBox<String> opcoes3;
	private JComboBox<String> opcoes4;
	private JComboBox<String> opcoes5;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Escolha inst = new Escolha(0, "");
				inst.setLocationRelativeTo(null);
				inst.setSize(1500, 800);
				inst.setVisible(true);

			}
		});
	}

	public Escolha(int opcao, String nome) {
		super();
		this.opcaoJogo = opcao;
		SocketFactory.getSocket();
		JOptionPane.showMessageDialog(jDesktopPane1, "Olá " + nome
				+ ", \nInforme onde deseja posicionar seus navios.");
		initGUI();
	}

	ActionListener acao = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("vizualizar")) {

			} else if (e.getActionCommand().equals("Ok")) {
				AvaliadorDeEscolha avaliador = new AvaliadorDeEscolha();
				boolean msg = avaliador.avaliaEscolhaDeNavios(jDesktopPane1,
						opcoes1, opcoes2, opcoes3, opcoes4, opcoes5, vertical2,
						vertical3, vertical4, vertical5);
				if (msg) {
					gerarEscolha = avaliador.escolha();
					
					ControleEscolha controle = new ControleEscolha();
					controle.instanciaPlayerUm(gerarEscolha,opcoesLayoute.getSelectedItem().toString(), jDesktopPane1);

				}
			}
		}
	};

	private void initGUI() {
		try {

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			jDesktopPane1 = new JDesktopPane();
			getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
			jDesktopPane1.setPreferredSize(new java.awt.Dimension(1500, 1000));
			gerarEscolha = new GerarEscolha();

			opcoesLayoute = new JComboBox<String>();
			opcoes1 = new JComboBox<String>();
			opcoes2 = new JComboBox<String>();
			opcoes3 = new JComboBox<String>();
			opcoes4 = new JComboBox<String>();
			opcoes5 = new JComboBox<String>();

			ok = new JButton("Ok");
			visualizar = new JButton("Visualizar");
			navio2 = new ButtonGroup();
			vertical2 = new JRadioButton("Vertical");
			horizontal2 = new JRadioButton("Horizontal");
			navio2.add(vertical2);
			navio2.add(horizontal2);

			navio3 = new ButtonGroup();
			vertical3 = new JRadioButton("Vertical");
			horizontal3 = new JRadioButton("Horizontal");
			navio3.add(vertical3);
			navio3.add(horizontal3);

			navio4 = new ButtonGroup();
			vertical4 = new JRadioButton("Vertical");
			horizontal4 = new JRadioButton("Horizontal");
			navio4.add(vertical4);
			navio4.add(horizontal4);

			navio5 = new ButtonGroup();
			vertical5 = new JRadioButton("Vertical");
			horizontal5 = new JRadioButton("Horizontal");
			navio5.add(vertical5);
			navio5.add(horizontal5);

			jDesktopPane1.add(ok, BorderLayout.CENTER);
			ok.setBounds(1030, 560, 100, 20);
			jDesktopPane1.add(visualizar, BorderLayout.CENTER);
			visualizar.setBounds(1150, 560, 110, 20);
			ok.addActionListener(acao);

			AddElementosTabuleiro addElementos = new AddElementosTabuleiro();
			addElementos.addTabuleiro(jDesktopPane1, tabuleiro);
			addElementos.addOpcoesLayoute(jDesktopPane1, opcoesLayoute);
			addElementos.addComboBoxers(opcoes1, opcoes2, opcoes3, opcoes4,
					opcoes5);
			addElementos.primeiraEscolha(jDesktopPane1, opcoes1);
			addElementos.segundaEscolha(jDesktopPane1, opcoes2, horizontal2,
					vertical2);
			addElementos.terceiraEscolha(jDesktopPane1, opcoes3, horizontal3,
					vertical3);
			addElementos.quartaEscolha(jDesktopPane1, opcoes4, horizontal4,
					vertical4);
			addElementos.quintaEscolha(jDesktopPane1, opcoes5, horizontal5,
					vertical5);

			pack();
			this.setSize(964, 420);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}