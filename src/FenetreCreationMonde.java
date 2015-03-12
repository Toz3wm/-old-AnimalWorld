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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.Popup;

public class FenetreCreationMonde extends JFrame implements ActionListener {

	private PanneauCreationMonde pan; 
	private int largeur;
	private int longueur;
	MondeVirtuel theWorld;
	GlobalVars c;
	JButton button1;

	JLabel label1;
	JLabel label2;

	JTextField Tlargeur;
	JTextField Tlongueur;


	public FenetreCreationMonde(GlobalVars c){

		this.c = c;
		this.pan = new PanneauCreationMonde(this);
		this.setTitle("Interface Création Monde");
		this.setSize(c.largeurFenetreCreationMonde,c.longueurFenetreCreationMonde);
		this.setTitle(c.titreCreationMonde);
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On prévient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composants */
		this.setContentPane(pan);
		this.setVisible(true);

		Container contentPane = this.getContentPane();
		//contentPane.setLayout(new GridLayout(3,3)); //disposition grille

		label1= new JLabel("Largeur du Monde");
		label2= new JLabel("Longueur du monde");


		Tlargeur= new JTextField("100");
		Tlongueur= new JTextField("100");


		button1 = new JButton ("CREER");

		button1.addActionListener(this);

		//on ajoute les différents éléments au panneau, dans l'ordre
		pan.add(label1);pan.add(Tlargeur);
		pan.add(label2);pan.add(Tlongueur);

		pan.add(button1);

		pan.revalidate();

	}


	public void actionPerformed(ActionEvent f){  // on met en place les boutons

		/*bouton1 : "créer", on crée le monde, 
		on lance la fenetre de choix d'option de création de l'animal
		et on lance la fenetreLecture
		 */
		if (f.getSource().equals(button1)){ 
			
		//on convertit le texte string en int	
			//on teste si le contenu est un entier
		    try {
		    	//on teste la longueur et la largeur
		    	
		        int unEntier = Integer.valueOf(Tlongueur.getText());
		        
		        int unAutreEntier = Integer.valueOf(Tlargeur.getText());
		        
		        longueur=Integer.parseInt(Tlongueur.getText());
		        
		        largeur = Integer.parseInt(Tlargeur.getText());
			
			this.theWorld = new MondeVirtuel(largeur,longueur,c);
			FenetreBoutons FB = new FenetreBoutons(this.theWorld, c);
			this.theWorld.setLaFenetreBoutons(FB);
			FenetreLecture uneFenetreLecture = new FenetreLecture(this.theWorld);
			this.theWorld.setMaFenetreLecture(uneFenetreLecture);
			this.dispose();
			
		    } catch (NumberFormatException nfe) {
		       
		    	System.out.println("Une des valeurs n'est pas entière" );
		        JOptionPane.showMessageDialog(this,
		        	    "Une des valeurs n'est pas entière",
		        	    "warning",
		        	    JOptionPane.WARNING_MESSAGE);
		    }
			
			
		}


	}


	public MondeVirtuel getTheWorld() {
		return theWorld;
	}


	public void setTheWorld(MondeVirtuel theWorld) {
		this.theWorld = theWorld;
	}


}    


