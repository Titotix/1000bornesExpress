package modele;

public class AsDuVolant extends Botte {

	public AsDuVolant() {
		
	}
	
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().get(0) instanceof Accident) {
			return true;
		}
		return false;
	}
	
	
	public String toString() {
		return "AsDuVolant";
	}

}
