package vue;
import java.util.*;

import controleur.*;
import modele.*;

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
		this.choixVariante();
	}
	
	public void update(Observable o, Object arg) {
	}
		
		
	
	public void contextuel() {
		Menu menu = Menu.getInstance();
		int choix;
		System.out.println("Entrer le numero correspondant a ce que vous souhaitez");
		System.out.println("\n 1. Nouvelle partie");
		Scanner a = new Scanner(System.in);
		choix = a.nextInt();
		switch(choix) {
		case 1: menu.nouvellePartie();
		break;
		}
	}
	
	public void choixVariante() {
		Scanner clavier = new Scanner(System.in);
		System.out.println("Souhaitez vous jouer avec la variante (Kilometre à parcourir egal a 700 au lieu de 1000");
		System.out.println("Veuillez entrer true/false");
		
		if(clavier.nextBoolean()) {
			menu.setVariante();
		}
	}
	
	public void afficherMainJoueur(Joueur joueur) {
		System.out.println(joueur.getJeuEnMain().toString());
	}
	
	public void afficherJeuDesHumains () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbHumain(); i++) {			
			System.out.println(menu.getHumain()[i].getJeuEnMain().toString());
			}
	}

	public void afficherJeuDesRobots () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbRobot(); i++) {
			
			System.out.println(menu.getRobot()[i].getJeuEnMain().toString());
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
