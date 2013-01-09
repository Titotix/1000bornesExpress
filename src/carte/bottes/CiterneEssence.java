package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;
/**
 * Represente la carte Citerne D'essence
 * On y trouve les booleens precisant si elle est jouable en coup fourré et quelle attaque elle bloque
 * @author Damien
 *
 */
public class CiterneEssence extends Botte{

	public CiterneEssence() {
		
	}
/**
 * Indique qu'elle est jouable en coup fourre contre Panne d'essence
 * @param notreJeu
 */
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().isEmpty() == false) {
			if(notreJeu.getPileBataille().get(0) instanceof PanneEssence) {
				return true;
			}
		}
		return false;
	}
/**
 * Indique la compatibilité avec la carte Panne essence
 * @param attaque
 */
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Affiche "Citerne essence"
	 */
	public String toString() {
		return "Citerne Essence";
	}

}
