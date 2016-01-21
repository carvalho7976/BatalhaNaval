package Cliente;

import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SelecionadorDeImagem {
	HashMap<String, Icon> imagens;
	
	public SelecionadorDeImagem (){
		this.imagens = new HashMap<>();
		inicalizarImagens();
	}
	
	public void inicalizarImagens (){
		Icon agua = new ImageIcon("agua.png");
		Icon a1 = new ImageIcon("A1.jpg");
		Icon b1 = new ImageIcon("B1.png");
		Icon b2 = new ImageIcon("B2.png");
		Icon c1 = new ImageIcon("C1.png");
		Icon c2 = new ImageIcon("C2.png");
		Icon c3 = new ImageIcon("C3.png");
		Icon d1 = new ImageIcon("D1.jpg");
		Icon d2 = new ImageIcon("D2.jpg");
		Icon d3 = new ImageIcon("D3.jpg");
		Icon d4 = new ImageIcon("D4.jpg");
		Icon e1 = new ImageIcon("E1.png");
		Icon e2 = new ImageIcon("E2.png");
		Icon e3 = new ImageIcon("E3.png");
		Icon e4 = new ImageIcon("E4.png");
		Icon e5 = new ImageIcon("E4.png");
		Icon e6 = new ImageIcon("bomba.jpg");
		Icon e7 = new ImageIcon("VB1.png");
		Icon e8 = new ImageIcon("VB2.png");
		Icon e9 = new ImageIcon("VC1.png");
		Icon f0 = new ImageIcon("VC2.png");
		Icon f1 = new ImageIcon("VC3.png");
		Icon f2 = new ImageIcon("VD1.jpg");
		Icon f3 = new ImageIcon("VD2.jpg");
		Icon f4 = new ImageIcon("VD3.jpg");
		Icon f5 = new ImageIcon("VD4.jpg");
		Icon f6 = new ImageIcon("VE1.png");
		Icon f7 = new ImageIcon("VE2.png");
		Icon f8 = new ImageIcon("VE3.png");
		Icon f9 = new ImageIcon("VE4.png");
		Icon g0 = new ImageIcon("VE5.png");
		
		imagens.put("VE5", g0);
		imagens.put("VE4", f9);
		imagens.put("VE3", f8);
		imagens.put("VE2", f7);
		imagens.put("VE1", f6);
		imagens.put("VD4", f5);
		imagens.put("VD3", f4);
		imagens.put("VD2", f3);
		imagens.put("VD1", f2);
		imagens.put("VC3", f1);
		imagens.put("VC2", f0);
		imagens.put("VC1", e9);
		imagens.put("VB1", e7);
		imagens.put("VB2", e8);
		imagens.put("A1", a1);
		imagens.put("B1", b1);
		imagens.put("B2", b2);
		imagens.put("C1", c1);
		imagens.put("C2", c2);
		imagens.put("C3", c3);
		imagens.put("D1", d1);
		imagens.put("D2", d2);
		imagens.put("D3", d3);
		imagens.put("D4", d4);
		imagens.put("E1", e1);
		imagens.put("E2", e2);
		imagens.put("E3", e3);
		imagens.put("E4", e4);
		imagens.put("E5", e5);
		imagens.put("agua", agua);
		imagens.put("bomba", e6);
	}
	
	public Icon selecionarImagem (String imagem){
		return imagens.get(imagem);
	}

}
