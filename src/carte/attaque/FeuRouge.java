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
 * la methode permettant de la poser sur le bon tas
 * @author Damien
 *
 */
public class FeuRouge extends Attaque {

	public FeuRouge() {
		
		
	}
	
	/**
	 * afficher "feu rouge"
	 */
	public String toString() {
		return "Feu Rouge";
	}
	
	/**
	 * Indique la compatibilité entre cette carte et la botte Prioritaire
	 * @param botte
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
	
	@Override
	/**
	 * Permet de poser la carte sur le tas
	 * @param joueur
	 * @param adversaire
	 */
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() );
	}
}
