import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

public class PanneauBouton extends JPanel { 

	private FenetreBoutons MaFenetreAssociee;

	public PanneauBouton(FenetreBoutons maFenetreAssociee, MondeVirtuel unMonde) {
		super();
		MaFenetreAssociee = maFenetreAssociee;
	}

	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){

		//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
		g.setColor(Color.white);
	
		g.setColor(Color.BLUE); 
	    //on trace des lignes de séparation entre les constructeurs
	    /*g.drawLine(0,this.MaFenetreAssociee.getHeight()*9/18, 
	    		this.MaFenetreAssociee.getWidth(),this.MaFenetreAssociee.getHeight()*9/18);
	    g.drawLine(0,this.MaFenetreAssociee.getHeight()*13/18, 
	    		this.MaFenetreAssociee.getWidth(),this.MaFenetreAssociee.getHeight()*13/18);
	    g.drawLine(0,this.MaFenetreAssociee.getHeight()*15/18, 
	    		this.MaFenetreAssociee.getWidth(),this.MaFenetreAssociee.getHeight()*15/18);
	    */
	}
	
	/*public void AfficheAnimalCree(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	}*/

}