package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.LimiteVitesse;
/**
 * Represente la carte parade Fin de limite vitesse
 * On y trouve les methodes verifiant que la carte se pose au bon endroit, et avec quelle attaque elle est compatible
 * @author Damien
 *
 */
public class FinLimiteVitesse extends Parade {

	public FinLimiteVitesse() {
		
		
	}
	/**
	 * Affiche "Fin limite vitesse"
	 */
	public String toString() {
		return "Fin Limite Vitesse";
	}
	/**
	 * Indique la compatibilité avec Limite Vitesse
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof LimiteVitesse) {
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
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileVitesse().remove(0), this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
