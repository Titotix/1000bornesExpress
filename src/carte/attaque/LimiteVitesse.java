package carte.attaque;

import carte.bottes.Botte;
import carte.bottes.Prioritaire;

public class LimiteVitesse extends Attaque {

	private static int borneMaxJouable=50;


	public LimiteVitesse() {
	
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Accident";
	}

	
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
	
	public static int getBorneMaxJouable() {
		return borneMaxJouable;
	}

	public static void setBorneMaxJouable(int borneMaxJouable) {
		LimiteVitesse.borneMaxJouable = borneMaxJouable;
	}

}
