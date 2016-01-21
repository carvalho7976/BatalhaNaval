package Cliente;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketFactory {
	private static Socket socket;
	
	public SocketFactory() {
		try {
			socket = new Socket("127.0.0.1", 5001);
		} catch (IOException e) {
			System.out.println("erro ao se conectar");
			e.printStackTrace();
		}
	}
	
	public static Socket getSocket(){
		return socket;
	}
	public static void closeSocket(){
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println("ops, algo aconteceu");
			e.printStackTrace();
		}
	}

}
