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
		g.setColor(Color.black);
		g.fillOval(0,0,20,20);
	}

	
	
}
