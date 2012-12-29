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
		
		if(this.choixDefausser()) {
			this.defausser(this.choixCarte(true)); //Le robot choisit une carte à défausser.
		} else {
			Carte carteChoisie = this.choixCarte(false);
			if(carteChoisie instanceof Attaque) {
				carteChoisie.jouer(this, this.choixCible((Attaque) carteChoisie));
			} else {
				carteChoisie.jouer(this, null);
			}
			
		}
		
	}
	
	/**
	 * Renvoie faux si l'action choisie est de jouer une carte.
	 * Renvoie vrai si l'action choisie est de défausser une carte.
	 * Le robot choisira de défausser uniquement quand il n'aura aucune carte à jouer.
	 * @return boolean
	 */
	public boolean choixDefausser(){ 

		for(Iterator<Carte> it = this.jeuEnMain.getMain().iterator(); it.hasNext() ; ) {
			//On teste toutes les cartes de la main du joueur
			Carte carte = it.next();
			Menu menu = Menu.getInstance();
			for(Iterator<Joueur> it1 = menu.getJoueurs().iterator() ; it1.hasNext() ; ) {
				//Pour chaque carte, on tente de les jouer sur tous les joueurs autre que nous même.
				Joueur joueur = it1.next();
				if(carte.isJouable(this, joueur) && joueur != this) {
					//Si une des carte du jeu du Robot est jouable alors il jouera et ne defaussera pas.
					return false;
				}
			}
			
		}
		//Si ce n'est pas le cas, il defausse et cette methode renvoie alors false.
		return true;
	}
	
	public Carte choixCarte(boolean defausser) {
		return this.strat.choixCarte(this, defausser);		
	}

	
	public Joueur choixCible(Attaque carte) {
		return this.strat.choixCible(this, carte);
	}
	
	public TasDeCarte choixPioche() {
		return this.strat.choixPioche();
	}

}
