
public class Main {

	
	
public static void main(String[] args){
	
	//cr�ation du monde
		MondeVirtuel theWorld = new MondeVirtuel(1000,1000);
		//cr�ation des animaux
		ThreadAnimal threadtest = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2, 10, 1, theWorld, "titi");
		//threadtest.saveAnimal("titi.txt");
		//ThreadAnimal test22 = new ThreadAnimal("titi.txt", theWorld);
		//System.out.println(threadtest.getAnimal().getName());
		//threadtest.run();
		
		FenetreResultat fen = new FenetreResultat();
		
}

}