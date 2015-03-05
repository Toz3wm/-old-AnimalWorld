

//classe comportant toutes les GlobalVarss


public class GlobalVars {

public final int QTE_NOURRITURE = 0;
//GlobalVarss relatives à la fenêtre de création du monde (première fenêtre)	
public final int longueurFenetreCreationMonde = 200;
public final int largeurFenetreCreationMonde = 200;
public final String titreCreationMonde = "Création de l'univers de la simulation";

//fenêtre du monde
public final String titreMonde = "Représentation du monde torique";


//animal 
public final int NORD = 0;
public final int NORDEST = 1;
public final int EST = 2;
public final int SUDEST = 3;
public final int SUD = 4;
public final int SUDOUEST = 5;
public final int OUEST = 6;
public final int NORDOUEST = 7;

public final int AVANT = 0;
public final int AVANTDROIT = 1;
public final int ARRIEREDROIT = 3;
public final int ARRIEREGAUCHE = 5;
public final int AVANTGAUCHE = 7;

public final int NB_DIRECTIONS = 8;
public final int NB_COORDONNEES = 2;

public final int X = 0;
public final int Y = 1;

public final int[][] deplacementAbsolu;


GlobalVars() {
	this.deplacementAbsolu = new int[8][2];
	//déplacement absolu pour les abscisses x
	this.deplacementAbsolu[0][0] = -1 ;
	this.deplacementAbsolu[1][0] = -1 ;
	this.deplacementAbsolu[2][0] = 0 ;
	this.deplacementAbsolu[3][0] = 1 ;
	this.deplacementAbsolu[4][0] = 1 ;
	this.deplacementAbsolu[5][0] = 1 ;
	this.deplacementAbsolu[6][0] = 0 ;
	this.deplacementAbsolu[7][0] = -1 ;
	// déplacement absolu pour les ordonnées y
	this.deplacementAbsolu[0][1] = 0 ;
	this.deplacementAbsolu[1][1] = 1 ;
	this.deplacementAbsolu[2][1] = 1 ;
	this.deplacementAbsolu[3][1] = 1 ;
	this.deplacementAbsolu[4][1] = 0 ;
	this.deplacementAbsolu[5][1] = -1 ;
	this.deplacementAbsolu[6][1] = -1 ;
	this.deplacementAbsolu[7][1] = -1 ;

}

}
