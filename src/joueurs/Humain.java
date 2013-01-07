package joueurs;

import carte.bottes.Botte;
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

	}

	@Override
	public void coupFourre(Botte botte) {
		// TODO Auto-generated method stub
		
	}


}
