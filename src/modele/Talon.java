package modele;

import java.util.*;
import controleur.*;

public class Talon extends Observable {
	
	private final int nombreCarteInitial = 66;
	private int nombreCarteADistribuer;
	private int nombreCarteActuel;
	private LinkedList<Carte> pileCarte; 
	private static Talon talon = null;
	
	//constructeur
	public Talon () {
		pileCarte = new LinkedList<Carte>();
	}
	

	//singleton
	
	public static Talon getInstance() {
		if(talon == null) {
			talon = new Talon();
		}
		return talon;
	}
	
	
	
	/**
	 * Calcul du nombre de cartes a distribuer
	 * @param menu
	 * @return nombre de carte a distribuer au total
	 */
	public int nbCarteADistribuer(){
		Menu menu = Menu.getInstance();
		return menu.getNbJoueurTotal() * 4; 
	}
	
	//Trier les cartes al�atoirement
	public void aleatoirePileCarte(){
		long seed =System.nanoTime();
		Collections.shuffle(pileCarte, new Random(seed));
		
	}
	
	//Distribuer les cartes depuis le talon
	public void distribuer() {
		Menu menu = Menu.getInstance();
		Humain[] humain = menu.getHumain();
		Robot[] robot = menu.getRobot();
		int nbCarteADistribuer = this.nbCarteADistribuer();
		
		System.out.println(this.pileCarte.toString());
		
		while( nbCarteADistribuer > 0 ) {
			
			for(int j=0; j < menu.getNbHumain() ; j++) {
				nbCarteADistribuer--;
				
				humain[j].getMain().ajouterCarte(this.pileCarte.removeFirst());
			}
			
			for(int k=0; k < menu.getNbRobot() ; k++) {
				nbCarteADistribuer--;
				robot[k].getMain().ajouterCarte(this.pileCarte.removeFirst());
			}
		}
		
		//TODO //System.out.println(pileCarte.toString());
		
	}
	
	/**
	 * 
	 * Piocher dans le talon
	 * @return
	 */
	public Carte piocher(){
		return this.pileCarte.removeFirst();
	}
	
	public void afficherJeuDesHumains () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbHumain(); i++) {			
			System.out.println(menu.getHumain()[i].getMain().toString());
			}
	}

	public void afficherJeuDesRobots () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbRobot(); i++) {
			
			System.out.println(menu.getRobot()[i].getMain().toString());
		}
	}
	
	public LinkedList<Carte> getPileCarte() {
		return this.pileCarte;
	}
	
}
