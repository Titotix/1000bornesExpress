package modele;

public class Prioritaire extends Botte {

	public Prioritaire() {
		
	}
	
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().get(0) instanceof FeuRouge || notreJeu.getPileVitesse().get(0) instanceof LimiteVitesse) {
			return true;
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
