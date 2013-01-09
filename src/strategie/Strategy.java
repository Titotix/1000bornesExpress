package strategie;

import tasDeCartes.Carte;
import tasDeCartes.TasDeCarte;
import joueurs.Joueur;
import joueurs.Robot;
import carte.attaque.Attaque;


public interface Strategy {

	/**
	 * Choisis dans quel pioche le robot veut prendre sa carte.
	 * Il choisira en fonction de la carte visible dans la défausse.
	 * @return TasDeCarte dans lequel le robot a decider de piocher
	 */
	public TasDeCarte choixPioche();
	
	/**
	 * Choisit la carte à jouer du robot selon différentes stratégies de jeu.
	 * 
	 * @param robotActuel
	 * 
	 * @param defausser 
	 * faux si la carte à choisir n'est pas à défausser
	 * 
	 * @return carte choisie dans la main du robot.
	 */
	public Carte choixCarte(Robot robotActuel, boolean defausser);
	
	/**
	 * Va choisir la cible d'une carte Attaque.
	 * Le choix s'effectue selon la stratégie du robot.
	 * 
	 * @param robotActuel 
	 * @param carte 
	 * @return cible de la carte Attaque que le robot à choisit.
	 */
	public Joueur choixCible(Robot robotActuel, Attaque carte);
}
