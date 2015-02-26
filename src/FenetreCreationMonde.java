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

public class FenetreCreationMonde extends JFrame implements ActionListener {

	private PanneauCreationMonde pan; 
	private int largeur;
	private int longueur;
	MondeVirtuel theWorld;
	
	JButton button1;
   
    JLabel label1;
    JLabel label2;
   
    JTextField Tlargeur;
    JTextField Tlongueur;
    

	public FenetreCreationMonde(){
		
		this.pan = new PanneauCreationMonde(this);
		this.setTitle("Interface Création Monde");
		this.setSize(400,400);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On prévient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
		this.setContentPane(pan);
		this.setVisible(true);
		
		Container contentPane = this.getContentPane();
		//contentPane.setLayout(new GridLayout(3,3)); //disposition grille
	
		label1= new JLabel("Largeur du Monde");
		label2= new JLabel("Longueur du monde");
		
		
		Tlargeur= new JTextField("500");
		Tlongueur= new JTextField("500");
	    
		
		button1 = new JButton ("CREER");
		
		button1.addActionListener(this);
		
		//on ajoute les différents éléments au panneau, dans l'ordre
		pan.add(label1);pan.add(Tlargeur);
		pan.add(label2);pan.add(Tlongueur);
		
		pan.add(button1);
		
		
		
	}

	
public void actionPerformed(ActionEvent e){  // on met en place les boutons
			
	//on convertit le texte string en int
			longueur=Integer.parseInt(Tlongueur.getText());
			largeur = Integer.parseInt(Tlargeur.getText());
			
		
		//bouton1 : "créer", on crée le monde et on lance la fenetre de choix d'option de création de l'animal
		if (e.getSource().equals(button1)){ 	
			this.theWorld = new MondeVirtuel(largeur,longueur);
			new FenetreOptionCreationAnimal(this);
			
			
			pan.AfficheAnimalCree(getGraphics());
		}
		
		
	}


public MondeVirtuel getTheWorld() {
	return theWorld;
}


public void setTheWorld(MondeVirtuel theWorld) {
	this.theWorld = theWorld;
}
	
	
}    


