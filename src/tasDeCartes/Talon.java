package tasDeCartes;

import java.util.*;

import jeu.Menu;

import joueurs.Humain;
import joueurs.Robot;
/**
 * Represente le talon dans lequel on peut piocher
 * @author Damien
 *
 */
public class Talon extends TasDeCarte {
	
	private final int nombreCarteInitial = 66;
	private LinkedList<Carte> pileCarte; 
	private static Talon talon = null;
	
	
	private Talon () {
		pileCarte = new LinkedList<Carte>();
	}
	

	
	
	public static Talon getInstance() {
		if(talon == null) {
			talon = new Talon();
		}
		return talon;
	}
	
	
	
	/**
	 * Calcul du nombre de cartes a distribuer
	 * 
	 * @return nombre de carte a distribuer au total
	 */
	public int nbCarteADistribuer(){
		Menu menu = Menu.getInstance();
		return menu.getNbJoueurTotal() * 4; 
	}
	
	/**
	 * Trier les cartes aleatoirement
	 */
	public void aleatoirePileCarte(){
		long seed =System.nanoTime();
		Collections.shuffle(pileCarte, new Random(seed));
		
	}
	
	/**
	 * Distribuer les cartes depuis le talon
	 */
	public void distribuer() {
		Menu menu = Menu.getInstance();
		LinkedList<Humain> humain = menu.getHumain();
		LinkedList<Robot> robot = menu.getRobot();
		int nbCarteADistribuer = this.nbCarteADistribuer();
		
		while( nbCarteADistribuer > 0 ) {
			
			for(int j=0; j < menu.getNbHumain() ; j++) {
				nbCarteADistribuer--;
				
				humain.get(j).getJeuEnMain().ajouterCarte(this.pileCarte.removeFirst());
			}
			
			for(int k=0; k < menu.getNbRobot() ; k++) {
				nbCarteADistribuer--;
				robot.get(k).getJeuEnMain().ajouterCarte(this.pileCarte.removeFirst());
			}
		}
		
		
		
	}
	/**
	 * Permet de savoir si la pile est vide
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.pileCarte.isEmpty();
	}
	
	/**
	 * 
	 * Piocher dans le talon
	 * @return carte
	 */
	public Carte piocher(){
		try {
			return this.pileCarte.removeFirst();
			
			/**
			 * Si il n'y a plus de carte dans le talon
			// on prend toutes les cartes de la defausse et on les place dans le talon.
			 */
		} catch (NoSuchElementException e) {
			
			Defausse defausse = Defausse.getInstance();
			this.pileCarte.addAll(defausse.getPileCarte());
			defausse.getPileCarte().removeAll(defausse.getPileCarte());
			return this.pileCarte.removeFirst();
		}
	}
	
	
	public LinkedList<Carte> getPileCarte() {
		return this.pileCarte;
	}
	
}
