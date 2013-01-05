package carte.parade;

import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;

public class FeuVert extends Parade {

	public FeuVert() {
		
		// TODO Auto-generated constructor stub
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
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		
		if(joueur.getJeuSurTable().isDemarrer() == false) {
			joueur.getJeuSurTable().getPileFeuVertInitial().add((FeuVert) this);
		} else {
			Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		}
	}

}
