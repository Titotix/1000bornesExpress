package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Accident;
import carte.attaque.Attaque;
/**
 * Represente la carte Reparation
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * @author Damien
 *
 */
public class Reparation extends Parade {

	public Reparation() {
	
		
	}
	/**
	 * Affiche "Reparation"
	 */
	public String toString() {
		return "Reparation";
	}
	/**
	 * Indique que la carte est compatible avec Accident
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Accident) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet de poser la carte sur le bon tas
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
