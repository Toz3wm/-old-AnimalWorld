
public class Main {

	//cr�ation du monde
	MondeVirtuel theWorld = new MondeVirtuel(10,10);
	//cr�ation des animaux
	ThreadAnimal threadtest = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2, 10, 1, theWorld, "titi");
	
	
}
