import java.util.concurrent.Semaphore;


public class Nourriture {
	 
	private int[] position; 
	public MondeVirtuel leMonde;


	public Nourriture(int[] position, MondeVirtuel unMonde) {
		super();
		this.leMonde = unMonde;
		this.position=position;
		this.leMonde.nourritureCree(position);
		this.leMonde.nbNourriture(1);
		//commmit fin des vacances
	}

	
	public int[] getPosition(){
		return position;
	}
}
