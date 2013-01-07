
import jeu.Menu;
import jeu.PartieDeJeu;
import vue.Controleur;
import vue.FenetrePrincipale;
import vue.MenuGraphique;


public class main {

	public static void main(String[] args) {
		
	new MenuGraphique();
	Menu.getInstance().nouvellePartie();
	Controleur controleur = new Controleur();
	new FenetrePrincipale(controleur);
		
	PartieDeJeu.getInstance().jouerPartie();
	
	}
}