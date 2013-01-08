package joueurs;

import carte.bottes.Botte;
import jeu.PartieDeJeu;

public class Humain extends Joueur {


	
	public Humain(String nomJoueur, int numPassage) {
		super(nomJoueur, numPassage);
				
	}

	@Override
	public synchronized void jouer() { //TODO
	//TODO
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PartieDeJeu partie = PartieDeJeu.getInstance();
		partie.setNumeroJoueurActuel(this.getNumPassage());

	}

	@Override
	public synchronized void coupFourre(Botte botte) {
		this.setChanged();
		this.notifyObservers("coupFourree");
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
