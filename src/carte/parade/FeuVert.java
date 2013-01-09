package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;
/**
 * Represente la carte parade Feu vert
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * @author Damien
 *
 */
public class FeuVert extends Parade {

	public FeuVert() {
		
		
	}
	
	/**
	 * Indique que la carte est compatible avec Feu Rouge
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof FeuRouge) {
			return true;
		} else { return false; }
	}

	
	/**
	 * Affiche "feu vert"
	 */
	public String toString() {
		return "Feu Vert";
	}
	
	/**
	 * Permet de poser la carte au bon endroit 
	 * @param joueur
	 * @param inutile
	 */
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		
		if(joueur.getJeuSurTable().isDemarrer() == false) {
			joueur.getJeuSurTable().getPileFeuVertInitial().add((FeuVert) this);
		} else {
			Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0), this);
		}
		
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

	}

}
