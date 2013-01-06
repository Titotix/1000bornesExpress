
import jeu.Menu;
import jeu.PartieDeJeu;
import tasDeCartes.Talon;
import vue.CmdLineInterface;
import vue.Controleur;
import vue.FenetrePrincipale;
import vue.MenuGraphique;


public class main {

	public static void main(String[] args) {
		
	Menu menu = Menu.getInstance();
	MenuGraphique menuGui = new MenuGraphique();
	menu.nouvellePartie();
	PartieDeJeu partie = PartieDeJeu.getInstance();
	Controleur controleur = new Controleur();
	FenetrePrincipale fenetre = new FenetrePrincipale(controleur);
	
	
	
	
	Talon talon = Talon.getInstance();
	
	partie.jouerPartie();
	
	}
}