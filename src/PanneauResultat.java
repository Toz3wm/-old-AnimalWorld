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
		diagrammePentagone(160,20, g);
		diagrammePentagone(300,20, g);
		diagrammePentagone(90,160, g);
		diagrammePentagone(240,160, g);
		
	}

	public void diagrammePentagone(int posX, int posY, Graphics g){
		float[] tab = Color.RGBtoHSB(180, 180, 180, new float[3]);
		
		g.setColor(Color.getHSBColor(tab[0],tab[1], tab[2]));
		g.drawOval(posX,posY,120,120);
		g.drawOval(posX+12,posY+12,96,96);
		g.drawOval(posX+24,posY+24,72,72);
		g.drawOval(posX+36,posY+36,48,48);
		g.drawOval(posX+48,posY+48,24,24);
		g.setColor(Color.black);
		g.drawLine(posX+60, posY+60, (int) (posX+60-60*Math.cos(Math.PI/2)), (int) (posY+60-60*Math.sin(Math.PI/2)));
		g.drawLine(posX+60, posY+60, (int) (posX+60-60*Math.cos(Math.PI/2 + Math.PI*0.4)), (int) (posY+60-60*Math.sin(Math.PI/2 + Math.PI*0.4)));
		g.drawLine(posX+60, posY+60, (int) (posX+60-60*Math.cos(Math.PI/2 + Math.PI*1.2)), (int) (posY+60-60*Math.sin(Math.PI/2 + Math.PI*1.2)));
		g.drawLine(posX+60, posY+60, (int) (posX+60-60*Math.cos(Math.PI/2 + Math.PI*1.6)), (int) (posY+60-60*Math.sin(Math.PI/2 + Math.PI*1.6)));
		g.drawLine(posX+60, posY+60, (int) (posX+60-60*Math.cos(Math.PI/2 + Math.PI*0.8)), (int) (posY+60-60*Math.sin(Math.PI/2 + Math.PI*0.8)));
		
	}
	
}
