package modele;

public class Increvable extends Botte {

	public Increvable() {
		
	}
	
	public boolean isJouableCoupFourre(JeuSurTable notreJeu) {
		if(notreJeu.getPileBataille().get(0) instanceof Crevaison) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Increvable";
	}

}
