package Cliente;

import java.util.HashMap;

public class MapLayoutes {
	private HashMap<String, String> layoutes;
	
	public MapLayoutes() {
		this.layoutes = new HashMap<String, String>();
		layoutes.put("Pagina Inicial", "paginaInicial.jpeg");
		layoutes.put("Inverno", "inverno.gif");
		layoutes.put("Memes", "memes.jpg");
		layoutes.put("Guerra de Titas", "navio.jpeg");
		layoutes.put("Instinto Animal", "onca.jpg");
		layoutes.put("Piratas", "piratas.jpg");
		layoutes.put("Vasco da Gama", "vasco.jpg");
	}
	
	public String retornaLayoute(String opcao){
		return layoutes.get(opcao);
	}
}
