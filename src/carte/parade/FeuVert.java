package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;
/**
 * Represente la carte parade Feu vert
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * 
 *
 */
public class FeuVert extends Parade {

	public FeuVert() {
		
		
	}
	
	/**
	 * Indique si la carte est compatible avec l'Attaque indiqué.
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof FeuRouge) {
			return true;
		} else { return false; }
	}

	
	/**
	 * Retourne "feu vert"
	 */
	public String toString() {
		return "Feu Vert";
	}
	
	/**
	 * Permet l'ensemble des actions inclus dans le fait de jouer la carte.
	 * La retirer de la main.
	 * Ensuite ajoute le Feu vert soit à PileFeuVertInitial soit va enlever une attaque préalablement subit par le joueur, selon si le joueur a déjà un feu vert initial ou non.
	 * @param joueur
	 * 
	 */
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 
		
		if(joueur.getJeuSurTable().isDemarrer() == false) {
			joueur.getJeuSurTable().ajouterFeuVertInitial((FeuVert) this);
		} else {
			Attaque carte = joueur.getJeuSurTable().getPileBataille().get(0);
			Defausse.getInstance().ajouter2Carte( carte , this);
			joueur.getJeuSurTable().retirerCarteBataille(carte);
		}
		
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

	}

}
