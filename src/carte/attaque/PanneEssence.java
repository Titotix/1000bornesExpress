package carte.attaque;

import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.CiterneEssence;

public class PanneEssence extends Attaque {

	public PanneEssence() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Panne Essence";
	}

	public boolean isCompatible(Botte botte) {
		if(botte instanceof CiterneEssence) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		
	}

}
