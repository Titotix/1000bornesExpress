package carte.attaque;

import java.util.Iterator;

import carte.bottes.Botte;
import tasDeCartes.Carte;
import joueurs.Joueur;

/**
 * 
 * Regroupe tous les types d'attaque
 * On y trouve la verification que la carte selectionnée est bien jouable
 * 
 * 
 */
public abstract class Attaque extends Carte {
	
	
	
	public Attaque (){
		
		
	}
	/**
	 * Indique la compatibilité entre l'instance de cette classe et la botte mise ne paramètre.
	 * @param botte
	 * @return boolean
	 */
	public abstract boolean isCompatible(Botte botte);
	
	/**
	 * Permet de savoir si le joueur peut jouer contre cet adversaire
	 * @param joueurActuel
	 * @param adversaire
	 * 
	 */
	public boolean isJouable(Joueur joueurActuel, Joueur adversaire) { 
		if(adversaire == null) {
			return false;
		}
		return this.isJouableContre(adversaire);
	}
	
	/**
	 * Permet de savoir si l'instance d'Attaque est jouable contre l'adversaire indiqué.
	 * @param adversaire
	 * @return boolean
	 */
	public boolean isJouableContre(Joueur adversaire) {
		
		/**
		 * Si l'instance est de type Crevaison, FeuROuge, Accident ou PanneEssence
		 */
		if(this instanceof Crevaison || this instanceof FeuRouge || this instanceof Accident|| this instanceof PanneEssence ) {
			
			/**
			 * Si la pile de bataille de l'adversaire visé est vide et que cet adversaire a déjà démarrer
			 */
			if(adversaire.getJeuSurTable().getPileBataille().isEmpty() == false  || adversaire.getJeuSurTable().isDemarrer() == false) {		
				return false;
			}
			/**
			 * On regarde alors si la pile botte ne contient pas la botte adequate pour bloquer l'attaque.	
			 */
			if( adversaire.getJeuSurTable().getPileBotte().isEmpty() == false) {
			
				for(Iterator<Botte> it = adversaire.getJeuSurTable().getPileBotte().iterator() ; it.hasNext() ;) {	
					/**
					 * si c'est le cas, on retourne faux, la carte attaque n'est pas jouable contre cette adversaire.
					 */
					if(this.isCompatible(it.next())) {
						
						return false;
					}
				}
				return true;
			} else {
				return true;
			}
		
			/**
			 * Si c'est une limite de vitesse il suffit que la pile de vitesse soit vide pour que la limite de vitesse soit jouable.
			 */
		} else if(this instanceof LimiteVitesse) {
			
			if(adversaire.getJeuSurTable().getPileVitesse().isEmpty()) {		
				/**
				 * On regarde alors si la pile botte ne contient pas la botte adequate pour bloquer l'attaque.	
				 */
				if( adversaire.getJeuSurTable().getPileBotte().isEmpty() == false) {
				
					for(Iterator<Botte> it = adversaire.getJeuSurTable().getPileBotte().iterator() ; it.hasNext() ;) {	
						/**
						 * si c'est le cas, on retourne faux, la carte attaque n'est pas jouable contre cette adversaire.
						 */
						if(this.isCompatible(it.next())) {
							
							return false;
						}
					}
				} else {
					return true;
				}
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Va placer la carte Attaque au bon endroit sur le jeu adverse et va retirer la carte Attaque de la main du joueur.
	 * De plus, elle indiquera à l'instance PartieDeJeu le joueur dont c'est le tour après cette action.
	 * @param joueur Joueur qui est en train de jouer.
	 * @param adversaire Joueur visé par l'attaque.
	 * 
	 */

	public abstract void jouer(Joueur joueur, Joueur adversaire);
	
}
