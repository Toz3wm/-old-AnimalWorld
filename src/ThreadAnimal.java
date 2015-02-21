
public class ThreadAnimal extends Thread {

	Animal animal;
	
	ThreadAnimal(double pbaAvanta,
			double pbaAvantGauchea, double pbaAvantDroita, double pbaArriereGauchea, double pbaArriereDroita, int estomaca, int orientationa, MondeVirtuel unMonde ){
		animal  = new Animal( pbaAvanta,  pbaAvantGauchea,  pbaAvantDroita,  pbaArriereGauchea,  pbaArriereDroita,  estomaca,  orientationa,  unMonde );
		
	}
	
	ThreadAnimal(int estomaca, MondeVirtuel unMonde){
		animal = new Animal(estomaca, unMonde);
	}
	
	public void run(){
		
		//tant qu'il a de la nourriture en stock (�nergie encore), il peut se d�placer
		while (animal.getEstomac() > 0) {
			animal.bouger();
			int duree = (int) (Math.random()*1000);
			//dort pendant un tant al�atoire
			try {
				sleep(duree);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
}
