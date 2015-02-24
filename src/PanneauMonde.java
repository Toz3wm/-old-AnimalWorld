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
	private Vector<Animal> VecteurAnimaux; 
	//On simplifie l'écriture pour appeler le vecteur d'animaux


	public PanneauMonde(FenetreMonde maFenetreAssociee, MondeVirtuel unMonde) {
		super();
		MaFenetreAssociee = maFenetreAssociee;
		VecteurAnimaux =  unMonde.getVecteurAnimaux();

	}

	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){

		//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawRect(30, 30, this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur(),this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur());

		/*il faux déssiner tout les animaux du monde, à l'aide de l'attribut vecteur d'animaux 
	qu'on a créé dans la classe MondeVirtuel*/

		if (this.MaFenetreAssociee.getMonMondeVirtuel().isLeMondeEstVide() == false){
			for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().size();i++){

				//On redéfinit une couleur pour le rond
				g.setColor(Color.red);
				//On le dessine aux coordonnées souhaitées
				//attention à tenir compte du centre du cercle comme coordonnée
				g.fillOval(30-10+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[0], 30-10+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[1], 10, 10);
			}

			/*il faux déssiner toute la nourriture du monde, en parcourant toutes les cases de la matrice*/

			//on parcourt les abscisses horizontalement
			// x = i
			for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur();i++){
				//on parcourt les ordonnées, verticalement
				// y = j
				for (int j=0;j<this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur();j++){

					//On redéfinit une couleur pour le rond
					g.setColor(Color.blue);
					//On le dessine aux coordonnées souhaitées
					//attention à tenir compte du centre du cercle comme coordonnée

					//on redessine le cercle m fois, où m = quantité de nourriture sur la case de coordonnées (i,j)
					for (int m=0;m<this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0];m++){
						g.fillRect(30-10+i, 30-10+j, 5, 5);
					}
				}
			}
		}
	}

}