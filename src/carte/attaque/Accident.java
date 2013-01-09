package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;

/**
 * Carte de type Attaque Accident
 * On y trouve la correspondance a la botte As du volant 
 * et la methode pour jouer la carte sur le bon tas
 *
 */
public class Accident extends Attaque {

	public Accident() {
		
	}
	
	
	/**
	 * Permet d'afficher le mot accident
	 */
	public String toString() {
		return "Accident";
	}
	
	/**
	 * Renvoie un boolean indiquant si la carte est compatible avec As du volant
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof AsDuVolant) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet de poser la carte accident sur le bon tas
	 */
	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		/**
		 * Pour que le joueur suivant joue
		 */
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 
		
	}
}
