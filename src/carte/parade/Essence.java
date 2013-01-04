package carte.parade;

import carte.attaque.Attaque;
import carte.attaque.PanneEssence;

public class Essence extends Parade{

	public Essence() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Essence";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof PanneEssence) {
			return true;
		} else { return false; }
	}

}
