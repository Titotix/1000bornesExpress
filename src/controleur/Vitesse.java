package controleur;

import modele.*;


public class Vitesse implements Strategy {

	@Override
	public Carte choixCarte(JeuEnMain jeuEnMain) {
		return null;
		
	}

	/**
	 * Le robot ne pioche dans la défausse que si la carte visible  est une carte Etape.
	 * 
	 * @return Tas de carte (talon ou defausse) danbs lequel le robot va vouloir piocher
	 */
	public TasDeCarte choixPioche() {
		Defausse defausse = Defausse.getInstance();
		
		if(defausse.getPileCarte().getFirst() instanceof Etape) {
			return defausse;
		}
		Talon talon = Talon.getInstance();
		return talon;
		
	}

	
}
