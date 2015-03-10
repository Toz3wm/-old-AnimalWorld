import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;


public class FenetreResultat extends JFrame{
	
	 private PanneauResultat pan;
	 private MondeVirtuel mon;

	public FenetreResultat(MondeVirtuel mona){
		    this.setTitle("Résultats de la simulation");
		    this.setSize(460, 340);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocation(500,10);
		    this.pan = new PanneauResultat();
		    this.setContentPane(pan);
		    this.setVisible(true);    
		    this.mon = mona;
		  }
	
	public PanneauResultat getPanneau(){
		return pan;
	}

	public void paintResult(Animal[] meilleursAnimaux) {
		for(int i = 0; i < 5; i++){
			this.pan.paintAnimal(i, meilleursAnimaux[i]);
			System.out.println(meilleursAnimaux);
		}
		
	}
	
}
