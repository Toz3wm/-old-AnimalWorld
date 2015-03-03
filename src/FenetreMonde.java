
import java.awt.Color; 
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreMonde extends JFrame {
	private constante c;
	private PanneauMonde MonPan; 
	MondeVirtuel MonMondeVirtuel;

	public FenetreMonde(MondeVirtuel unMonde, constante c){
		this.c = c;
		this.MonMondeVirtuel = unMonde;
		this.MonPan = new PanneauMonde(this, unMonde);
		this.setTitle(c.titreMonde);
		this.setSize(this.MonMondeVirtuel.getLargeur(), this.MonMondeVirtuel.getLongueur());
		this.setLocationRelativeTo(null); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On prévient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
		this.setContentPane(MonPan);
		this.setVisible(true);

		//on lance le mouvement
		this.go();

	}


	public MondeVirtuel getMonMondeVirtuel() {
		return MonMondeVirtuel;
	}       

	public void go(){ 

		//On redessine notre Panneau
		MonPan.repaint();
		System.out.println("go");

	}
}    


