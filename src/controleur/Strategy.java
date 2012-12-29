package controleur;

import modele.*;

public interface Strategy {

	
	public TasDeCarte choixPioche();
	public Carte choixCarte(Joueur joueur, boolean defausser);
	public Joueur choixCible(Joueur joueurActuel, Attaque carte);
}
