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

public class FenetreBoutons extends JFrame implements ActionListener {

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
    
    JTextField TpbaAvant;
    JTextField TpbaAvantGauche;
    JTextField TpbaAvantDroit;
    JTextField TpbaArriereGauche;
    JTextField TpbaArriereDroit;
    JTextField estomacInitial;
    JTextField nomAnimal;
    JTextField Torientation;

	public FenetreBoutons(MondeVirtuel unMonde){
		this.MonMondeVirtuel = unMonde;
		this.pan = new PanneauBouton(this, unMonde);
		this.setTitle("Interface boutons");
		this.setSize(100,100);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On prévient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
		this.setContentPane(pan);
		this.setVisible(true);
		
		Container contentPane = this.getContentPane();
		//contentPane.setLayout(new GridLayout(3,3)); //disposition grille
	
		label1= new JLabel("Pba avant %");
		label2= new JLabel("Pba avant gauche %");
		label3= new JLabel("Pba avant droit %");
		label4= new JLabel("Pba arrière gauche %");
		label5= new JLabel("Pba arrière droite %");
		label6= new JLabel("Quantité de nourriture initiale dans l'estomac");
		label7= new JLabel("Nom de l'animal");
		label8= new JLabel("Orientation de l'animal initiale");
		
		TpbaAvant= new JTextField("20");
		TpbaAvantGauche= new JTextField("20");
	    TpbaAvantDroit= new JTextField("20");
	    TpbaArriereGauche= new JTextField("20");
	    TpbaArriereDroit= new JTextField("20");
	    estomacInitial = new JTextField("10");
	    nomAnimal =new JTextField("TOTO");
	    Torientation =new JTextField("1");
		
		button1 = new JButton ("OK");
		
		button1.addActionListener(this);
		
		//on ajoute les différents éléments au panneau, dans l'ordre
		pan.add(label1);pan.add(TpbaAvant);
		pan.add(label2);pan.add(TpbaAvantGauche);
		pan.add(label3);pan.add(TpbaAvantDroit);
		pan.add(label4);pan.add(TpbaArriereGauche);
		pan.add(label5);pan.add(TpbaArriereDroit);
		pan.add(label6);pan.add(estomacInitial);
		pan.add(label7);pan.add(nomAnimal);
		pan.add(label8);pan.add(Torientation);
		
		pan.add(button1);
		
		
		
	}

	public MondeVirtuel getMonMondeVirtuel() {
		return MonMondeVirtuel;
	}

	
public void actionPerformed(ActionEvent e){  // on met en place les boutons
			
	//on convertit le texte string en int, on divise par 100 pour obtenir la pba <1
			pbaAvant=Integer.parseInt(TpbaAvant.getText())/100;
			pbaAvantGauche = Integer.parseInt(TpbaAvantGauche.getText())/100;
			pbaAvantDroit = Integer.parseInt(TpbaAvantDroit.getText())/100;
			pbaArriereGauche = Integer.parseInt(TpbaArriereGauche.getText())/100;
			pbaArriereDroit = Integer.parseInt(TpbaArriereDroit.getText())/100;
			estomac = Integer.parseInt(estomacInitial.getText());
			orientation =Integer.parseInt(Torientation.getText());
			name = (nomAnimal.getText());
		
		//bouton1 : "ok" on créé l'animal
		if (e.getSource().equals(button1)){ 	
			ThreadAnimal threadtest = new ThreadAnimal(pbaAvant,pbaAvantGauche,pbaAvantDroit,pbaArriereGauche,pbaArriereDroit,estomac,orientation, this.getMonMondeVirtuel(), name);
			threadtest.saveAnimal("titi.txt");
			System.out.println(threadtest.getAnimal().getName());
			threadtest.run();
			
			
			pan.AfficheAnimalCree(getGraphics());
		}
		
		
	}
	
	
}    


