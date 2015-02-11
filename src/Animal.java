
public class Animal extends Thread {

	
	//l'int orientation désigne l'orientation de l'animal dans l'espace
	//0 désigne le nord, 1 le nord-est, 2 l'est... jusqu'à 7 le nord-ouest
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
	private int estomac; //
	private MondeVirtuel leMonde;
	
	public Animal(double pbaAvanta,
			double pbaAvantGauchea, double pbaAvantDroita, double pbaArriereGauchea, double pbaArriereDroita, int estomaca, int orientationa, MondeVirtuel unMonde ) {
		super();
		this.leMonde = unMonde;
		//l'animal apparait sur une case aléatoire
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
		//l'animal apparait sur une case aléatoire
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
		
		this.orientation = (int) (8*Math.random());
		this.pbaAvant = Math.random();
		this.pbaAvantGauche = (1 - pbaAvant) * Math.random();
		this.pbaAvantDroit = (1 - pbaAvant - pbaAvantGauche) *  Math.random();
		this.pbaArriereGauche = (1 - pbaAvant - pbaAvantGauche - pbaArriereGauche) * Math.random();
		this.pbaArriereDroit = (1 - pbaAvant - pbaAvantGauche - pbaArriereGauche - pbaArriereDroit) * Math.random();
		this.estomac = estomaca;
	}
	
	public void bouger(){
		double choix = Math.random();
		int deplacement;
		if (choix <= pbaAvant) {
			deplacement = 0;
		} else if (choix <=(pbaAvant + pbaAvantDroit)){
			deplacement = 1;
		} else if (choix <= (pbaAvant + pbaAvantDroit + pbaArriereDroit)) {
			deplacement = 3;
		} else if (choix <= (pbaAvant + pbaAvantDroit + pbaArriereDroit + pbaArriereGauche)) {
			deplacement = 5;
		} else {
			deplacement = 5;			
		}
		deplacement  = (deplacement + orientation)%8;
		orientation = deplacement; 
		position[0] = position[0] + deplacementAbsolu[deplacement][0];
		position[1] = position[1] + deplacementAbsolu[deplacement][1];
		//attention, il faut encore signifier au monde que l'on a bougé
		this.leMonde.mouvementAnimal(anciennePosition, position);
	}
	
	public void run(){
		//phase de détermination
		while (estomac > 0) {
			bouger();
			int duree = (int) (Math.random()*1000);
			try {
				sleep(duree);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}

