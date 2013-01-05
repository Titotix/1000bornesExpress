package vue;
import java.util.*;

import tasDeCartes.Defausse;
import tasDeCartes.Talon;

import jeu.Menu;

import joueurs.Joueur;
import joueurs.Robot;

public class CmdLineInterface extends Thread implements Observer {

	private Talon talon;
	private Menu menu;
	private Defausse defausse;
	
	public CmdLineInterface() {
		this.talon = Talon.getInstance();
		this.defausse = Defausse.getInstance();
		this.menu = Menu.getInstance();
	}
	public void run() { //TODO
		this.contextuel();
	
	}
	
	public void update(Observable o, Object arg) {
	}
		
		
	public void afficherJoueur(Joueur joueur) {
		this.afficherMainJoueur(joueur);
		this.afficherJeuSurTableJoueur(joueur);
		System.out.println("Bornes parcouru : "+ joueur.getJeuSurTable().getNbKmParcouruTotal() );
		System.out.println("strat :"+((Robot) joueur).getStrat().toString());
	
	}
	
	
	

	public void contextuel() {
		Menu menu = Menu.getInstance();
		//int choix;
		//System.out.println("Entrer le numero correspondant a ce que vous souhaitez");
		//System.out.println("\n 1. Nouvelle partie");
		//Scanner a = new Scanner(System.in);
		//choix = a.nextInt();
		//switch(choix) {
		/*case 1:*/ menu.nouvellePartie();
		//break;
	}
	
	
	public void choixVariante() {
		
	}
	
	public void afficherMainJoueur(Joueur joueur) {
		System.out.println(joueur.getJeuEnMain().toString());
	}
	
	public void afficherJeuSurTableJoueur(Joueur joueur) {
		System.out.println(joueur.getJeuSurTable().toString());
	}
	
	public void afficherJeuDesHumains () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbHumain(); i++) {			
			System.out.println(menu.getHumain().get(i).getJeuEnMain().toString());
		}
	}

	public void afficherJeuDesRobots () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbRobot(); i++) {
			
			System.out.println(menu.getRobot().get(i).getJeuEnMain().toString());
		}
	}
	
	public void afficherTalon() {
		Talon talon = Talon.getInstance();
		System.out.println(talon.getPileCarte().toString());
	}
	

	public void afficherDefausse() {
		Defausse defausse = Defausse.getInstance();
		System.out.println(defausse.getPileCarte().toString());
	}
	
	public String CarteVisibleDefausse() {
		Defausse defausse = Defausse.getInstance();
		return defausse.getPileCarte().getFirst().toString();
	}
}
