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

	private Color maCouleur;
	private FenetreMonde MaFenetreAssociee;
	private Vector<Animal> VecteurAnimaux; 
	//On simplifie l'�criture pour appeler le vecteur d'animaux


	public PanneauMonde(FenetreMonde maFenetreAssociee, MondeVirtuel unMonde) {
		super();
		MaFenetreAssociee = maFenetreAssociee;
		VecteurAnimaux =  unMonde.getVecteurAnimaux();

	}

	// m�thode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){

		//On choisit une couleur de fond pour le rectangle, pour pas laisser une train�e
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur(),this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur());

		/*il faux d�ssiner tout les animaux du monde, � l'aide de l'attribut vecteur d'animaux 
	qu'on a cr�� dans la classe MondeVirtuel*/

		/*if (this.MaFenetreAssociee.getMonMondeVirtuel().isLeMondeEstVide() == false)*/
			for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().size();i++){

				//On red�finit une couleur pour le rond
				//on r�cup�re l'info de la couleur courante
				maCouleur = this.getMaFenetreAssociee().getMonMondeVirtuel().getVecteurAnimaux().get(i).getMaCouleur();
				g.setColor(maCouleur);
				//On le dessine aux coordonn�es souhait�es
				//attention � tenir compte du centre du cercle comme coordonn�e
				g.fillOval(10+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[0],10+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[1], 10, 10);
			}

			/*il faux d�ssiner toute la nourriture du monde, en parcourant toutes les cases de la matrice*/

			//on parcourt les abscisses horizontalement
			// x = i
			for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur()-1;i++){

				//on parcourt les ordonn�es, verticalement
				// y = j
				for (int j=0;j<this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur()-1;j++){

					//On red�finit une couleur pour le rectangle
					g.setColor(Color.blue);

					//on v�rifie si il y a de la nourriture
					if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] !=0 ){

						//on redessine le rectangle m fois, o� m = quantit� de nourriture sur la case de coordonn�es (i,j)
						for (int m=1;m<=this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0];){
							g.fillRect(2+i, 2+j, 5, 5);
							
							int qteNourriture = this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0];
							System.out.println("qt� nourriture en" +"("+i+","+j+")"+"="  + qteNourriture);
							m++;
						}
						if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] ==0 ) 
						{System.out.println("rien");}
							
						}
					}
				}
			}
		

	public FenetreMonde getMaFenetreAssociee() {
		return MaFenetreAssociee;
	}

	public void setMaFenetreAssociee(FenetreMonde maFenetreAssociee) {
		MaFenetreAssociee = maFenetreAssociee;
	}

}