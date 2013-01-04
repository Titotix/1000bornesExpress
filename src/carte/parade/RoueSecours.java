package carte.parade;

import carte.attaque.Attaque;
import carte.attaque.Crevaison;

public class RoueSecours extends Parade {

	public RoueSecours() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Roue Secours";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Crevaison) {
			return true;
		} else { return false; }
	}

}
