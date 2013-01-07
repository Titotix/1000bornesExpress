package joueurs;

import jeu.PartieDeJeu;

public class Humain extends Joueur {


	
	public Humain(String nomJoueur, int numPassage) {
		super(nomJoueur, numPassage);
				
	}

	@Override
	public void jouer() { //TODO
	//TODO
		
		

		PartieDeJeu partie = PartieDeJeu.getInstance();
		partie.setNumeroJoueurActuel(this.getNumPassage() + 1);
		this.setChanged();
		this.notifyObservers(partie);
	}

	@Override
	public void coupFourre() {
		// TODO Auto-generated method stub
		
	}


}
