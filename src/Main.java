
public class Main {

	
	
public static void main(String[] args){
	
	GlobalVars c = new GlobalVars();
	//création du monde
		/*MondeVirtuel theWorld = new MondeVirtuel(100,100);
		//création des animaux
		ThreadAnimal threadtest = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2,10, 1, theWorld, "titi");
		ThreadAnimal threadtest2 = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2, 10, 1, theWorld, "tit");
		//threadtest.saveAnimal("titi.txt");
		//ThreadAnimal test22 = new ThreadAnimal("titi.txt", theWorld);
		//System.out.println(threadtest.getAnimal().getName());
		threadtest.run();
		threadtest2.run();*/
		
		//création de nourriture
		/*int[] p1={2,2};
		new Nourriture(p1, theWorld);
		
		int[] p2={20,20};
		new Nourriture(p2, theWorld);*/
		
		System.out.println(c.AVANT );
		//FenetreResultat fen = new FenetreResultat();
		new FenetreCreationMonde(c);
		
		
}

}