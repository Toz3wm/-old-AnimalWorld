
import java.awt.Color; 
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreMonde extends JFrame {
	
	private PanneauMonde MonPan; 
	MondeVirtuel MonMondeVirtuel;
	 
  public FenetreMonde(){      
	this.MonPan = new PanneauMonde();
    this.setTitle("Repr�sentation du monde torique");
    this.setSize(400, 100);
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    /*On pr�vient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
	this.setContentPane(MonPan);
	this.setVisible(true);
	
  }
  
//m�thode qui associe � l'animal un "panneau" qui "dessinera" sur la fen�tre son d�placement
public void MiseAJourFenetre() {
	this.MonPan.MiseAJourPanneau();
}


public MondeVirtuel getMonMondeVirtuel() {
	return MonMondeVirtuel;
}       

}