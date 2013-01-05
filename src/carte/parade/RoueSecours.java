package carte.parade;

import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.Crevaison;

public class RoueSecours extends Parade {

	public RoueSecours() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Roue Secours";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Crevaison) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		
	}

}
