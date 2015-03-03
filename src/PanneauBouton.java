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

	// m�thode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics gg){

		//On choisit une couleur de fond pour le rectangle, pour pas laisser une train�e
		gg.setColor(Color.white);
	}
	
	public void AfficheAnimalCree(Graphics gg){
		Font font = new Font("Courier", Font.BOLD, 20);
	    gg.setFont(font);
	    gg.setColor(Color.RED); 
	    //g.drawString("coucou", 10, 20);
	}

}