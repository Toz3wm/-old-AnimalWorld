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

public class PanneauLecture extends JPanel { 

	private FenetreLecture MaFenetreAssociee;

	public PanneauLecture(FenetreLecture maFenetreAssociee) {
		MaFenetreAssociee = maFenetreAssociee;
		this.setBackground(Color.white);
	}

	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){
		
		//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
		g.setColor(Color.white);
	}
}