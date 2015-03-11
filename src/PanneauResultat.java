import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;


public class PanneauResultat extends JPanel {
	float tabGris[];
	private FenetreResultat maFenetreAssociee;
	
	PanneauResultat(FenetreResultat uneFenetreAssociee){
		this.maFenetreAssociee = uneFenetreAssociee;
	  this.setBackground(Color.red);
	  tabGris = Color.RGBtoHSB(180, 180, 180, new float[3]);
		
	}

	public void paintComponent(Graphics g){
		System.out.println("paintComponent appelée! ");
		//On choisit une couleur de fond pour le rectangle
		g.setColor(Color.white);
		//On redéfinit une couleur pour le rond
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		/*diagrammePentagone(20, 20, g);
		diagrammePentagone(160,20, g);
		diagrammePentagone(300,20, g);
		diagrammePentagone(90,160, g);
		diagrammePentagone(240,160, g);
		pentagone(20,20,g,0.8,0.6,0.4,0.2,0.5);*/
	}
	
	public void diagrammePentagone(int posX, int posY, Graphics g){

		g.setColor(Color.getHSBColor(tabGris[0],tabGris[1], tabGris[2]));
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
	
	//attention: posX et posY sont les coordonnées du carré dans lequel s'inscrit l'ensemble de la figure (les coordonnées du coin en haut à gauche donc)
	public void pentagone(Animal a,int posX, int posY, Graphics g, double av, double avd, double ard, double arg, double avg){
		double tab[] = {av, avd, ard, arg, avg};
		int tabX[] = new int[5];
		int tabY[] = new int[5];
		for(int i = 0; i <5; i++){
			tabX[i] = (int) (posX+60-tab[i]*60*Math.cos(Math.PI/2 + Math.PI*0.4*i));
			tabY[i] = (int) (posX+60-tab[i]*60*Math.sin(Math.PI/2 + Math.PI*0.4*i));
		}
		g.setColor(a.getMaCouleur());
		g.fillPolygon(tabX, tabY, 5);
	}

	public void paintAnimal(int i,Animal a) {
		this.diagrammePentagone(20, 20 + 140*i, getGraphics());
		this.pentagone(a,20, 2+140*i, getGraphics(), a.getPbaAvant(), a.getPbaAvantDroit(), a.getPbaArriereDroit(), a.getPbaArriereGauche(), a.getPbaAvantGauche());
	}
	
}
