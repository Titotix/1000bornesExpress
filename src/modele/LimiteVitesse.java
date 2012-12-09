package modele;

public class LimiteVitesse extends Attaque {

	public LimiteVitesse() {
	
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Accident";
	}
	
	public void Jouer(JeuSurTable jeuAdverse, JeuEnMain jeu, LimiteVitesse carte){
		
		jeuAdverse.ajouterCarteVitesse(carte);
		jeu.retirerCarte(carte);
		
	}

}
