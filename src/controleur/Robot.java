package controleur;

import java.util.Iterator;

import modele.*;

public class Robot extends Joueur {
	
	public Robot(String nomJoueur, int numPassage, Strategy stratInitiale) {
		super(nomJoueur, numPassage);
		this.strat = stratInitiale;
	
	}

	private Strategy strat;

	public void jouer() {
		this.piocher(this.choixPioche());
		if(this.choixAction()) { //si le robot a decidé de jouer une carte (et non de defausser)
			this.choixCarte().jouer();//TODO : ne fonctionne pas. 
		}
	}
	//return faux si action choisie = defausser
	public boolean choixAction() {
		for(Iterator<Carte> it = this.jeuEnMain.getMain().iterator(); it.hasNext() ; ) {
			Carte carte = it.next();
			if(carte.isJouable()) {
				//Si une des carte du jeu du Robot est jouable alors il jouera
				return true;
			}
		}
		//Si ce n'est pas le cas, il defausse et cette methode renvoie alors false.
		return false;
	}
	
	public Carte choixCarte() {
		return this.strat.choixCarte(this.jeuEnMain);		
	}

	public TasDeCarte choixPioche() {
		return this.strat.choixPioche();
	}

}
