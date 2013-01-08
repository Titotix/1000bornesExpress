

import jeu.Menu;
import jeu.PartieDeJeu;
import vue.Controleur;
import vue.FenetrePrincipale;
import vue.MenuGraphique;


public class main {

	public static void main(String[] args) {
	
		
		new MenuGraphique();
		Menu menu = Menu.getInstance();
		//Thread t = new Thread(menu);
		//t.start();
		menu.run();
		PartieDeJeu partie = PartieDeJeu.getInstance();
		partie.jouerPartie();
	
	}
}