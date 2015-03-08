import java.awt.Color;
import java.util.Iterator;
import java.util.Vector;


public class MondeVirtuel {
	private GlobalVars c;
	private Color CouleurCourante;
	private int largeur;
	private int longueur;
	//les cases du monde sont codées par une matrice de tableaux de deux cases: la première indique la quantité de nourriture sur la case, la deuxième indique le nombre d'animaux sur la case 
	private int[][][] matrice;
	private Vector<Animal> VecteurAnimaux;
	private FenetreMonde FenetreDuMonde;
	private boolean leMondeEstVide;
	private int nbNourriture;
	//private FenetreBoutons LaFenetreBoutons;
	private Vector<ThreadAnimal> vectThreadAnimal;
	private Animal[] meilleursAnimaux;
	private int remplissageMeilleurAnimaux;
	private FenetreResultat FenetreResultat;

	public MondeVirtuel(int largeur, int longueur, GlobalVars c) {
		this.c = c;
		this.largeur = largeur;
		this.longueur = longueur;
		this.VecteurAnimaux = new Vector<Animal>();
		this.FenetreDuMonde = new FenetreMonde(this,c);
		this.leMondeEstVide = true;
		//this.LaFenetreBoutons = new FenetreBoutons(this);
		this.vectThreadAnimal = new Vector<ThreadAnimal>();
		this.meilleursAnimaux = new Animal[5];
		this.remplissageMeilleurAnimaux = 0;
		this.FenetreResultat = new FenetreResultat(this);

		this.matrice = new int[largeur][longueur][2];
		for (int i = 0; i < largeur; i++){
			for(int j = 0; j < longueur; j++){
				for (int k = 0; k < 2; k++){
					matrice[i][j][k] = 0;
				}
			}
		}
	}

	public void backUp(){
		Iterator<ThreadAnimal> it = vectThreadAnimal.iterator();
		ThreadAnimal t;
		while (it.hasNext()) {
			t= it.next();
			t.saveAnimal(t.getAnimal().getName());
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
		//System.out.println("un animal a bougé!");
		this.FenetreDuMonde.paintAnimal(anciennePosition, nouvellePosition);
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
		nbNourriture--;
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

	public GlobalVars getConstante() {
		return c;
	}

	public FenetreMonde getFenetreMonde() {
		return this.FenetreDuMonde;
	}

	public void nbNourriture(int a){
		nbNourriture += a;
	}

	public void updateVectThreadAnimal(ThreadAnimal a){
		this.vectThreadAnimal.add(a);
	}

	public void updateScore(ThreadAnimal threadAnimal) {
		Animal ani = threadAnimal.getAnimal();
		if (this.remplissageMeilleurAnimaux <= 4){
			if (this.remplissageMeilleurAnimaux == 0){
				this.meilleursAnimaux[0] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if (this.remplissageMeilleurAnimaux == 1){
				this.meilleursAnimaux[1] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if (this.remplissageMeilleurAnimaux == 2){
				this.meilleursAnimaux[2] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if (this.remplissageMeilleurAnimaux == 3){
				this.meilleursAnimaux[3] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if (this.remplissageMeilleurAnimaux == 4){
				this.meilleursAnimaux[4] = ani;
				this.remplissageMeilleurAnimaux++;
			}
		} else {
			if (this.meilleursAnimaux[0].getScore() <= ani.getScore()){
				this.meilleursAnimaux[0] = ani;
				this.FenetreResultat.getPanneau().repaint();
			} else if (this.meilleursAnimaux[1].getScore() <= ani.getScore()){
				this.meilleursAnimaux[1] = ani;
				this.FenetreResultat.getPanneau().repaint();
			} else if (this.meilleursAnimaux[2].getScore() <= ani.getScore()){
				this.meilleursAnimaux[2] = ani;
				this.FenetreResultat.getPanneau().repaint();
			} else if (this.meilleursAnimaux[3].getScore() <= ani.getScore()){
				this.meilleursAnimaux[3] = ani;
				this.FenetreResultat.getPanneau().repaint();
			} else if (this.meilleursAnimaux[4].getScore() <= ani.getScore()){
				this.meilleursAnimaux[4] = ani;
				this.FenetreResultat.getPanneau().repaint();
			}


	}

}

}
