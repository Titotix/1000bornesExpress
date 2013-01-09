

import javax.swing.JOptionPane;

import jeu.Menu;
import jeu.PartieDeJeu;
import vue.Controleur;
import vue.FenetrePrincipale;
import vue.MenuGraphique;

/**
 * Main pour l'execution du programme
 * @author Damien
 *
 */
public class main {

	public static void main(String[] args) {
		
		
		new MenuGraphique();
		PartieDeJeu partie = PartieDeJeu.getInstance();
		
		Menu menu = Menu.getInstance();
		Thread t = new Thread(menu, "menu");
		t.start();
		
		partie.jouerPartie(); 
	
	}
}