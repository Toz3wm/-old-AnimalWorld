import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;

public class FenetreBoutons extends JFrame implements ActionListener {

	private Color maCouleur;
	private PanneauBouton pan; 
	MondeVirtuel MonMondeVirtuel;
	private double pbaAvant;
	private double pbaAvantGauche;
	private double pbaAvantDroit;
	private double pbaArriereGauche;
	private double pbaArriereDroit;
	private int estomac;
	private String name;
	private int orientation;
	private int quantite;
	
	private int estomacbis;
	private String namebis;
	private int orientationbis;
	private int quantitebis;
	
	private String fileName;
	
	JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    
    JLabel label6bis;
    JLabel label7bis;
    JLabel label8bis;
    JLabel label9bis;
    
    JLabel label10;
    
    JTextField TpbaAvant;
    JTextField TpbaAvantGauche;
    JTextField TpbaAvantDroit;
    JTextField TpbaArriereGauche;
    JTextField TpbaArriereDroit;
    JTextField estomacInitial;
    JTextField nomAnimal;
    JTextField Torientation;
    JTextField Tquantit�;
    
    JTextField estomacInitialbis;
    JTextField nomAnimalbis;
    JTextField Torientationbis;
    JTextField Tquantit�bis;
    
    JTextField TfileName;

	public FenetreBoutons(MondeVirtuel unMonde){
		this.MonMondeVirtuel = unMonde;
		this.pan = new PanneauBouton(this, unMonde);
		this.setTitle("Interface boutons");
		this.setSize(300,400);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On pr�vient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
		this.setContentPane(pan);
		this.setVisible(true);
		
		Container contentPane = this.getContentPane();
		//contentPane.setLayout(new GridLayout(3,3)); //disposition grille
	
		//pour le premier constructeur personnalis�
		label1= new JLabel("Pba avant %");
		label2= new JLabel("Pba avant gauche %");
		label3= new JLabel("Pba avant droit %");
		label4= new JLabel("Pba arri�re gauche %");
		label5= new JLabel("Pba arri�re droite %");
		label6= new JLabel("Quantit� de nourriture initiale dans l'estomac");
		label7= new JLabel("Nom de l'animal");
		label8= new JLabel("Orientation de l'animal initiale");
		label9= new JLabel("Quantit� � cr�er");
		
		TpbaAvant= new JTextField("20");
		TpbaAvantGauche= new JTextField("20");
	    TpbaAvantDroit= new JTextField("20");
	    TpbaArriereGauche= new JTextField("20");
	    TpbaArriereDroit= new JTextField("20");
	    estomacInitial = new JTextField("10");
	    nomAnimal =new JTextField("TOTO");
	    Torientation =new JTextField("1");
	    Tquantit� =new JTextField("10");
	    button1 = new JButton ("OK");
	    
		//pour le 2e constructeur al�atoire
		label6bis= new JLabel("Quantit� de nourriture initiale dans l'estomac");
		label7bis= new JLabel("Nom de l'animal");
		label8bis= new JLabel("Orientation de l'animal initiale");
		label9bis= new JLabel("Quantit� � cr�er");
		
		estomacInitialbis = new JTextField("10");
	    nomAnimalbis =new JTextField("TOTO");
	    Torientationbis =new JTextField("1");
	    Tquantit�bis =new JTextField("10");
	    
	    button2 = new JButton ("OK");
	    
	    //3e constructeur load
		label10= new JLabel("Nom du fichier � charger");
	    TfileName =new JTextField("fichier");
	  
		button3 = new JButton ("charger un profil");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		
		//on ajoute les diff�rents �l�ments au panneau, dans l'ordre
		//1er constructeur
		pan.add(label1);pan.add(TpbaAvant);
		pan.add(label2);pan.add(TpbaAvantGauche);
		pan.add(label3);pan.add(TpbaAvantDroit);
		pan.add(label4);pan.add(TpbaArriereGauche);
		pan.add(label5);pan.add(TpbaArriereDroit);
		pan.add(label6);pan.add(estomacInitial);
		pan.add(label7);pan.add(nomAnimal);
		pan.add(label8);pan.add(Torientation);
		pan.add(label9);pan.add(Tquantit�);
		
		pan.add(button1);
		
		//2e constructeur
		pan.add(label6bis);pan.add(estomacInitialbis);
		pan.add(label7bis);pan.add(nomAnimalbis);
		pan.add(label8bis);pan.add(Torientationbis);
		pan.add(label9bis);pan.add(Tquantit�bis);
		
		pan.add(button2);
		
		//3e constructeur
		pan.add(label10);pan.add(TfileName);
		pan.add(button3);
		
	}

