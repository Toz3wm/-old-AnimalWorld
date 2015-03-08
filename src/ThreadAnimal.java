import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.Semaphore;


public class ThreadAnimal extends Thread {

	private GlobalVars c;
	private Animal animal;
	private MondeVirtuel leMonde;
	private Semaphore semtest;

	ThreadAnimal(double pbaAvanta,
			double pbaAvantGauchea, 
			double pbaAvantDroita, 
			double pbaArriereGauchea, 
			double pbaArriereDroita, 
			int estomaca, 
			int orientationa, 
			MondeVirtuel unMonde, 
			String namea,
			GlobalVars ca){
		animal  = new Animal( pbaAvanta,
				pbaAvantGauchea,
				pbaAvantDroita,
				pbaArriereGauchea,
				pbaArriereDroita,
				estomaca,
				orientationa,
				unMonde,
				namea,
				unMonde.getConstante());
		leMonde = unMonde;
		this.c = ca;
		this.leMonde.updateVectThreadAnimal(this);
	}

	ThreadAnimal(int estomaca, MondeVirtuel unMonde, String namea, GlobalVars ca){
		c = ca;
		animal = new Animal(estomaca, unMonde, namea, c);
		leMonde = unMonde;
		this.leMonde.updateVectThreadAnimal(this);

	}

	ThreadAnimal(String fileName, MondeVirtuel unMonde, GlobalVars ca){
		leMonde = unMonde;
		c = ca;
		animal = loadAnimal(fileName);
		this.leMonde.updateVectThreadAnimal(this);
	}

	//m�thode pour sauvegarder le profil d'un animal
	public void saveAnimal(String namefile){
		//on d�clare le flux sortant
		ObjectOutputStream output;
		try{
			//on l'initialise
			output = new ObjectOutputStream(
					//utilisation d'un tampon pour acc�l�rer les �critures en m�moire
					new BufferedOutputStream(
							new FileOutputStream(
									new File(namefile))));
			//on l'utilise pour stocker l'animal dans le fichier cr�� (ou indiqu�)
			output.writeObject(animal);
			//on oublie pas de fermer le flux
			output.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	//m�thode pour charger le profil d'un animal depuis la m�moire
	public Animal loadAnimal(String filename){
		//on d�lcare le flux entrant
		ObjectInputStream input;
		//on d�clare l'animal qui sera cr��
		Animal ani = null;
		try {
			//on initialise le flux
			input = new ObjectInputStream(
					//utilisation d'un tampon
					new BufferedInputStream(
							new FileInputStream(
									new File(filename))));
			try {//on cr�e l'instance de l'animal � partir du fichier
				ani = (Animal) input.readObject();
			} catch (ClassNotFoundException e)
			{e.printStackTrace();
			}
			//on ferme le flux
			input.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return ani;
	}

	public Animal getAnimal(){
		return animal;
	}

	public void run(){
		semtest = new Semaphore(1);
		//tant qu'il a de la nourriture en stock (�nergie encore), il peut se d�placer
		while (animal.getEstomac() > 0) {
			animal.bouger(leMonde, c);
			System.out.println(animal.getName()+" : Je suis en " + animal.getPosition()[0]+ ", " + animal.getPosition()[1] );
			int duree = (int) (Math.random()*1000);
			//dort pendant un tant al�atoire

			try {
				sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			/**/
			try {
				this.leMonde.getFenetreDuMonde().semtest.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				this.c.mutexUpdateScore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.leMonde.updateScore(this);
			this.c.mutexUpdateScore.release();

		}
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}