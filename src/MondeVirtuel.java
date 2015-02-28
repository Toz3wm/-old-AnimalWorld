import java.awt.Color;
import java.util.Vector;


public class MondeVirtuel {
	
	private Color CouleurCourante;
	private int largeur;
	private int longueur;
	//les cases du monde sont codées par une matrice de tableaux de deux cases: la première indique la quantité de nourriture sur la case, la deuxième indique le nombre d'animaux sur la case 
	private int[][][] matrice;
	private Vector<Animal> VecteurAnimaux;
	private FenetreMonde FenetreDuMonde;
	private boolean leMondeEstVide;
	//private FenetreBoutons LaFenetreBoutons;

	public MondeVirtuel(int largeur, int longueur) {
		this.largeur = largeur;
		this.longueur = longueur;
		this.VecteurAnimaux = new Vector<Animal>();
		this.FenetreDuMonde = new FenetreMonde(this);
		this.leMondeEstVide = true;
		//this.LaFenetreBoutons = new FenetreBoutons(this);
		
		this.matrice = new int[largeur][longueur][2];
		for (int i = 0; i < largeur; i++){
			for(int j = 0; j < longueur; j++){
				for (int k = 0; k < 2; k++){
					matrice[i][j][k] = 0;
				}
			}
		}
	}

	public int getLargeur() {
		return largeur;
	}
	
	public int getLongueur() {
		return longueur;
	}
	
	public int[] contenu(int x, int y){
		return matrice[x][y];
	}

	public void mouvementAnimal(int[] anciennePosition, int[] nouvellePosition) {
		matrice[anciennePosition[0]][anciennePosition[1]][1]--;
		matrice[nouvellePosition[0]][nouvellePosition[1]][1]++;
		this.FenetreDuMonde.go();
	}

	public void animalCree(int[] position, Animal unAnimal) {
		matrice[position[0]][position[1]][1]++;
		this.VecteurAnimaux.add(unAnimal);
		this.leMondeEstVide = false;
		
	}
	
	public void nourritureCree(int[] position) {
		matrice[position[0]][position[1]][0]++;
	}
	
	public void nourritureMangee(int[] position) {
		matrice[position[0]][position[1]][0]--;
	}

	public Vector<Animal> getVecteurAnimaux() {
		return VecteurAnimaux;
	}

	public boolean isLeMondeEstVide() {
		return leMondeEstVide;
	}

	public int[][][] getMatrice() {
		return matrice;
	}

	public FenetreMonde getFenetreDuMonde() {
		return FenetreDuMonde;
	}

	public void setFenetreDuMonde(FenetreMonde fenetreDuMonde) {
		FenetreDuMonde = fenetreDuMonde;
	}

	public Color getCouleurCourante() {
		return CouleurCourante;
	}

	public void setCouleurCourante(Color couleurCourante) {
		CouleurCourante = couleurCourante;
	}

	
}
