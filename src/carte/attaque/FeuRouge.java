package carte.attaque;

import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.Prioritaire;

public class FeuRouge extends Attaque {

	public FeuRouge() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Feu Rouge";
	}

	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
}
