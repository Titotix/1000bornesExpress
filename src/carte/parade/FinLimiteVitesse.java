package carte.parade;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import tasDeCartes.Defausse;
import carte.attaque.Attaque;
import carte.attaque.LimiteVitesse;

public class FinLimiteVitesse extends Parade {

	public FinLimiteVitesse() {
		
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Fin Limite Vitesse";
	}

	public boolean isCompatible(Attaque attaque) {
		if(attaque instanceof LimiteVitesse) {
			return true;
		} else { return false; }
	}
	
	@Override
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileVitesse().remove(0), this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); // pour que le joueur suivant joue.

		
	}

}
