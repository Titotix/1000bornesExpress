package modele;

public class Reparation extends Parade {

	public Reparation() {
	
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Reparation";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof Accident) {
			return true;
		} else { return false; }
	}


}
