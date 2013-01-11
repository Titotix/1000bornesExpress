package carte.parade;

import jeu.PartieDeJeu;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;
/**
 * Represente la carte parade Essence
 * On y trouve les methodes pour jouer la carte e tpour vérifier si elle est compatible avec une attaque.
 *
 */
public class Essence extends Parade{

	public Essence() {
		
		
	}
    /**
     * Retourne "essence"
     */
	public String toString() {
		return "Essence";
	}
	/**
	 * Indique si la carte est compatible avec l'Attaque indiqué.
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet de jouer la carte.
	 * Cela retire la carte de la main du joueur, l'ajoute a son jeuSurTable. Indique de plus qui est le joueur suivant.
	 * @param joueur
	 * @param inutile
	 */
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this);
		
		Attaque carte = joueur.getJeuSurTable().getPileBataille().get(0);
		
		Defausse.getInstance().ajouter2Carte( carte , this);
		joueur.getJeuSurTable().retirerCarteBataille(carte);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
