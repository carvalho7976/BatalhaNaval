package Servidor2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CadastrarUsuarioSocket implements Runnable {

	public void	cadastrar(){
		while(true){
			try {
				ServerSocket socket = new ServerSocket(5002);
				Socket c = socket.accept();
				BufferedReader entrada = new BufferedReader(
						new InputStreamReader(c.getInputStream()));
				PrintStream saida = new PrintStream(c.getOutputStream());
				String login = entrada.readLine();
				String senha = entrada.readLine();
				LoginSenhaDao dao = new LoginSenhaDao();
				if(dao.cadastrar(login, senha)){
					saida.println("sim");
					c.close();
				}else{
					saida.println("nao");
					c.close();
				}
					
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void run() {
		cadastrar();
		
	}
	
}
