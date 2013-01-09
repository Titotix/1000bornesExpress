package carte.parade;

import jeu.PartieDeJeu;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;
/**
 * Represente la carte parade Essence
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * @author Damien
 *
 */
public class Essence extends Parade{

	public Essence() {
		
		
	}
    /**
     * Affiche "essence"
     */
	public String toString() {
		return "Essence";
	}
	/**
	 * Indique que le carte est compatible avec Panne d'essence
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
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
