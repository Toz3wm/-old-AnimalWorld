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

	//private Color maCouleur;
	private FenetreMonde MaFenetreAssociee;
	//private Vector<Animal> VecteurAnimaux; 
	//On simplifie l'écriture pour appeler le vecteur d'animaux


	public PanneauMonde(FenetreMonde maFenetreAssociee, MondeVirtuel unMonde) {
		super();
		MaFenetreAssociee = maFenetreAssociee;
		//VecteurAnimaux =  unMonde.getVecteurAnimaux();

	}

	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){
		//System.out.println("on a bien fait un repaint du monde!");
		//On choisit une couleur de fond pour le rectangle, pour pas laisser une trainée
		g.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawRect(10, 10, this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur(),this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur());
		//System.out.println("on a bien fait un repaint du monde!");
		/*il faux dessiner tout les animaux du monde, à l'aide de l'attribut vecteur d'animaux 
	qu'on a créé dans la classe MondeVirtuel*/

		/*if (this.MaFenetreAssociee.getMonMondeVirtuel().isLeMondeEstVide() == false)*/
		/*	for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().size();i++){

				//On redéfinit une couleur pour le rond
				//on récupère l'info de la couleur courante
				maCouleur = this.getMaFenetreAssociee().getMonMondeVirtuel().getVecteurAnimaux().get(i).getMaCouleur();
				g.setColor(maCouleur);
				//On le dessine aux coordonnées souhaitées
				//attention à tenir compte du centre du cercle comme coordonnée
				g.fillOval(5+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[0],5+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[1], 10, 10);
			}

			/*il faux dessiner toute la nourriture du monde, en parcourant toutes les cases de la matrice*/

		//on parcourt les abscisses horizontalement
		// x = i
		for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur()-1;i++){

			//on parcourt les ordonnées, verticalement
			// y = j
			for (int j=0;j<this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur()-1;j++){



				//on vérifie si il y a des animaux
				if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][1] !=0 ){
					g.setColor(Color.red);
					//on redessine le cercle m fois, où m = quantité de nourriture sur la case de coordonnées (i,j)

					//g.fillOval(5+i, 5+j, 10, 10);

					//int nbAnimaux = this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][1];
					//System.out.println("nombre d'animaux en" +"("+i+","+j+")"+"="  + nbAnimaux);


				}

				//On redéfinit une couleur pour le rectangle
				g.setColor(Color.blue);
				//on vérifie si il y a de la nourriture
				if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] !=0 ){
						g.fillRect(10+i, 10+j, 1, 1);
						//int qteNourriture = this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0];
						//System.out.println("qté nourriture en" +"("+i+","+j+")"+"="  + qteNourriture);
						
				/*	if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] ==0 ){
						System.out.println("rien");
						}*/
				}


			}
			
		}
		this.MaFenetreAssociee.semtest.release();
	}


	public void paintAnimal(int[] anciennePosition, int[] nouvellePosition){
		 Graphics g = this.getGraphics();
		 g.setColor(Color.white);
		 g.fillRect(10+anciennePosition[0], 10+anciennePosition[1], 2, 2);
		 g.setColor(Color.red);
		 g.fillRect(10+nouvellePosition[0], 10+nouvellePosition[1], 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	public void paintNourriture(int[] position){
		 Graphics g = this.getGraphics();
		 g.setColor(Color.blue);
		 g.fillRect(position[0], position[1], 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	
	
	public FenetreMonde getMaFenetreAssociee() {
		return MaFenetreAssociee;
	}

	public void setMaFenetreAssociee(FenetreMonde maFenetreAssociee) {
		MaFenetreAssociee = maFenetreAssociee;
	}

}