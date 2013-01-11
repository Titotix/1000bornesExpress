package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;

/**
 * Carte de type Attaque Accident
 * On y trouve la correspondance a la botte As du volant 
 * et la methode pour jouer la carte.
 *
 */
public class Accident extends Attaque {

	public Accident() {
		
	}
	
	
	/**
	 * Retourne "Accident"
	 */
	public String toString() {
		return "Accident";
	}
	
	/**
	 * Renvoie un boolean indiquant si la carte est compatible avec la botte indiqué.
	 * @param botte
	 * @return boolean
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof AsDuVolant) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet de poser la carte accident sur le bon tas
	 * @param joueur Joueur qui joue.
	 * @return adversaire Joueur qui reçoit l'attaque.
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
