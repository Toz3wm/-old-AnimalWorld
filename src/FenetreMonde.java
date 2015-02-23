
import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class FenetreMonde extends JFrame {
  public FenetreMonde(){             
    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 100);
    this.setLocationRelativeTo(null); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    //Instanciation d'un objet JPanel
   // JPanel pan = new JPanel();
    //Définition de sa couleur de fond
   // pan.setBackground(Color.blue);        
    
    /*On prévient notre JFrame que notre JPanel
    sera son content pane  c'est dans celui-ci que nous placerons nos composant */
    this.setContentPane(new PanneauMonde());               
    this.setVisible(true);
  }       
}