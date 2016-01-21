package Servidor2;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class GerenciaConexoes  {
	private HashMap<Integer, Socket> listaSockets;
	private static int contador = 1;
	public GerenciaConexoes() {
		listaSockets = new HashMap<>();
	}
	
	public void addConexao(Socket c) throws IOException {
			listaSockets.put(contador, c);
			contador++;
			if(contador == 3){
				iniciaPartida(listaSockets.get(1),listaSockets.get(2));
				
			}
			
	}

	private void iniciaPartida(Socket socket, Socket socket2) throws IOException {
		listaSockets.remove(1);
		listaSockets.remove(2);
		contador = 0;
		Multiplayer m = new Multiplayer(socket, socket2);
		Thread t = new Thread(m);
		t.start();
	}

}
