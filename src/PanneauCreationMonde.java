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

public class PanneauCreationMonde extends JPanel { 

	private FenetreCreationMonde MaFenetreAssociee;

	public PanneauCreationMonde(FenetreCreationMonde maFenetreAssociee) {
		MaFenetreAssociee = maFenetreAssociee;
		this.setBackground(Color.white);
	}

	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){
		//System.out.println("Paintcomponent de la fenetre de crea de monde appelé");
		//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
		g.setColor(Color.white);
	}
	
	public void AfficheAnimalCree(Graphics g){
		Font font = new Font("Courier", Font.BOLD, 20);
	    g.setFont(font);
	    g.setColor(Color.RED); 
	    g.drawString("coucou", 10, 20);
	}

}