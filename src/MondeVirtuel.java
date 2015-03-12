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
	private Vector<Animal> m;
	private long cdAffichageScore;
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
		this.m = new Vector<Animal>();
		this.cdAffichageScore = 0;
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

	
	public int vectscore(int  i){
		return m.get(i).getScore();
	}

	void updateScore(ThreadAnimal a){
		Animal e = a.getAnimal();
		int score = e.getScore();
		boolean chgt = false; 
		// on teste si l'animal est déjà dans le vecteur


		//System.out.println(m);
		m.remove(e);

		
		//si le vecteur est vide
		if (m.isEmpty()){
			//on y met l'animal
			chgt = true; m.add(0, e);
			System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
		}//sinon
		else if (m.size()==1){
			//on compare les deux scores et on agit en conséquence
			boolean true0 = (score > vectscore(0));
			if (true0){
				chgt = true; m.add(0, e); 
				System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
			} 
			else {
				chgt = true; m.add(1,e); 
				System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 2eme place du tableau");
			}
		}
		//s'il y a deux animaux dans le vecteur
		else if (m.size()==2){
			boolean true1 = (score > vectscore(1));
			boolean true0 = (score > vectscore(0));

			if (true1) {
				if (true0){
					chgt = true; m.add(0,e);
					System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
				} 
				else {
					chgt = true; m.add(1,e);
					System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 2eme place du tableau");
				}
			}
			else {
				chgt = true; m.add(2,e);
				System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 3eme place du tableau");
			}
		} 
		//s'il y a trois animaux dans le vecteur
		else if (m.size()==3) {
			boolean true1 = (score > vectscore(1));
			boolean true0 = (score > vectscore(0));
			boolean true2 = (score > vectscore(2));

			if (true2) {
				if (true1) {
					if (true0){
						chgt = true; m.add(0,e);
						System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
					} 
					else {
						chgt = true; m.add(1,e);
						System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 2eme place du tableau");
					}
				}
				else {
					chgt = true; m.add(2,e);
					System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 3eme place du tableau");
				}	
			}
			else {
				chgt = true; m.add(3,e);
				System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 4eme place du tableau");
			}
		}
		//s'il y a quatre animaux dans le vecteur
		else if (m.size()==4){
			boolean true1 = (score > vectscore(1));
			boolean true0 = (score > vectscore(0));
			boolean true2 = (score > vectscore(2));
			boolean true3 = (score > vectscore(3));

			if (true3) {
				if (true2) {
					if (true1) {
						if (true0){
							chgt = true; m.add(0,e);
							System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
						} 
						else {
							chgt = true; m.add(1,e);
							System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 2eme place du tableau");
						}
					}
					else {
						chgt = true; m.add(2,e);
						System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 3eme place du tableau");
					}	
				}
				else {
					chgt = true; m.add(3,e);
					System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 4eme place du tableau");
				}
			} 
			else {
				chgt = true; m.add(4,e);
				System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la dernière place du tableau");
			}
		}
		else {
			boolean true1 = (score > vectscore(1));
			boolean true0 = (score > vectscore(0));
			boolean true2 = (score > vectscore(2));
			boolean true3 = (score > vectscore(3));
			boolean true4 = (score > vectscore(4));

			if (true4) {
				if (true3) {
					if (true2) {
						if (true1) {
							if (true0){
								chgt = true; m.add(0,e);
								System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la première place du tableau");
							} 
							else {
								chgt = true; m.add(1,e);
								System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 2eme place du tableau");
							}
						}
						else {
							chgt = true; m.add(2,e);
							System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 3eme place du tableau");
						}	
					}
					else {
						chgt = true; m.add(3,e);
						System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la 4eme place du tableau");
					}
				}
				else {
					chgt = true; m.add(4,e);
					System.out.println("On met " + e.getName() + " score " + e.getScore() + "à la dernière place du tableau");
				}
			}
			else {
				//on a tout simplement rien à faire, le score est trop petit! 
			}
		}

	//	System.out.println(m);


		if (chgt && (System.currentTimeMillis() > (this.cdAffichageScore + 500)) ) {
			while (m.size()> 5 ){
				m.remove(m.size()-1);
				
			}
			System.out.println(this.cdAffichageScore);
			this.cdAffichageScore = System.currentTimeMillis();
			this.FenetreResultat.paintResult(m); 
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
