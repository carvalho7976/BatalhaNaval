package Cliente;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

public class ControleEscolha {

	public void instanciaPlayerUm(GerarEscolha gerarEscolha,
			String opcoesLayoute, JDesktopPane jDesktopPane1) {
		Player1 bla;
		try {
			System.out.println("opcoes de layout " + opcoesLayoute);
			bla = new Player1(gerarEscolha.getHash(),
					opcoesLayoute);
			bla.setVisible(true);
			jDesktopPane1.setVisible(false);
			jDesktopPane1.setVisible(false);
			

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
