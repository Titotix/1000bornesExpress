package carte.attaque;

import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;


public class Accident extends Attaque {

	public Accident() {
		
	}
	
	public String toString() {
		return "Accident";
	}

	public boolean isCompatible(Botte botte) {
		if(botte instanceof AsDuVolant) {
			return true;
		} else { return false; }
	}

	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		
	}
}
