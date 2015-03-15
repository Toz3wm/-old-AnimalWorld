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
	//On simplifie l'�criture pour appeler le vecteur d'animaux


	public PanneauMonde(FenetreMonde maFenetreAssociee, MondeVirtuel unMonde) {
		super();
		MaFenetreAssociee = maFenetreAssociee;
		//VecteurAnimaux =  unMonde.getVecteurAnimaux();

	}

	// m�thode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics gg){
		
		//System.out.println("on a bien fait un repaint du monde!");
		//On choisit une couleur de fond pour le rectangle, pour pas laisser une train�e
		gg.setColor(Color.white);
		//On le dessine de sorte qu'il occupe toute la surface
		gg.fillRect(0, 0, this.getWidth()*2, this.getHeight()*2);
		gg.setColor(Color.black);
		gg.drawRect(10, 10, this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur()*2,this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur()*2);
		//System.out.println("on a bien fait un repaint du monde!");
		
		/*il faux dessiner tout les animaux du monde, � l'aide de l'attribut vecteur d'animaux 
	qu'on a cr�� dans la classe MondeVirtuel*/
/*
		if (this.MaFenetreAssociee.getMonMondeVirtuel().isLeMondeEstVide() == false)
			for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().size();i++){

				//On red�finit une couleur pour le rond
				//on r�cup�re l'info de la couleur courante
				gg.setColor(this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getMaCouleur());
				//On le dessine aux coordonn�es souhait�es
				gg.fillOval(8+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[0],8+this.MaFenetreAssociee.getMonMondeVirtuel().getVecteurAnimaux().get(i).getPosition()[1], 2, 2);
			}*/

		
			/*il faux dessiner toute la nourriture du monde, en parcourant toutes les cases de la matrice*/

		//on parcourt les abscisses horizontalement
		// x = i
		for (int i=0;i<this.MaFenetreAssociee.getMonMondeVirtuel().getLargeur()-1;i++){

			//on parcourt les ordonn�es, verticalement
			// y = j
			for (int j=0;j<this.MaFenetreAssociee.getMonMondeVirtuel().getLongueur()-1;j++){



				//on v�rifie si il y a des animaux
				/*if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][1] !=0 ){
					gg.setColor(Color.red);
					//on redessine le cercle m fois, o� m = quantit� de nourriture sur la case de coordonn�es (i,j)

					//g.fillOval(5+i, 5+j, 10, 10);

					//int nbAnimaux = this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][1];
					//System.out.println("nombre d'animaux en" +"("+i+","+j+")"+"="  + nbAnimaux);


				}*/

				//On red�finit une couleur pour le rectangle
				gg.setColor(Color.blue);
				//on v�rifie si il y a de la nourriture
				if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] !=0 ){
						gg.fillRect(10+i*2, 10+j*2, 2, 2);
						//int qteNourriture = this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0];
						//System.out.println("qt� nourriture en" +"("+i+","+j+")"+"="  + qteNourriture);
						
					if (this.MaFenetreAssociee.getMonMondeVirtuel().getMatrice()[i][j][0] ==0 ){
						System.out.println("rien");
						}
				}


			}
			
		}
		this.MaFenetreAssociee.semtest.release();
	}



	public void paintAnimal(Animal unAnimal,int[] anciennePosition, int[] nouvellePosition){
		 Graphics gg = this.getGraphics();
		 gg.setColor(Color.white);
		 gg.fillRect(10+anciennePosition[0]*2, 10+anciennePosition[1]*2, 2, 2);
		 //on r�cup�re la couleur de l'animal
		 gg.setColor(unAnimal.getMaCouleur());
		 
		 gg.fillRect(10+nouvellePosition[0]*2, 10+nouvellePosition[1]*2, 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	public void paintAnimalInitial(Animal unAnimal,int[] Position){
		 Graphics gg = this.getGraphics();

		 //on r�cup�re la couleur de l'animal
		gg.setColor(unAnimal.getMaCouleur());
		 
		 gg.fillRect(10+Position[0]*2, 10+Position[1]*2, 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	public void paintNourriture(int[] position){
		 Graphics gg = this.getGraphics();
		 gg.setColor(Color.blue);
		 gg.fillRect(10+position[0]*2, 10+position[1]*2, 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	public void unPaintNourriture(int[] position){
		 Graphics gg = this.getGraphics();
		 gg.setColor(Color.white);
		 gg.fillRect(10+position[0]*2,10+position[1]*2, 2, 2);
		this.MaFenetreAssociee.semtest.release();
		}
	
	
	
	public FenetreMonde getMaFenetreAssociee() {
		return MaFenetreAssociee;
	}

	public void setMaFenetreAssociee(FenetreMonde maFenetreAssociee) {
		MaFenetreAssociee = maFenetreAssociee;
	}

}