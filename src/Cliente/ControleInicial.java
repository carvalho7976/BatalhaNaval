package Cliente;

import java.io.IOException;
import java.io.PrintStream;

public class ControleInicial {
	
	public void instanciaModoJogo(int opcao, String nome){
		PrintStream saida;
		try {
			saida = new PrintStream(SocketFactory.getSocket().getOutputStream());
			saida.println(String.valueOf(opcao));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Escolha escolha = new Escolha(opcao, nome);
		escolha.setVisible(true);
	}
	

}
