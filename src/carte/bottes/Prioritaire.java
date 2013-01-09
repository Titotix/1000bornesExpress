package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;
import carte.attaque.LimiteVitesse;
/**
 * Represente la carte Prioritaire
 * On y trouve les booleens precisant si elle est jouable en coup fourré et quelle attaque elle bloque
 * @author Damien
 *
 */
public class Prioritaire extends Botte {

	public Prioritaire() {
		
	}
	/**
	 * Indique que la carte est jouable en coup fourre contre Feu rouge
	 * @param notreJeu
	 */
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().isEmpty() == false) {
			if(notreJeu.getPileBataille().get(0) instanceof FeuRouge ) {
				return true;
			}
		} else if (notreJeu.getPileVitesse().isEmpty() == false){
			if( notreJeu.getPileVitesse().get(0) instanceof LimiteVitesse ) {
				return true;
			}
		}
		
		return false;
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
	 * Affiche "Prioritaire"
	 */
	public String toString() {
		return "Prioritaire";
	}

}
