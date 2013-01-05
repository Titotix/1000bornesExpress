package carte.parade;

import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;

public class Essence extends Parade{

	public Essence() {
		
		// TODO Auto-generated constructor stub
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
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		
	}

}
