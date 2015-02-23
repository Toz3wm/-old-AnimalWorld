import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class PanneauResultat extends JPanel {
	
	PanneauResultat(){
	  this.setBackground(Color.red);
	}

	public void paintComponent(Graphics g){
		System.out.println("paintComponent appelée! ");
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On redéfinit une couleur pour le rond
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		diagrammePentagone(20, 20, g);
		diagrammePentagone(20,400, g);
	}

	public void diagrammePentagone(int posX, int posY, Graphics g){
		float[] tab = Color.RGBtoHSB(160, 160, 160, new float[3]);
		
		g.setColor(Color.getHSBColor(tab[0],tab[1], tab[2]));
		g.drawOval(posX,posY,120,120);
		g.drawOval(posX+12,posY+12,96,96);
		g.drawOval(posX+24,posY+24,72,72);
		g.drawOval(posX+36,posY+36,48,48);
		g.drawOval(posX+48,posY+48,24,24);
		
	}
	
}
