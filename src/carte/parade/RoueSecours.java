package carte.parade;

import jeu.PartieDeJeu;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.Crevaison;
/**
 * Represente la carte Roue de secours
 * On y trouve les methodes permettant de jouer la carte ainsi que savoir si elle est comaptible avec une attaque.
 *
 */
public class RoueSecours extends Parade {

	public RoueSecours() {
		
		
	}
	/**
	 * Affiche "roue de secours"
	 */
	public String toString() {
		return "Roue Secours";
	}
	
	/**
	 * Indique la compatibilité avec la carte crevaison
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Crevaison) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		
		Attaque carte = joueur.getJeuSurTable().getPileBataille().get(0);
		Defausse.getInstance().ajouter2Carte( carte , this);
		joueur.getJeuSurTable().retirerCarteBataille(carte);
		
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
