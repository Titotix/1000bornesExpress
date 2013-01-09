package carte.parade;

import jeu.PartieDeJeu;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.Crevaison;
/**
 * Represente la carte Roue de secours
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * @author Damien
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
	
	/**
	 * Permet de poser la carte au bon endroit 
	 * @param joueur 
	 * @param inutile
	 */
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
