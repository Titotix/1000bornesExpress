package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.Crevaison;
/**
 * Represente la carte Increvable
 * On y trouve les booleens precisant si elle est jouable en coup fourré et quelle attaque elle bloque
 * 
 *
 */
public class Increvable extends Botte {

	public Increvable() {
		
	}
	/**
	 * Retourne vrai si Increvable est jouable en tant que coupo fourré contre le JeuSurTable indiqué.
	 * @param notreJeu
	 * @return boolean
	 */
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().isEmpty() == false) {
			if(notreJeu.getPileBataille().get(0) instanceof Crevaison) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Indique la compatibilité avec l'Attaque indiqué.
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Crevaison) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Retourne "increvable"
	 */
	public String toString() {
		return "Increvable";
	}

}
