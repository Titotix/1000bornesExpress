package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;

public class FeuVert extends Parade {

	public FeuVert() {
		
		
	}
	
	
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof FeuRouge) {
			return true;
		} else { return false; }
	}

	
	
	public String toString() {
		return "Feu Vert";
	}

	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		
		if(joueur.getJeuSurTable().isDemarrer() == false) {
			joueur.getJeuSurTable().getPileFeuVertInitial().add((FeuVert) this);
		} else {
			Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		}
		
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

	}

}
