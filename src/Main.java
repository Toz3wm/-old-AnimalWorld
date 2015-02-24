
public class Main {

	
	
public static void main(String[] args){
	
	//création du monde
		MondeVirtuel theWorld = new MondeVirtuel(100,100);
		//création des animaux
		ThreadAnimal threadtest = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2, 10, 1, theWorld, "titi");
		ThreadAnimal threadtest2 = new ThreadAnimal(0.2, 0.2, 0.2, 0.2, 0.2, 10, 1, theWorld, "tit");
		threadtest.saveAnimal("titi.txt");
		ThreadAnimal test22 = new ThreadAnimal("titi.txt", theWorld);
		System.out.println(threadtest.getAnimal().getName());
		threadtest.run();
		threadtest2.run();
		
		//création de nourriture
		int[] p1={5,5};
		new Nourriture(p1);
		
		int [] p2 = new int[2];
		p2[0]=10;p2[1]=10;
		Nourriture n2 = new Nourriture(p2);
		
		int [] p3 = new int[2];
		p3[0]=20;p3[1]=20;
		Nourriture n3 = new Nourriture(p3);
		
		int [] p4 = new int[2];
		p4[0]=30;p4[1]=30;
		Nourriture n4 = new Nourriture(p4);
		
		int [] p5 = new int[2];
		p5[0]=50;p5[1]=50;
		Nourriture n5 = new Nourriture(p5);
		
		
		FenetreResultat fen = new FenetreResultat();
		System.out.println(Math.cos(90));
		System.out.println(Math.sin(90));
		System.out.println(Math.cos(3.14/2));
		
}

}