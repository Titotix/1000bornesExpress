package carte.parade;

import carte.attaque.Attaque;
import carte.attaque.FeuRouge;

public class FeuVert extends Parade {

	public FeuVert() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof FeuRouge) {
			return true;
		} else { return false; }
	}

	
	
	public String toString() {
		return "Feu Vert";
	}


}
