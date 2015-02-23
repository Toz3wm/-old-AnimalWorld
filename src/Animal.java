import java.io.Serializable ;


public class Animal implements Serializable  {


	//l'int orientation désigne l'orientation de l'animal dans l'espace
	//0 désigne le nord, 1 le nord-est, 2 l'est... jusqu'à 7 le nord-ouest
	private String name;
	private int orientation;
	//table des déplacements absolus
	private final int[][] deplacementAbsolu;

	private int[] position;

	//5 caractères à définir
	private double pbaAvant;
	private double pbaAvantGauche;
	private double pbaAvantDroit;
	private double pbaArriereGauche;
	private double pbaArriereDroit;

	//estomac: compte la nourriture, si 0, l'animal s'arrête de bouger
	private int estomac; 
	private int score;
	

	public Animal(double pbaAvanta,
			double pbaAvantGauchea, double pbaAvantDroita, double pbaArriereGauchea, double pbaArriereDroita, int estomaca, int orientationa, MondeVirtuel leMonde, String namea ) {
		super();
		this.name = namea;
		//l'animal apparait sur une case aléatoire
		this.position = new int[2];
		position[0] = (int)(Math.random()*leMonde.getLargeur()) ;
		position[1] =(int)(Math.random()*leMonde.getLongueur());
		leMonde.animalCree(position, this);

		this.deplacementAbsolu = new int[8][2];
		this.deplacementAbsolu[0][0] = -1 ;
		this.deplacementAbsolu[1][0] = -1 ;
		this.deplacementAbsolu[2][0] = 0 ;
		this.deplacementAbsolu[3][0] = 1 ;
		this.deplacementAbsolu[4][0] = 1 ;
		this.deplacementAbsolu[5][0] = 1 ;
		this.deplacementAbsolu[6][0] = 0 ;
		this.deplacementAbsolu[7][0] = -1 ;
		this.deplacementAbsolu[0][1] = 0 ;
		this.deplacementAbsolu[1][1] = 1 ;
		this.deplacementAbsolu[2][1] = 1 ;
		this.deplacementAbsolu[3][1] = 1 ;
		this.deplacementAbsolu[4][1] = 0 ;
		this.deplacementAbsolu[5][1] = -1 ;
		this.deplacementAbsolu[6][1] = -1 ;
		this.deplacementAbsolu[7][1] = -1 ;

		this.orientation = orientationa;
		this.pbaAvant = pbaAvanta;
		this.pbaAvantGauche = pbaAvantGauchea;
		this.pbaAvantDroit = pbaAvantDroita;
		this.pbaArriereGauche = pbaArriereGauchea;
		this.pbaArriereDroit = pbaArriereDroita;
		this.estomac = estomaca;
		this.score = 0;
	}

	public Animal(int estomaca, MondeVirtuel leMonde, String namea ) {
		super();
		this.name = namea;
		//l'animal apparait sur une case aléatoire
		this.position = new int[2];
		position[0] = (int)(Math.random()*leMonde.getLargeur()) ;
		position[1] =(int)(Math.random()*leMonde.getLongueur());
		leMonde.animalCree(position,this);

		this.deplacementAbsolu = new int[8][2];
		//déplacement absolu pour les abscisses x
		this.deplacementAbsolu[0][0] = -1 ;
		this.deplacementAbsolu[1][0] = -1 ;
		this.deplacementAbsolu[2][0] = 0 ;
		this.deplacementAbsolu[3][0] = 1 ;
		this.deplacementAbsolu[4][0] = 1 ;
		this.deplacementAbsolu[5][0] = 1 ;
		this.deplacementAbsolu[6][0] = 0 ;
		this.deplacementAbsolu[7][0] = -1 ;
		// déplacement absolu pour les ordonnées y
		this.deplacementAbsolu[0][1] = 0 ;
		this.deplacementAbsolu[1][1] = 1 ;
		this.deplacementAbsolu[2][1] = 1 ;
		this.deplacementAbsolu[3][1] = 1 ;
		this.deplacementAbsolu[4][1] = 0 ;
		this.deplacementAbsolu[5][1] = -1 ;
		this.deplacementAbsolu[6][1] = -1 ;
		this.deplacementAbsolu[7][1] = -1 ;

		this.orientation = (int) (8*Math.random());
		
		
		//module permettant de créer des probabilités aléatoires dans les 5 directions
		this.pbaAvant = Math.random();
		this.pbaAvantGauche = Math.random();
		this.pbaAvantDroit = Math.random();
		this.pbaArriereGauche = Math.random();
		this.pbaArriereDroit = Math.random();
		double total = pbaAvant + pbaAvantGauche + pbaAvantDroit + pbaArriereDroit + pbaArriereGauche; 
		this.pbaAvant /= total; 
		this.pbaAvantGauche /= total;
		this.pbaAvantDroit /= total;
		this.pbaArriereGauche /= total;
		this.pbaArriereDroit /= total;
		this.estomac = estomaca;
		this.score = 0;
	}

	public void bouger(MondeVirtuel leMonde){
		double choix = Math.random();
		int deplacement;
		estomac--;
		// définit par rapport aux probabilités le déplacement relatif 
		//avant: 0
		//avant gauche: 1	avant droit:3
		//arrière gauche: 5  arrière droit: 7
		if (choix <= pbaAvant) {
			deplacement = 0;
		} else if (choix <=(pbaAvant + pbaAvantDroit)){
			deplacement = 1;
		} else if (choix <= (pbaAvant + pbaAvantDroit + pbaArriereDroit)) {
			deplacement = 3;
		} else if (choix <= (pbaAvant + pbaAvantDroit + pbaArriereDroit + pbaArriereGauche)) {
			deplacement = 5;
		} else {
			deplacement = 7;			
		}

		//mise à jour du déplacement: il désigne maintenant le déplacement absolu
		deplacement  = (deplacement + orientation) % 8;
		//Mise  à jour de l'orientation
		orientation = deplacement; 

		//on stocke l'ancienne position
		int[] anciennePosition = new int[2];
		anciennePosition=position;

		//mise à jour des coordonnées x et y
		position[0] =( position[0] + deplacementAbsolu[deplacement][0])%leMonde.getLargeur();
		position[1] = (position[1] + deplacementAbsolu[deplacement][1])%leMonde.getLongueur();

		//attention, il faut encore signifier au monde que l'on a bougé: mise à jour des cases du monde
		leMonde.mouvementAnimal(anciennePosition, position);
	}

	public void mange(MondeVirtuel leMonde){
		//si il y a de la nourriture disponible, il mange
		if (leMonde.contenu(this.position[0],this.position[1])[0]!=0){
			leMonde.nourritureMangee(this.position);}
		//il faut mettre à jour l'estomac et le score
		estomac++;
		score++;
	}

	public int getEstomac(){
		return estomac;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return name;
	}
	
	public int[] getPosition(){
		return position;
	}
}

