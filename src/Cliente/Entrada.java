package Cliente;

import java.io.IOException;

public class Entrada implements Runnable{

	@Override
	public void run() {
		entrada();
		
	}
	public void entrada(){
		try {
				//obs
				while(true){
					System.out.println("estou na thread, q bom");
					String entr = Player1.entrada.readLine();
					System.out.println("valor da entrada: " + entr);
					if(entr.equals("sim") || entr.equals("nao")){
						Player1.vez = entr;
					}else if(Player1.vez.equals("nao") && !entr.equals("perdeu") && !entr.equals("venceu") && !entr.equals("agua")){
						Player1.mudarMeuMapa(Integer.parseInt(entr));
					}else if(entr.equals("venceu")){
						Player1.venceu();
					}else if(entr.equals("perdeu")){
						Player1.perdeu();
					}else{
						Player1.mudarMapaOponente(Player1.meuClick, entr);
					}
				}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
