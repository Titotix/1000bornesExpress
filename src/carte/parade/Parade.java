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
	
	public abstract void jouer(Joueur joueur, Joueur inutile);
	
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
