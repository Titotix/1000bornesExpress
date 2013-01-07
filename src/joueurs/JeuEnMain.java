package joueurs;

import java.util.*;

import tasDeCartes.Carte;


public class JeuEnMain extends Observable{


	private LinkedList<Carte> main;
	
	public JeuEnMain(){
		this.main = new LinkedList<Carte>();
	}
	
	//Permet d'ajouter une carte apres la pioche
	public void ajouterCarte(Carte carte) {
		this.main.add(carte);
		this.setChanged();
		this.notifyObservers();		
	}
	
	//Permet de retirer une carte de la main du joueur.
	public void retirerCarte (Carte carte){
		if(this.main.remove(carte)) {
			this.setChanged();
			this.notifyObservers();
		} else {
			//TODO la carte qui a voulu etre retire de la main n'était pas dans la main.
		}
			
	}

	public LinkedList<Carte> getMain() {
		return this.main;
	}
	
	public String toString() {
		return main.toString();
	}
	
	
}
