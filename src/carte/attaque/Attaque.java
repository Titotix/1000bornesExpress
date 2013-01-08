package carte.attaque;

import java.util.Iterator;

import carte.bottes.Botte;
import tasDeCartes.Carte;
import joueurs.Joueur;


public abstract class Attaque extends Carte {
	
	
	//constructeur
	public Attaque (){
		
		
	}
	
	public abstract boolean isCompatible(Botte botte);
	
	public boolean isJouable(Joueur joueurActuel, Joueur adversaire) { 
		if(adversaire == null) {
			return false;
		}
		return this.isJouableContre(adversaire);
	}
	
	
	public boolean isJouableContre(Joueur adversaire) {
		
		if(this instanceof Crevaison || this instanceof FeuRouge || this instanceof Accident|| this instanceof PanneEssence ) {
			//Si l'instance est de type Crevaison, FeuROuge, Accident ou PanneEssence
			
			if(adversaire.getJeuSurTable().getPileBataille().isEmpty() && adversaire.getJeuSurTable().isDemarrer()) {		
			//Si la pile de bataille de l'adversaire visé est vide et que cet adversaire a déjà démarrer
				
				if( adversaire.getJeuSurTable().getPileBotte().isEmpty() == false) {
				//On regarde alors si la pile botte ne contient pas la botte adequate pour bloquer l'attaque.	
					for(Iterator<Botte> it = adversaire.getJeuSurTable().getPileBotte().iterator() ; it.hasNext() ;) {	
						if(this.isCompatible(it.next())) {
							//si c'est le cas, on retourne faux, la carte attaque n'est pas jouable contre cette adversaire.
							return false;
						}
					}
				} else {
					return true;
				}
			}
		} else if(this instanceof LimiteVitesse) {
			//Si c'est une limite de vitesse il suffit que la pile de vitesse soit vide pour que la limite de vitesse soit jouable.
			if(adversaire.getJeuSurTable().getPileVitesse().isEmpty()) {		
				return true;
			}
			
		}
		return false;
	}
	
	/**
	 * Va placer la carte Attaque au bon endroit sur le jeu adverse et va retirer la carte Attaque de la main du joueur.
	 * @param joueur qui est en train de jouer.
	 * @param adversaire visé par l'attaque.
	 * 
	 */

	public abstract void jouer(Joueur joueur, Joueur adversaire);
	
}
