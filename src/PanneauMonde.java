import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.GradientPaint;
import java.awt.Graphics2D;



 
public class PanneauMonde extends JPanel { 
 
	// méthode que l'objet appelle pour se dessiner sur la fenetre
	public void paintComponent(Graphics g){
    //Vous verrez cette phrase chaque fois que la méthode sera invoquée
    System.out.println("Je suis exécutée !"); 
    
    /*Trace un rond plein en commençant à dessiner sur l'axe x 
     * à 20 pixels et sur l'axe y à 20 pixels, et fais en sorte qu'il
     *  occupe 75 pixels de large et 75 pixels de haut */
    //g.fillOval(20, 20, 75, 75);
    
    //rond centré
    int x1 = this.getWidth()/4;
    int y1 = this.getHeight()/4;                      
   
    //rond plein
    //g.fillOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    
    //rond vide
    g.drawOval(x1, y1, this.getWidth()/2, this.getHeight()/2);
    
    //rectangle vide et plein
   /* g.drawRect(10, 10, 50, 60);
    g.fillRect(65, 65, 30, 40);
    g.drawRoundRect(10, 10, 30, 50, 10, 10);
    g.fillRoundRect(55, 65, 55, 30, 5, 5);*/
    
    //lignes
    /*g.drawLine(0, 0, this.getWidth(), this.getHeight());
    g.drawLine(0, this.getHeight(), this.getWidth(), 0);*/
  
	//polygone
    int x[] = {20, 30, 50, 60, 60, 50, 30, 20};
    int y[] = {30, 20, 20, 30, 50, 60, 60, 50};
    g.drawPolygon(x, y, 8);

    int x2[] = {50, 60, 80, 90, 90, 80, 60, 50};
    int y2[] = {60, 50, 50, 60, 80, 90, 90, 80};
    g.fillPolygon(x2, y2, 8);
    
    //écrire
    Font font = new Font("Courier", Font.BOLD, 20);
    g.setFont(font);
    g.setColor(Color.RED); 
    g.drawString("coucou", 10, 20);
    
    //image  
    try {
        Image img = ImageIO.read(new File("pikachu.png"));
        g.drawImage(img, 0, 0, this);
        //Pour une image de fond
        //adaptation taille
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
      } catch (IOException e) {
        e.printStackTrace();
      }                
	}
}