package Cliente;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Servidor2.GerarNavios;

public class AvaliadorDeEscolha {
	GerarEscolha gerarEscolha;

	public boolean avaliaEscolhaDeNavios(JDesktopPane jPane,
			JComboBox<String> opcoes1, JComboBox<String> opcoes2,
			JComboBox<String> opcoes3, JComboBox<String> opcoes4,
			JComboBox<String> opcoes5, JRadioButton vertical2,
			JRadioButton vertical3, JRadioButton vertical4,
			JRadioButton vertical5) {
		gerarEscolha = new GerarEscolha();
		boolean s = false;
		boolean a = false;
		boolean b = false;
		boolean c = false;
		boolean d = false;
		gerarEscolha.zerarPosicoesNavios();
		s = gerarEscolha.gerarNavio1Peca(opcoes1.getSelectedIndex());

		if (vertical2.isSelected()) {
			a = gerarEscolha
					.gerarNavio2PecaVertical(opcoes2.getSelectedIndex());
		} else {
			a = gerarEscolha.gerarNavio2Peca(opcoes2.getSelectedIndex());

		}
		if (vertical3.isSelected()) {
			b = gerarEscolha
					.gerarNavio3PecaVertical(opcoes3.getSelectedIndex());
		} else {

			b = gerarEscolha.gerarNavio3Peca(opcoes3.getSelectedIndex());
		}
		if (vertical4.isSelected()) {
			c = gerarEscolha
					.gerarNavio4PecaVertical(opcoes4.getSelectedIndex());
		} else {
			c = gerarEscolha.gerarNavio4Peca(opcoes4.getSelectedIndex());

		}
		if (vertical5.isSelected()) {
			d = gerarEscolha
					.gerarNavio5PecaVertical(opcoes5.getSelectedIndex());
		} else {

			d = gerarEscolha.gerarNavio5Peca(opcoes5.getSelectedIndex());

		}
		String msg = "";
		if ((!s || !a || !b || !c || !d)) {
			if (!s)
				msg += "Sua opçãoo de Submarino foi inválida\n";
			if (!a)
				msg += "Sua opção de Navio de 2 posições foi inválida\n";
			if (!b)
				msg += "Sua opçãoo de Navio de 3 posições foi inválida\n";
			if (!c)
				msg += "Sua opção de Navio de 4 posições foi inválida\n";
			if (!d)
				msg += "Sua opçãoo de Navio de 5 posições foi inválida\n";
			JOptionPane.showMessageDialog(jPane, msg);
			return false;
		}
		return true;
	}

	public GerarEscolha escolha() {
		return gerarEscolha;
	}

}