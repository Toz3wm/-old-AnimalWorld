import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;


public class FenetreResultat extends JFrame{
	
	 private PanneauResultat pan;
	 private MondeVirtuel mon;
	 private Vector<Animal> mesMeilleursAnimaux;

	public FenetreResultat(MondeVirtuel mona){
		    this.setTitle("Résultats de la simulation");
		    this.setSize(1000, 200);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setLocation(500,10);
		    this.pan = new PanneauResultat(this);
		    this.setContentPane(pan);
		    this.setVisible(true);    
		    this.mon = mona;
		  }
	
	public MondeVirtuel getMon() {
		return mon;
	}


	public PanneauResultat getPanneau(){
		return pan;
	}

	public void paintResult(Vector<Animal> meilleursAnimaux) {
		for(int i = 0; i < meilleursAnimaux.size(); i++){
			this.pan.paintAnimal(i, meilleursAnimaux.get(i));
			System.out.println(meilleursAnimaux);
			this.mesMeilleursAnimaux = meilleursAnimaux;
		}
		
	}

	public Vector<Animal> getMesMeilleursAnimaux() {
		return mesMeilleursAnimaux;
	}

	
}
