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

public class FenetreLecture extends JFrame implements ActionListener {

	private PanneauLecture pan; 
	MondeVirtuel theWorld;
	private boolean pauseAppuye;
	private boolean lectureAppuye;

	JButton buttonLecture;
	JButton buttonPause;
	JButton buttonStop;

	JLabel label1;
	JLabel label2;




	public FenetreLecture(MondeVirtuel unMonde){

		this.lectureAppuye = false;
		this.pauseAppuye = false;
		this.theWorld = unMonde;
		this.pan = new PanneauLecture(this);
		this.setTitle("Interface Controle de la simulation");
		this.setSize(300,100);
		//on place la fenetre en haut � gauche
		this.setLocation(10, 10); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*On pr�vient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composants */
		this.setContentPane(pan);
		this.setVisible(true);

		Container contentPane = this.getContentPane();
		//contentPane.setLayout(new GridLayout(3,3)); //disposition grille

		label1= new JLabel("Largeur du Monde");
		label2= new JLabel("Longueur du monde");

		buttonLecture = new JButton ("Lecture");
		buttonLecture.addActionListener(this);

		buttonPause = new JButton ("Pause");
		buttonPause.addActionListener(this);

		buttonStop = new JButton ("Stop");
		buttonStop.addActionListener(this);

		//on ajoute les diff�rents �l�ments au panneau, dans l'ordre

		pan.add(buttonLecture);
		pan.add(buttonPause);
		pan.add(buttonStop);
		pan.revalidate();

	}


	public void actionPerformed(ActionEvent f){  // on met en place les boutons


		//boutonLecture : reprend la simulation mise en pause
		//l'id�e est d'utiliser les s�maphores: on relache tout pour mettre lecture
		if (f.getSource().equals(buttonLecture)){ 	

			//si le bouton lecture n'a pas d�ja �t� enclench�
			if (this.lectureAppuye == false){

				System.out.println("lecture appuy�");
				//test si il y a des animaux
				if (this.theWorld.isLeMondeEstVide() == false){

					//on parcourt le vecteur animal
					for (int i=0;i<this.getTheWorld().getVecteurAnimaux().size();i++){

						//on met le mutex de l'animal � 1
						this.getTheWorld().getVecteurAnimaux().get(i).getMutexControl().release();
						System.out.println("animal"+i+"release mutex");

						// on prot�ge l'appuie cons�cutif au bouton lecture
						this.lectureAppuye = true;
						this.pauseAppuye = false;
					}
				}
			}
		}

		//boutonPause : suspend la simulation en marche
		//l'id�e est d'utiliser les s�maphores: on "acquire" tout
		if (f.getSource().equals(buttonPause)){ 	
			System.out.println("pause appuy�");
			System.out.println("BOOLEEN pause = "+this.pauseAppuye);

			//si le bouton pause n'a pas encore �t� enclench�

			if (this.pauseAppuye == false){
				//test si il y a des animaux
				if (this.theWorld.isLeMondeEstVide() == false){

					//on parcourt le vecteur des animaux
					for (int i=0;i<this.getTheWorld().getVecteurAnimaux().size();i++){

						//on met le mutex de l'animal � 0
						try {
							this.getTheWorld().getVecteurAnimaux().get(i).getMutexControl().acquire();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("animal"+i+"acquire mutex");

						//protection de l'appuie cons�cutif sur le bouton
						this.lectureAppuye = false;
						this.pauseAppuye = true;
						System.out.println("BOOLEEN pause = "+this.pauseAppuye);
					}
				}
			}
		}

		//boutonStop : on arrete completement la simulation, on revient � la fenetre de cr�ation du monde
		// pour lancer une nouvelle simulation

		if (f.getSource().equals(buttonStop)){
			this.theWorld.getFenetreMonde().dispose();
			this.theWorld.getFenetreResultat().dispose();
			this.theWorld.getLaFenetreBoutons().dispose();
			this.dispose();
			new FenetreCreationMonde(this.theWorld.getC());
		}
	}


	public MondeVirtuel getTheWorld() {
		return theWorld;
	}
}    


