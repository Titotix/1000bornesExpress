package controleur;

import modele.*;


public class AggressifMeilleurJoueur implements Strategy {

	@Override
	public Carte choixCarte(JeuEnMain jeuEnMain) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Le robot ne pioche dans la defausse que si la carte visible est une attaque.
	 * 
	 * @return TasDeCarte dans lequel le robot veut piocher.
	 */
	public TasDeCarte choixPioche() {
		
		Defausse defausse = Defausse.getInstance();
		
		if(defausse.getPileCarte().getFirst() instanceof Attaque) {
			return defausse;
		}
		Talon talon = Talon.getInstance();
		return talon;
	}

}
