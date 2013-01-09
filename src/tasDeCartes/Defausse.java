package tasDeCartes;

import java.util.*;

/**
 * Represente la defausse
 * @author Damien
 *
 */
public class Defausse extends TasDeCarte {

	private LinkedList<Carte> pileCarte;
	private static Defausse defausse = null;
	
	
	public Defausse (){
		pileCarte = new LinkedList<Carte>();
	}
	
	
	public static Defausse getInstance() {
		if(defausse == null) {
			defausse = new Defausse();
		}
		return defausse;
	}
	
	
	/**
	 * Piocher une carte dans la d�fausse
	 * @return carte
	 */
	public Carte piocher(){
		Carte carte = this.pileCarte.removeFirst();
		this.setChanged();
		this.notifyObservers();
		return carte;
		
	}
	/**
	 * 
	 * 
	 * @param carte1 : premiere carte a etre defausser
	 * @param carte2 : carte qui restera apparente après le defausse des 2 cartes
	 */
	
	public void ajouter2Carte(Carte carte1, Carte carte2) {
		this.pileCarte.addFirst(carte1);
		this.pileCarte.addFirst(carte2);
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/**
	 * Mettre la carte dans la defausse 
	 * @param carte
	 */
	public void ajouterCarte (Carte carte){
		this.pileCarte.addFirst(carte);
		this.setChanged();
		this.notifyObservers();
	}
	/**
	 * Permet de savoir si une pile est vide
	 * @return boolean
	 */
	public boolean isEmpty() {
		return this.pileCarte.isEmpty();
	}
	

	public LinkedList<Carte> getPileCarte() {
		return this.pileCarte;
	}
}
