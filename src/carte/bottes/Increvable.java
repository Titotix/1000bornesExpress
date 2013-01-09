package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.Crevaison;
/**
 * Represente la carte Increvable
 * On y trouve les booleens precisant si elle est jouable en coup fourré et quelle attaque elle bloque
 * @author Damien
 *
 */
public class Increvable extends Botte {

	public Increvable() {
		
	}
	/**
	 * Indique que la carte est jouable en coup fourre contre Crevaison
	 * @param notreJeu
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
	 * Indique la compatibilité avec la carte Crevaison
	 * @param attaque
	 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Crevaison) {
			return true;
		} else { return false; }
	}
	
	/**
	 * affiche "increvable"
	 */
	public String toString() {
		return "Increvable";
	}

}
