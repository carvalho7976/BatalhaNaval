package Cliente;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JDesktopPane;

public class DesktopPersonalizado extends JDesktopPane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MapLayoutes layoutes = new MapLayoutes();
	Image imagem;

	public DesktopPersonalizado(String opcao) {
		System.out.println(opcao);
		System.out.println(layoutes.retornaLayoute(opcao));
		java.net.URL caminho = DesktopPersonalizado.class.getResource(layoutes
				.retornaLayoute(opcao));
		try {
			imagem = javax.imageio.ImageIO.read(caminho);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagem != null)
			g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);
		else
			g.drawString("Imagem nao encontrada", 50, 50);
	}

}
