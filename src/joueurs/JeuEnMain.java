package joueurs;

import java.util.*;

import tasDeCartes.Carte;

/**
 * Représente le jeu en main de chacun des joueurs
 * @author Damien
 *
 */
public class JeuEnMain extends Observable{


	private LinkedList<Carte> main;
	private Joueur joueur;
	
	public JeuEnMain(Joueur joueur){
		this.main = new LinkedList<Carte>();
		this.joueur = joueur;
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
	/**
	 * Recupere la main du joueur
	 * 
	 */
	public LinkedList<Carte> getMain() {
		return this.main;
	}
	
	public String toString() {
		return main.toString();
	}

	public Joueur getJoueur() {
		return this.joueur;
	}
	
	
}
