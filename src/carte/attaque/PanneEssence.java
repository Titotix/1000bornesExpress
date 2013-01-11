package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.CiterneEssence;
/**
 * 
 * Carte de type Attaque Panne d'essence
 * On y trouve la correspondance avec Citerne d'essence et 
 * la methode permettant de la poser sur le bon tas
 * @author Damien
 *
 */
public class PanneEssence extends Attaque {

	public PanneEssence() {
		
		
	}
	/**
	 * Retourne "panne essence"
	 */
	public String toString() {
		return "Panne Essence";
	}
	
	/**
	 * Indique la compatibilité entre cette carte et la botte indiqué.
	 * @param botte
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof CiterneEssence) {
			return true;
		} else { return false; }
	}
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
