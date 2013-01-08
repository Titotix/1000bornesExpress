package joueurs;

import java.util.*;

import tasDeCartes.Carte;


public class JeuEnMain extends Observable{


	private LinkedList<Carte> main;
	
	public JeuEnMain(){
		this.main = new LinkedList<Carte>();
	}
	
	/**
	 * Permet d'ajouter une carte apres la pioche
	 * @param carte
	 */
	public void ajouterCarte(Carte carte) {
		this.main.add(carte);
		this.setChanged();
		this.notifyObservers();		
	}
	
	/**
	 * Permet de retirer une carte de la main du joueur.
	 * @param carte
	 */
	public void retirerCarte (Carte carte){
		if(this.main.remove(carte)) {
			this.setChanged();
			this.notifyObservers();
		} 
			
	}

	public LinkedList<Carte> getMain() {
		return this.main;
	}
	
	public String toString() {
		return main.toString();
	}
	
	
}
