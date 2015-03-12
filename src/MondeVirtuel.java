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
	private FenetreLecture MaFenetreLecture;
	private boolean leMondeEstVide;
	private int nbNourriture;
	//private FenetreBoutons LaFenetreBoutons;
	private Vector<ThreadAnimal> vectThreadAnimal;
	private Animal[] meilleursAnimaux;
	private int remplissageMeilleurAnimaux;
	private FenetreResultat FenetreResultat;
	private FenetreBoutons laFenetreBoutons;
	// compteur d'animaux morts
		private int nbAnimauxTousMorts;

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

	public void mouvementAnimal(Animal unAnimal,int[] anciennePosition, int[] nouvellePosition) {
		matrice[anciennePosition[0]][anciennePosition[1]][1]--;
		matrice[nouvellePosition[0]][nouvellePosition[1]][1]++;
		//System.out.println("un animal a bougé!");
		this.FenetreDuMonde.paintAnimal(unAnimal,anciennePosition, nouvellePosition);
		
	}

	public void animalCree(int[] position, Animal unAnimal) {
		matrice[position[0]][position[1]][1]++;
		this.VecteurAnimaux.add(unAnimal);
		this.leMondeEstVide = false;

	}

	public void nourritureCree(int[] position) {

		matrice[position[0]][position[1]][0]++;
		this.FenetreDuMonde.paintNourriture(position);
	}

	public void nourritureMangee(int[] position) {
		matrice[position[0]][position[1]][0]--;
		nbNourriture--;
		this.FenetreDuMonde.unPaintNourriture(position);
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

	/*public void updateScore(ThreadAnimal threadAnimal) {
		Animal ani = threadAnimal.getAnimal();
// ATTENTION : CETTE METHODE PEUT CONDUIRE A UN TABLEAU REMPLI CINQ FOIS DU MEME ANIMAL S'IL N Y A QU'UN ANIMAL VIVANT
		System.out.println(remplissageMeilleurAnimaux);
		if (this.remplissageMeilleurAnimaux <= 4){
			if (this.remplissageMeilleurAnimaux == 0){
				this.meilleursAnimaux[0] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if ((this.remplissageMeilleurAnimaux == 1) && (this.meilleursAnimaux[0] != ani)){
				this.meilleursAnimaux[1] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if ((this.remplissageMeilleurAnimaux == 2)  && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani)){
				this.meilleursAnimaux[2] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if ((this.remplissageMeilleurAnimaux == 3) && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani) && (this.meilleursAnimaux[2] != ani)){
				this.meilleursAnimaux[3] = ani;
				this.remplissageMeilleurAnimaux++;
			} else if ((this.remplissageMeilleurAnimaux == 4) && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani) && (this.meilleursAnimaux[2] != ani) && (this.meilleursAnimaux[3] != ani) ){
				this.meilleursAnimaux[4] = ani;
				this.remplissageMeilleurAnimaux++;
			}
		} else {
			if ((this.meilleursAnimaux[0].getScore() <= ani.getScore())  && (this.meilleursAnimaux[0] != ani)) {
				this.meilleursAnimaux[0] = ani;
				this.FenetreResultat.paintResult(this.meilleursAnimaux);
			} else if ((this.meilleursAnimaux[1].getScore() <= ani.getScore())  && (this.meilleursAnimaux[1] != ani)){
				this.meilleursAnimaux[1] = ani;
				this.FenetreResultat.paintResult(this.meilleursAnimaux);
			} else if ((this.meilleursAnimaux[2].getScore() <= ani.getScore())  && (this.meilleursAnimaux[0] != ani)){
				this.meilleursAnimaux[2] = ani;
				this.FenetreResultat.paintResult(this.meilleursAnimaux);
			} else if ((this.meilleursAnimaux[3].getScore() <= ani.getScore())  && (this.meilleursAnimaux[0] != ani)){
				this.meilleursAnimaux[3] = ani;
				this.FenetreResultat.paintResult(this.meilleursAnimaux);
			} else if ((this.meilleursAnimaux[4].getScore() <= ani.getScore()) && (this.meilleursAnimaux[0] != ani)){
				this.meilleursAnimaux[4] = ani;
				this.FenetreResultat.paintResult(this.meilleursAnimaux);
			}

	}

}*/

	public void updateScore(ThreadAnimal threadAnimal) {
		Animal ani = threadAnimal.getAnimal();
		// ATTENTION : CETTE METHODE PEUT CONDUIRE A UN TABLEAU REMPLI CINQ FOIS DU MEME ANIMAL S'IL N Y A QU'UN ANIMAL VIVANT
		//System.out.println("il y a dans meilleursanimaux: "+remplissageMeilleurAnimaux);
		//System.out.println("les meilleurs animaux sont : "+ meilleursAnimaux);
		//System.out.println(ani.getName()+" score: "+ani.getScore());
		

		//cas où il y a encore de la place dans le tableau
		
		// si il y a de la place
		if (this.remplissageMeilleurAnimaux <= 4){

			//si tableau vide
			if (this.remplissageMeilleurAnimaux == 0){
				this.meilleursAnimaux[0] = ani;
				this.remplissageMeilleurAnimaux++;
				System.out.println("tableau vide je remplis");
				
				//si tableau a 1 animal
			} else if ((this.remplissageMeilleurAnimaux == 1) /*&& (this.meilleursAnimaux[0] != ani)*/){
				//si ani est meilleur que le n°1
				if (this.meilleursAnimaux[0].getScore()<ani.getScore()){
					this.meilleursAnimaux[1] = this.meilleursAnimaux[0];
					this.meilleursAnimaux[0] = ani;
					this.remplissageMeilleurAnimaux++;
					System.out.println("1 animal dans tableau mais je suis meilleur");
				}
				else{
					this.meilleursAnimaux[1] = ani;
					this.remplissageMeilleurAnimaux++;
					System.out.println("1 animal dans tableau mais je suis pas meilleur");
				}

				//si le tableau a 2 animaux
			} else if ((this.remplissageMeilleurAnimaux == 2)  && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani)){
				//si ani est meilleur que le n°1
				if (this.meilleursAnimaux[0].getScore()<ani.getScore()){
					this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
					this.meilleursAnimaux[1] = this.meilleursAnimaux[0];
					this.meilleursAnimaux[0] = ani;
					this.remplissageMeilleurAnimaux++;
				}
				else{
					//si ani meilleur que le n°2
					if (this.meilleursAnimaux[1].getScore()<ani.getScore()){

						this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
						this.meilleursAnimaux[1] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani n'est pas meilleur que les précédents
					else {
						this.meilleursAnimaux[2] = ani;
						this.remplissageMeilleurAnimaux++;
					}
				}

				//si le tableau a 3 animaux
			} else if ((this.remplissageMeilleurAnimaux == 3) && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani) && (this.meilleursAnimaux[2] != ani)){
				//si ani est meilleur que le n°1
				if (this.meilleursAnimaux[0].getScore()<ani.getScore()){
					this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
					this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
					this.meilleursAnimaux[1] = this.meilleursAnimaux[0];
					this.meilleursAnimaux[0] = ani;
					this.remplissageMeilleurAnimaux++;
				}
				else{
					//si ani meilleur que le n°2
					if (this.meilleursAnimaux[1].getScore()<ani.getScore()){
						this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
						this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
						this.meilleursAnimaux[1] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani meilleur que le n°3
					if (this.meilleursAnimaux[2].getScore()<ani.getScore()){
						this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
						this.meilleursAnimaux[2] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani n'est pas meilleur que les précédents
					else {
						this.meilleursAnimaux[3] = ani;
						this.remplissageMeilleurAnimaux++;
					}
				}
			}
			// si le tableau a 4 animaux
			else if ((this.remplissageMeilleurAnimaux == 4) && (this.meilleursAnimaux[0] != ani)  && (this.meilleursAnimaux[1] != ani) && (this.meilleursAnimaux[2] != ani) && (this.meilleursAnimaux[3] != ani) ){
				//si ani est meilleur que le n°1
				if (this.meilleursAnimaux[0].getScore()<ani.getScore()){
					this.meilleursAnimaux[4] = this.meilleursAnimaux[3];
					this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
					this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
					this.meilleursAnimaux[1] = this.meilleursAnimaux[0];
					this.meilleursAnimaux[0] = ani;
					this.remplissageMeilleurAnimaux++;
				}
				else{
					//si ani meilleur que le n°2
					if (this.meilleursAnimaux[1].getScore()<ani.getScore()){
						this.meilleursAnimaux[4] = this.meilleursAnimaux[3];
						this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
						this.meilleursAnimaux[2] = this.meilleursAnimaux[1];
						this.meilleursAnimaux[1] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani meilleur que le n°3
					if (this.meilleursAnimaux[2].getScore()<ani.getScore()){
						this.meilleursAnimaux[4] = this.meilleursAnimaux[3];
						this.meilleursAnimaux[3] = this.meilleursAnimaux[2];
						this.meilleursAnimaux[2] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani meilleur que le n°4
					if (this.meilleursAnimaux[3].getScore()<ani.getScore()){
						this.meilleursAnimaux[4] = this.meilleursAnimaux[3];
						this.meilleursAnimaux[3] = ani;
						this.remplissageMeilleurAnimaux++;
					}
					//si ani n'est pas meilleur que les précédents
					else {
						this.meilleursAnimaux[4] = ani;
						this.remplissageMeilleurAnimaux++;
					}
				}
			}
		}

		else
			//cas où le tableau est rempli entièrement (5 cases prises)
			//Si ani est meilleurs que le n°1 du tableau
			if (this.meilleursAnimaux[0].getScore()<ani.getScore()){
				//on écrase du bas vers le haut
				this.meilleursAnimaux[4]=this.meilleursAnimaux[3];
				this.meilleursAnimaux[3]=this.meilleursAnimaux[2];
				this.meilleursAnimaux[2]=this.meilleursAnimaux[1];
				this.meilleursAnimaux[1]=this.meilleursAnimaux[0];
				this.meilleursAnimaux[0]=ani;
			}

		//Si ani est meilleurs que le n°2 du tableau
			else	if (this.meilleursAnimaux[1].getScore()<ani.getScore()){
				//on écrase du bas vers le haut
				this.meilleursAnimaux[4]=this.meilleursAnimaux[3];
				this.meilleursAnimaux[3]=this.meilleursAnimaux[2];
				this.meilleursAnimaux[2]=this.meilleursAnimaux[1];
				this.meilleursAnimaux[1]=ani;
			}
		//Si ani est meilleurs que le n°3 du tableau
			else	if (this.meilleursAnimaux[2].getScore()<ani.getScore()){
				//on écrase du bas vers le haut
				this.meilleursAnimaux[4]=this.meilleursAnimaux[3];
				this.meilleursAnimaux[3]=this.meilleursAnimaux[2];
				this.meilleursAnimaux[2]=ani;
			}	
		//Si ani est meilleurs que le n°4 du tableau
			else	if (this.meilleursAnimaux[3].getScore()<ani.getScore()){
				//on écrase du bas vers le haut
				this.meilleursAnimaux[4]=this.meilleursAnimaux[3];
				this.meilleursAnimaux[3]=ani;
			}		
		//Si ani est meilleurs que le n°5 du tableau
			else	if (this.meilleursAnimaux[4].getScore()<ani.getScore()){
				//on écrase du bas vers le haut
				this.meilleursAnimaux[4]=ani;
			}		

	}

	public FenetreResultat getFenetreResultat() {
		return FenetreResultat;
	}

	public GlobalVars getC() {
		return c;
	}

	public FenetreBoutons getLaFenetreBoutons() {
		return laFenetreBoutons;
	}

	public void setLaFenetreBoutons(FenetreBoutons laFenetreBoutons) {
		this.laFenetreBoutons = laFenetreBoutons;
	}

	public FenetreLecture getMaFenetreLecture() {
		return MaFenetreLecture;
	}

	public void setMaFenetreLecture(FenetreLecture maFenetreLecture) {
		MaFenetreLecture = maFenetreLecture;
	}

	public int getNbAnimauxTousMorts() {
		return nbAnimauxTousMorts;
	}

	public void setNbAnimauxTousMorts(int nbAnimauxTousMorts) {
		this.nbAnimauxTousMorts = nbAnimauxTousMorts;
	}

}
