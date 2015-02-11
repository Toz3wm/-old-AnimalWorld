
public class Animal {

	private int positionX;
	private int positionY;
	//5 caractères à définir
	private int pbaAvant;
	private int pbaAvantGauche;
	private int pbaAvantDroit;
	private int pbaArriereGauche;
	private int pbaArriereDroit;
	//estomac
	private int estomac; //compte la nourriture, si 0, l'animal s'arrête de bouger
	private MondeVirtuel leMonde;
	
	public Animal(int pbaAvant,
			int pbaAvantGauche, int pbaAvantDroit, int pbaArriereGauche,
			int pbaArriereDroit, int estomac, MondeVirtuel unMonde ) {
		super();
		this.leMonde = unMonde;
		//l'animal apparait sur une case aléatoire
		this.positionX = (int)(Math.random()*leMonde.getLargeur());
		this.positionY = (int)(Math.random()*leMonde.getLongueur());
		this.pbaAvant = pbaAvant;
		this.pbaAvantGauche = pbaAvantGauche;
		this.pbaAvantDroit = pbaAvantDroit;
		this.pbaArriereGauche = pbaArriereGauche;
		this.pbaArriereDroit = pbaArriereDroit;
		this.estomac = estomac;
	}

}

