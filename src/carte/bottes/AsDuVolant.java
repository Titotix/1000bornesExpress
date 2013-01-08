package carte.bottes;

import joueurs.JeuSurTable;
import carte.attaque.Accident;
import carte.attaque.Attaque;

public class AsDuVolant extends Botte {

	public AsDuVolant() {
		
	}
	
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().isEmpty() == false) {	
			if(notreJeu.getPileBataille().get(0) instanceof Accident) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Accident) {
			return true;
		} else { return false; }
	}
	
	public String toString() {
		return "AsDuVolant<br>";
	}

}
