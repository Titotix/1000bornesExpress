package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Accident;
import carte.attaque.Attaque;

public class Reparation extends Parade {

	public Reparation() {
	
		
	}
	
	public String toString() {
		return "Reparation";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Accident) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}


}
