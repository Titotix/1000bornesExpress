package carte.parade;

import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Accident;
import carte.attaque.Attaque;

public class Reparation extends Parade {

	public Reparation() {
	
		// TODO Auto-generated constructor stub
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
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		
	}


}
