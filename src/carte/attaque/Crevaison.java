package carte.attaque;

import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.Increvable;

public class Crevaison extends Attaque {

	public Crevaison() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Crevaison";
	}

	public boolean isCompatible(Botte botte) {
		if(botte instanceof Increvable) {
			return true;
		} else { return false; }
	}
	

}
