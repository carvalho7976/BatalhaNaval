package Cliente;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.xml.parsers.FactoryConfigurationError;

public class Player1 extends javax.swing.JFrame {
	private static HashMap<Integer, String> minhasposicoes;
	private static DesktopPersonalizado jDesktopPane1;
	private static JButton[][] tabuleiroOponente;
	private static JButton[][] meuTabuleiro;
	private static SelecionadorDeImagem selecionador;
	public static BufferedReader entrada;
	private PrintStream saida;
	public static String vez;
	public static int meuClick;
	public static String opcaoJogo;

	// criar socket para abrir conexão
	public static <K> void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Player1 inst;
				try {
					inst = new Player1(getMinhasposicoes(), "");
					inst.setSize(1500, 800);
					inst.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	public Player1(HashMap<Integer, String> minhasPosicoes,
			String opcaoLayout) throws IOException {
		super();
		vez = "sim";
		opcaoJogo = opcaoLayout;
		jDesktopPane1 = new DesktopPersonalizado(opcaoLayout);
		initGUI(minhasPosicoes, opcaoLayout);
	}

	private void initGUI(HashMap<Integer, String> posicoes, String modoJogo) {
		try {
			minhasposicoes = posicoes;			
			final ControleDeCaracteres caracteres = new ControleDeCaracteres();
			entrada = new BufferedReader(new InputStreamReader(
					SocketFactory.getSocket().getInputStream()));
			saida = new PrintStream(SocketFactory.getSocket().getOutputStream());
		
			enviaPosicoes(entrada);
			
			
			setMinhasposicoes(posicoes);

			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				getContentPane().add(jDesktopPane1, BorderLayout.CENTER);

				this.selecionador = new SelecionadorDeImagem();
			}
			
			
			char aux[] = caracteres.cadeiaDe10Posicoes();
			
			this.tabuleiroOponente = new JButton[10][10];
			this.meuTabuleiro = new JButton[10][10];

			// gera os dois tabuleiros - coisa mais linda
			int cont = -1;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					cont++;
					tabuleiroOponente[i][j] = new JButton("" + aux[i] + (j));
					meuTabuleiro[i][j] = new JButton("" + aux[i] + (j));
					if (getMinhasposicoes().containsKey(cont)) {
						System.out.println(" " + getMinhasposicoes().get(cont)
								+ " " + cont);
						meuTabuleiro[i][j]
								.setIcon(selecionador
										.selecionarImagem(getMinhasposicoes()
												.get(cont)));
					} else {
						meuTabuleiro[i][j].setIcon(selecionador
								.selecionarImagem("agua"));
					}
					jDesktopPane1.add(tabuleiroOponente[i][j],
							JLayeredPane.DEFAULT_LAYER);
					jDesktopPane1.add(meuTabuleiro[i][j],
							JLayeredPane.DEFAULT_LAYER);
					tabuleiroOponente[i][j].setBounds(60 + 60 * j, 50 + 55 * i,
							59, 55);
					meuTabuleiro[i][j].setBounds(700 + 60 * j, 50 + 55 * i, 59,
							55);

					ActionListener ij = new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							if (vez.equals("sim")) {
								int valor = caracteres.enviaPosicaoBotao(e
										.getActionCommand());
								System.out
										.println("valor desta porra " + valor);
								jogar(valor);
								vez = "nao";

							} else {
								// como não é a vez dele não acontece nadinha
							}

						}

					};

					this.tabuleiroOponente[i][j].addActionListener(ij);

				}
			}

			pack();
			this.setSize(1063, 732);
		} catch (Exception e) {

			e.printStackTrace();
		}
		Entrada entrada = new Entrada();
		Thread t = new Thread(entrada);
		t.start();

	}

	

	public static HashMap<Integer, String> getMinhasposicoes() {
		return minhasposicoes;
	}

	public static void setMinhasposicoes(HashMap<Integer, String> minhasposicoes) {
		Player1.minhasposicoes = minhasposicoes;
	}

	public static void mudaImagem() {
		Icon imagem = selecionador.selecionarImagem("A1");
		JLabel aux = new JLabel(imagem);
		Rectangle alinhamento = tabuleiroOponente[90 / 10][90 % 10].getBounds();
		jDesktopPane1.add(aux).setBounds(alinhamento.x, alinhamento.y, 59, 55);
		tabuleiroOponente[90 / 10][90 % 10].setIcon(imagem);

	}

	public static void mudarMeuMapa(int posicao) {
		System.out.println("entrei em mudarMeuMapa");
		Icon imagem = selecionador.selecionarImagem("bomba");
		JLabel aux = new JLabel(imagem);
		Rectangle alinhamento = meuTabuleiro[posicao / 10][posicao % 10]
				.getBounds();
		jDesktopPane1.add(aux).setBounds(alinhamento.x, alinhamento.y, 59, 55);
		meuTabuleiro[posicao / 10][posicao % 10].setIcon(imagem);
	}

	public static void mudarMapaOponente(int posicao, String figura) {
		System.out.println("entrei em mudarMapaOponente");
		Icon imagem = selecionador.selecionarImagem(figura);
		JLabel aux = new JLabel(imagem);
		Rectangle alinhamento = tabuleiroOponente[posicao / 10][posicao % 10]
				.getBounds();
		jDesktopPane1.add(aux).setBounds(alinhamento.x, alinhamento.y, 59, 55);
		tabuleiroOponente[posicao / 10][posicao % 10].setIcon(imagem);
		tabuleiroOponente[posicao / 10][posicao % 10].removeNotify();

	}

	public void jogar(int valor) {
		meuClick = valor;
		saida.println(valor);

	}

	public static void venceu() {
		JOptionPane.showMessageDialog(jDesktopPane1,
				"Voce ganhou meu filho, parabéns");
		SocketFactory.closeSocket();
		System.exit(0);
	}

	public static void perdeu() {
		JOptionPane.showMessageDialog(jDesktopPane1,
				"Sinto muito meu filho, vc perdeu");
		SocketFactory.closeSocket();
		System.exit(0);
	}

	
	
	public void enviaPosicoes(BufferedReader entrada) throws IOException{
		String pos = "";
		for (int i = 0; i < 100; i++) {
			if (minhasposicoes.containsKey(i)) {
				pos += i + "/" + minhasposicoes.get(i) + "-";
			}
		}
	
			saida.println(pos + "/n");
				
	}
}