	public MondeVirtuel getMonMondeVirtuel() {
		return MonMondeVirtuel;
	}

	
public void actionPerformed(ActionEvent e){  
	// on met en place les boutons
	
	//1er constructeur
	//on r�cup�re les donn�es entr�es		
	//on convertit le texte string en float, on divise par 100 pour obtenir la pba <1
			pbaAvant= Float.parseFloat(TpbaAvant.getText())/100;
			pbaAvantGauche = Float.parseFloat(TpbaAvantGauche.getText())/100;
			pbaAvantDroit = Float.parseFloat(TpbaAvantDroit.getText())/100;
			pbaArriereGauche = Float.parseFloat(TpbaArriereGauche.getText())/100;
			pbaArriereDroit = Float.parseFloat(TpbaArriereDroit.getText())/100;
			estomac = Integer.parseInt(estomacInitial.getText());
			orientation =Integer.parseInt(Torientation.getText());
			name = (nomAnimal.getText());
			quantite = Integer.parseInt(Tquantit�.getText());
		
		//bouton1 : "ok" on cr�� l'animal personnalis�
		if (e.getSource().equals(button1)){ 
			MonMondeVirtuel.getFenetreDuMonde().go();
			
			//on attribue une couleur al�atoire
			Random rand = new Random();
		    // Java 'Color' class takes 3 floats, from 0 to 1.
		    float r = rand.nextFloat();
		    float g = rand.nextFloat();
		    float b = rand.nextFloat();
			maCouleur= new Color(r, g, b);
			
			//on cr�e quantit� - 1	 fois l'animal
			for (int i=0;i<quantite-1;i++){
			ThreadAnimal threadtest = new ThreadAnimal(pbaAvant,
					pbaAvantGauche,
					pbaAvantDroit,
					pbaArriereGauche,
					pbaArriereDroit,
					estomac,
					orientation, 
					this.getMonMondeVirtuel(), 
					name);
			
			//on attribue � l'animal cr�� la couleur courante
			threadtest.getAnimal().setMaCouleur(maCouleur);
			
			MonMondeVirtuel.getFenetreDuMonde().go();
			threadtest.saveAnimal("titi.txt");
			System.out.println(threadtest.getAnimal().getName());
			threadtest.run();
			MonMondeVirtuel.getFenetreDuMonde().go();}
			
			
			//on cr�e une derni�re fois l'animal et on ne sauvegarde qu'une fois
			ThreadAnimal threadtest = new ThreadAnimal(pbaAvant,
					pbaAvantGauche,
					pbaAvantDroit,
					pbaArriereGauche,
					pbaArriereDroit,
					estomac,
					orientation, 
					this.getMonMondeVirtuel(), 
					name);
			//on attribue � l'animal cr�� la couleur courante
			threadtest.getAnimal().setMaCouleur(maCouleur);
			
			MonMondeVirtuel.getFenetreDuMonde().go();
			System.out.println(threadtest.getAnimal().getName());
			threadtest.run();
			MonMondeVirtuel.getFenetreDuMonde().go();
			
			pan.AfficheAnimalCree(getGraphics());
		}
		
		//2e constructeur
		//on r�cup�re les donn�es entr�es		
		//on convertit le texte string en float, on divise par 100 pour obtenir la pba <1
				
				estomacbis = Integer.parseInt(estomacInitialbis.getText());
				orientationbis =Integer.parseInt(Torientationbis.getText());
				namebis = (nomAnimalbis.getText());
				quantitebis = Integer.parseInt(Tquantit�bis.getText());
		
		//bouton2 : "ok" on cr�� l'animal al�atoire
				if (e.getSource().equals(button2)){ 
					
					//on attribue une couleur al�atoire
					Random rand = new Random();
				    // Java 'Color' class takes 3 floats, from 0 to 1.
				    float r = rand.nextFloat();
				    float g = rand.nextFloat();
				    float b = rand.nextFloat();
					maCouleur= new Color(r, g, b);
					
					//on cr�e quantit� - 1	 fois l'animal
					for (int i=0;i<quantite-1;i++){
					ThreadAnimal threadtest = new ThreadAnimal(
							estomac,
							this.getMonMondeVirtuel(), 
							name);
					//on attribue � l'animal cr�� la couleur courante
					threadtest.getAnimal().setMaCouleur(maCouleur);
					
					MonMondeVirtuel.getFenetreDuMonde().go();
					System.out.println(threadtest.getAnimal().getName());
					threadtest.run();
					MonMondeVirtuel.getFenetreDuMonde().go();
					}
					
					//on cr�e une derni�re fois l'animal et on ne sauvegarde qu'une fois
					ThreadAnimal threadtest = new ThreadAnimal(
							estomac,
							this.getMonMondeVirtuel(), 
							name);
					//on attribue � l'animal cr�� la couleur courante
					threadtest.getAnimal().setMaCouleur(maCouleur);
					
					MonMondeVirtuel.getFenetreDuMonde().go();
					threadtest.saveAnimal("titi.txt");
					System.out.println(threadtest.getAnimal().getName());
					threadtest.run();
					MonMondeVirtuel.getFenetreDuMonde().go();
					}
					
		//bouton3: charger un profil
				if (e.getSource().equals(button3)){ 
					
					//on attribue une couleur al�atoire
					Random rand = new Random();
				    // Java 'Color' class takes 3 floats, from 0 to 1.
				    float r = rand.nextFloat();
				    float g = rand.nextFloat();
				    float b = rand.nextFloat();
					maCouleur= new Color(r, g, b);
					
					ThreadAnimal threadtest = new ThreadAnimal(fileName, this.getMonMondeVirtuel());
					//on attribue � l'animal cr�� la couleur courante
					threadtest.getAnimal().setMaCouleur(maCouleur);
					}
				
				
	}

public void setMonMondeVirtuel(MondeVirtuel monMondeVirtuel) {
	MonMondeVirtuel = monMondeVirtuel;
}

public Color getMaCouleur() {
	return maCouleur;
}

public void setMaCouleur(Color maCouleur) {
	this.maCouleur = maCouleur;
}
	
	
}    


