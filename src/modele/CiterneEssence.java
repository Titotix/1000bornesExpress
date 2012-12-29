package modele;

import controleur.*;

public class CiterneEssence extends Botte{

	public CiterneEssence() {
		
	}

	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().get(0) instanceof PanneEssence) {
			return true;
		}
		return false;
	}


	public String toString() {
		return "Citerne Essence";
	}

}
