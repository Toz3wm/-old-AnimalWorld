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

public class PanneauMonde extends JPanel { 

	private FenetreMonde MaFenetreAssociee;
	private Vector<Animal> VecteurAnimaux = this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux();
	//On simplifie l'écriture pour appeler le vecteur d'animaux
			
	
	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){

		//écrire
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.RED); 
		g.drawString("coucou", 10, 20);

	
	//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
	g.setColor(Color.white);
	//On le dessine de sorte qu'il occupe toute la surface
	g.fillRect(0, 0, this.getWidth(), this.getHeight());

	/*il faux déssiner tour les animaux du monde, à l'aide de l'attribut vecteur d'animaux 
	qu'on a créé dans la classe MondeVirtuel*/

	for (int i=0;i<this.VecteurAnimaux.size();i++){
		
		//On redéfinit une couleur pour le rond
		g.setColor(Color.red);
		//On le dessine aux coordonnées souhaitées
		g.fillOval(this.VecteurAnimaux.get(i).getPosition()[1], this.VecteurAnimaux.get(i).getPosition()[2], 50, 50);
	}
	
}

	public void MiseAJourPanneau() {
		VecteurAnimaux = this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux();
		
	}



}