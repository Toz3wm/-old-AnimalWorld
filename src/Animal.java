import java.io.Serializable ;


public class Animal implements Serializable  {


	//l'int orientation d�signe l'orientation de l'animal dans l'espace
	//0 d�signe le nord, 1 le nord-est, 2 l'est... jusqu'� 7 le nord-ouest
	private int orientation;
	//table des d�placements absolus
	private final int[][] deplacementAbsolu;

	private int[] position;

	//5 caract�res � d�finir
	private double pbaAvant;
	private double pbaAvantGauche;
	private double pbaAvantDroit;
	private double pbaArriereGauche;
	private double pbaArriereDroit;

	//estomac: compte la nourriture, si 0, l'animal s'arr�te de bouger
	private int estomac; //
	private MondeVirtuel leMonde;

	public Animal(double pbaAvanta,
			double pbaAvantGauchea, double pbaAvantDroita, double pbaArriereGauchea, double pbaArriereDroita, int estomaca, int orientationa, MondeVirtuel unMonde ) {
		super();
		this.leMonde = unMonde;
		//l'animal apparait sur une case al�atoire
		this.position = new int[2];
		position[0] = (int)(Math.random()*leMonde.getLargeur()) ;
		position[1] =(int)(Math.random()*leMonde.getLongueur());
		this.leMonde.animalCree(position);

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
	}

	public Animal(int estomaca, MondeVirtuel unMonde ) {
		super();
		this.leMonde = unMonde;
		//l'animal apparait sur une case al�atoire
		this.position = new int[2];
		position[0] = (int)(Math.random()*leMonde.getLargeur()) ;
		position[1] =(int)(Math.random()*leMonde.getLongueur());
		this.leMonde.animalCree(position);

		this.deplacementAbsolu = new int[8][2];
		//d�placement absolu pour les abscisses x
		this.deplacementAbsolu[0][0] = -1 ;
		this.deplacementAbsolu[1][0] = -1 ;
		this.deplacementAbsolu[2][0] = 0 ;
		this.deplacementAbsolu[3][0] = 1 ;
		this.deplacementAbsolu[4][0] = 1 ;
		this.deplacementAbsolu[5][0] = 1 ;
		this.deplacementAbsolu[6][0] = 0 ;
		this.deplacementAbsolu[7][0] = -1 ;
		// d�placement absolu pour les ordonn�es y
		this.deplacementAbsolu[0][1] = 0 ;
		this.deplacementAbsolu[1][1] = 1 ;
		this.deplacementAbsolu[2][1] = 1 ;
		this.deplacementAbsolu[3][1] = 1 ;
		this.deplacementAbsolu[4][1] = 0 ;
		this.deplacementAbsolu[5][1] = -1 ;
		this.deplacementAbsolu[6][1] = -1 ;
		this.deplacementAbsolu[7][1] = -1 ;

		this.orientation = (int) (8*Math.random());
		this.pbaAvant = Math.random();
		this.pbaAvantGauche = (1 - pbaAvant) * Math.random();
		this.pbaAvantDroit = (1 - pbaAvant - pbaAvantGauche) *  Math.random();
		this.pbaArriereGauche = (1 - pbaAvant - pbaAvantGauche - pbaArriereGauche) * Math.random();
		this.pbaArriereDroit = (1 - pbaAvant - pbaAvantGauche - pbaArriereGauche - pbaArriereDroit);
		this.estomac = estomaca;
	}

	public void bouger(){
		double choix = Math.random();
		int deplacement;
		
		// d�finit par rapport aux probabilit�s le d�placement relatif 
		//avant: 0
		//avant gauche: 1	avant droit:3
		//arri�re gauche: 5  arri�re droit: 7
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
		
		//mise � jour du d�placement: il d�signe maintenant le d�placement absolu
		deplacement  = (deplacement + orientation) % 8;
		//Mise  � jour de l'orientation
		orientation = deplacement; 
		
		//on stocke l'ancienne position
		int[] anciennePosition = new int[2];
		anciennePosition=position;
		
		//mise � jour des coordonn�es x et y
		position[0] =( position[0] + deplacementAbsolu[deplacement][0])%8;
		position[1] = (position[1] + deplacementAbsolu[deplacement][1])%8;
		
		//attention, il faut encore signifier au monde que l'on a boug�: mise � jour des cases du monde
		this.leMonde.mouvementAnimal(anciennePosition, position);
		
		while (this.estomac<20){
			mange(position);
		}
	}

	public void mange(int[] position){
		//si il y a de la nourriture disponible, il mange
		if (this.leMonde.contenu(position[0],position[1])[0]!=0){
		this.leMonde.nourritureMangee(position);}
	}
	
	public int getEstomac(){
		return estomac;
	}
}

