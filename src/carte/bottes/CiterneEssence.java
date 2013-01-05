package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.PanneEssence;

public class CiterneEssence extends Botte{

	public CiterneEssence() {
		
	}

	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().isEmpty() == false) {
			if(notreJeu.getPileBataille().get(0) instanceof PanneEssence) {
				return true;
			}
		}
		return false;
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
			return true;
		} else { return false; }
	}

	public String toString() {
		return "Citerne Essence";
	}

}
