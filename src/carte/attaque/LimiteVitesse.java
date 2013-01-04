package carte.attaque;

import joueurs.JeuEnMain;
import joueurs.JeuSurTable;

public class LimiteVitesse extends Attaque {

	private static int borneMaxJouable=50;


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
	
	public static int getBorneMaxJouable() {
		return borneMaxJouable;
	}

	public static void setBorneMaxJouable(int borneMaxJouable) {
		LimiteVitesse.borneMaxJouable = borneMaxJouable;
	}

}
