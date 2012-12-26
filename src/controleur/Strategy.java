package controleur;

import modele.*;

public interface Strategy {

	
	public TasDeCarte choixPioche();
	public Carte choixCarte(JeuEnMain jeuEnMain);
}
