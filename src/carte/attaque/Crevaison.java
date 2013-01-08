package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.Increvable;

public class Crevaison extends Attaque {

	public Crevaison() {
		
		
	}
	
	public String toString() {
		return "Crevaison";
	}

	public boolean isCompatible(Botte botte) {
		if(botte instanceof Increvable) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() );

		
	}

}
