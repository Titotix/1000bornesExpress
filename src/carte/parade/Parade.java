package carte.parade;

import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import joueurs.Joueur;
import carte.attaque.Attaque;

/**
 * Represente les cartes Parade
 * On y verifie dans quelles conditions la carte est jouable, 
 * @author Damien
 *
 */
public abstract class Parade extends Carte {
	
	
	public Parade(){
		
	}
	/**
	 * Réalisera l'ensemble des actions inclus dans le fait de jouer la carte Parade.
	 * Indiquera à l'instance PartieDeJeu qui est le joueur suivant, puisque le tour d ejeu du joueur actuel est terminé par cette action.
	 * @param joueur Joueur qui joue la parade.
	 */
	public abstract void jouer(Joueur joueur, Joueur inutile);
	
	/**
	 * Retourne vrai si la carte Parade est jouable.
	 * Faux dans le cas contraire.
	 * Indique aussi à l'instance de PartieDeJeu qui est le joueur suivant.
	 * @param attaque
	 * @return
	 */
	public abstract boolean isCompatible(Attaque attaque);
	
	/**
	 * Indique dans quelles circonstances la carte est jouable
	 * @param joueur 
	 * @param inutile
	 */
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		
		/**
		 * //si la carte est un feu vert et que le joueur n'a pas demarré alors la carte est jouable.
		 */
		if(this instanceof FeuVert && joueur.getJeuSurTable().isDemarrer() == false) {
			
			return true;
		}
		if(joueur.getJeuSurTable().getPileVitesse().isEmpty() && joueur.getJeuSurTable().getPileBataille().isEmpty()) {
			return false;
		}
	
		if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
			
			if(this.isCompatible( joueur.getJeuSurTable().getPileVitesse().get(0) ) ) {
				return true;
			}
		}
		if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
			if (this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
}
