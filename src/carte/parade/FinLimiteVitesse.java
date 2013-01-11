package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.LimiteVitesse;
/**
 * Represente la carte parade Fin de limite vitesse
 * On y trouve les methodes pour jouer la carte ainsi que savoir si elle est compatible avec une carte Attaque.
 *
 */
public class FinLimiteVitesse extends Parade {

	public FinLimiteVitesse() {
		
		
	}
	/**
	 * Retourne "Fin limite vitesse"
	 */
	public String toString() {
		return "Fin Limite Vitesse";
	}
	/**
	 * Indique la compatibilité l'Attaque indiqué.
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof LimiteVitesse) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet l'ensemble des actions inclus dans le fait de jouer la carte.
	 * @param joueur
	 */
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); 

		LimiteVitesse carte = joueur.getJeuSurTable().getPileVitesse().get(0);
		Defausse.getInstance().ajouter2Carte( carte , this);
		joueur.getJeuSurTable().retirerCarteVitesse(carte);
		
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
