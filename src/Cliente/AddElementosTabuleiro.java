package Cliente;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;

public class AddElementosTabuleiro {

	public void addTabuleiro(JDesktopPane jPane, JButton[][] tabuleiro) {
		ControleDeCaracteres caracteres = new ControleDeCaracteres();
		char[] aux = caracteres.cadeiaDe10Posicoes();
		
		tabuleiro = new JButton[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tabuleiro[i][j] = new JButton("" + aux[i] + (j));
				jPane.add(tabuleiro[i][j], JLayeredPane.DEFAULT_LAYER);
				tabuleiro[i][j].setBounds(60 + 64 * j, 50 + 60 * i, 59, 55);
				tabuleiro[i][j].removeNotify();
			}
		}
	}

	public void addOpcoesLayoute(JDesktopPane jPane,
			JComboBox<String> opcoesLayoute) {
		JLabel texto = new JLabel(
				"Você pode personalizar seu ambiente de jogo, para que ele fique do seu gosto.");
		JLabel texto1 = new JLabel(
				"Assim, escolha um estilo de layoute ao lado:");
		jPane.add(texto, BorderLayout.CENTER);
		texto.setBounds(720, 600, 1000, 20);
		jPane.add(texto1, BorderLayout.CENTER);
		texto1.setBounds(760, 620, 600, 20);
		texto.setVisible(true);
		opcoesLayoute.addItem("Guerra de Titas");
		opcoesLayoute.addItem("Memes");
		opcoesLayoute.addItem("Instinto Animal");
		opcoesLayoute.addItem("Piratas");
		opcoesLayoute.addItem("Vasco da Gama");
		opcoesLayoute.addItem("Inverno");
		jPane.add(opcoesLayoute);
		opcoesLayoute.setBounds(1095, 620, 150, 20);

	}

	public void addComboBoxers(JComboBox<String> opcoes1,
			JComboBox<String> opcoes2, JComboBox<String> opcoes3,
			JComboBox<String> opcoes4, JComboBox<String> opcoes5) {
		ControleDeCaracteres caracteres = new ControleDeCaracteres();
		char[] aux = caracteres.cadeiaDe10Posicoes();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				opcoes1.addItem("" + aux[i] + j);
				opcoes2.addItem("" + aux[i] + j);
				opcoes3.addItem("" + aux[i] + j);
				opcoes4.addItem("" + aux[i] + j);
				opcoes5.addItem("" + aux[i] + j);
			}
		}
	}

	public void primeiraEscolha(JDesktopPane jPane, JComboBox<String> opcoes1) {
		opcoes1.setVisible(true);
		opcoes1.setBounds(1250, 65, 50, 18);
		JLabel submarino = new JLabel("Escolha a posicao para o Submarino:");

		submarino.setBounds(980, 50, 290, 50);
		jPane.add(submarino);
		jPane.add(opcoes1);

	}

	public void segundaEscolha(JDesktopPane jPane, JComboBox<String> opcoes2,
			JRadioButton horizontal2, JRadioButton vertical2) {
		opcoes2.setVisible(true);
		jPane.add(opcoes2);
		opcoes2.setBounds(1240, 160, 50, 18);
		JLabel navio2 = new JLabel(
				"Escolha a posicao para o navio de 2 posições:");
		jPane.add(navio2, BorderLayout.CENTER);

		navio2.setBounds(900, 140, 350, 50);
		jPane.add(horizontal2, BorderLayout.CENTER);
		horizontal2.setBounds(1040, 180, 100, 20);
		jPane.add(vertical2, BorderLayout.CENTER);
		vertical2.setBounds(1160, 180, 80, 20);
	}

	public void terceiraEscolha(JDesktopPane jPane, JComboBox<String> opcoes3,
			JRadioButton horizontal3, JRadioButton vertical3) {
		opcoes3.setVisible(true);
		jPane.add(opcoes3, BorderLayout.CENTER);
		opcoes3.setBounds(1250, 275, 50, 18);
		JLabel navio3 = new JLabel(
				"Escolha a posicao para o navio de 3 posições:");
		jPane.add(navio3, BorderLayout.CENTER);

		navio3.setBounds(910, 260, 350, 50);
		jPane.add(horizontal3, BorderLayout.CENTER);
		horizontal3.setBounds(1040, 300, 100, 20);
		jPane.add(vertical3, BorderLayout.CENTER);
		vertical3.setBounds(1160, 300, 80, 20);

	}

	public void quartaEscolha(JDesktopPane jPane, JComboBox<String> opcoes4,
			JRadioButton horizontal4, JRadioButton vertical4) {
		opcoes4.setVisible(true);
		jPane.add(opcoes4, BorderLayout.CENTER);
		opcoes4.setBounds(1250, 370, 50, 18);
		JLabel navio4 = new JLabel(
				"Escolha a posicao para o navio de 4 posições:");
		jPane.add(navio4, BorderLayout.CENTER);

		navio4.setBounds(910, 360, 350, 50);
		jPane.add(horizontal4, BorderLayout.CENTER);
		horizontal4.setBounds(1040, 400, 100, 20);
		jPane.add(vertical4, BorderLayout.CENTER);
		vertical4.setBounds(1160, 400, 80, 20);
	}

	public void quintaEscolha(JDesktopPane jPane, JComboBox<String> opcoes5,
			JRadioButton horizontal5, JRadioButton vertical5) {
		opcoes5.setVisible(true);
		jPane.add(opcoes5, BorderLayout.CENTER);
		opcoes5.setBounds(1250, 480, 50, 18);
		JLabel navio5 = new JLabel(
				"Escolha a posicao para o navio de 5 posições:");
		jPane.add(navio5, BorderLayout.CENTER);

		navio5.setBounds(910, 460, 350, 50);
		jPane.add(horizontal5, BorderLayout.CENTER);
		horizontal5.setBounds(1040, 500, 100, 20);
		jPane.add(vertical5, BorderLayout.CENTER);
		vertical5.setBounds(1160, 500, 80, 20);
	}

}
