package carte.parade;

import carte.attaque.Attaque;
import carte.attaque.LimiteVitesse;

public class FinLimiteVitesse extends Parade {

	public FinLimiteVitesse() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Fin Limite Vitesse";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof LimiteVitesse) {
			return true;
		} else { return false; }
	}

}
