package controleur;

import modele.*;

public class Humain extends Joueur {


	
	public Humain(String nomJoueur, int numPassage) {
		super(nomJoueur, numPassage);
				
	}

	@Override
	public void jouer() { //TODO
	//TODO
		
		

		//laisser ce code, sers à donner le joueur qui jouera après.
		PartieDeJeu partie = PartieDeJeu.getInstance();
		partie.setNumeroJoueurActuel(this.getNumPassage() + 1);
	}

	@Override
	public void coupFourre() {
		// TODO Auto-generated method stub
		
	}


}
