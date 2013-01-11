package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.Prioritaire;
/**
 * 
 * Carte de type Attaque Feu Rouge
 * On y trouve la correspondance avec Prioritaire et
 * la methode permettant de jouer la carte.
 *
 *
 */
public class FeuRouge extends Attaque {

	public FeuRouge() {
		
		
	}
	
	/**
	 * Retourne "Feu Rouge"
	 */
	public String toString() {
		return "Feu Rouge";
	}
	
	/**
	 * Indique la compatibilité entre cette carte et la botte indiqué.
	 * @param botte
	 * @return boolean
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
	
	@Override
	/**
	 * Permet de poser la carte sur le jeu adverse, de retirer la carte de la main du joueur et indique à l'instance de PartieDeJeu le joueur suivant.
	 * @param joueur
	 * @param adversaire
	 */
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() );
	}
}
