package carte.parade;

import jeu.PartieDeJeu;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;

public class Essence extends Parade{

	public Essence() {
		
		
	}
	
	public String toString() {
		return "Essence";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
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
