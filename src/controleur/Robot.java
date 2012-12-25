package controleur;

import modele.*;

public class Robot extends Joueur {
	
	public Robot(String nomJoueur, int numPassage) {
		super(nomJoueur, numPassage);
	
	}

	private Strategy strat;

	@Override
	public void jouer() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Carte choixCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TasDeCarte choixPioche(JeuEnMain jeuEnMain) {
		// TODO Auto-generated method stub
		return null;
	}

}
