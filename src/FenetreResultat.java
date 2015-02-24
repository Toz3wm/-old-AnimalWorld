import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


public class FenetreResultat extends JFrame{
	
	 private PanneauResultat pan;

	public FenetreResultat(){
		    this.setTitle("Résultats de la simulation");
		    this.setSize(460, 340);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocationRelativeTo(null);
		    this.pan = new PanneauResultat();
		    this.setContentPane(pan);
		    this.setVisible(true);    
		  }
	
}
