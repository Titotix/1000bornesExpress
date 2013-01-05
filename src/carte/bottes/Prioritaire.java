package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Attaque;
import carte.attaque.FeuRouge;
import carte.attaque.LimiteVitesse;

public class Prioritaire extends Botte {

	public Prioritaire() {
		
	}
	
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
	
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof FeuRouge) {
			return true;
		} else { return false; }
	}
	
	public String toString() {
		return "Prioritaire";
	}

}
