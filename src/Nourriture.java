import java.util.concurrent.Semaphore;


public class Nourriture {
	 
	private int[] position; 
	public MondeVirtuel leMonde;


	public Nourriture(int[] position) {
		super();
		this.position=position;
		this.leMonde.nourritureCree(position);
		//commmit fin des vacances
	}

}
