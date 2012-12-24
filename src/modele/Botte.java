package modele;
import java.util.*;
import controleur.*;


public abstract class Botte extends Carte  {
	
	protected int Kilometres;
	
	public abstract boolean isJouableCoupFourre(JeuSurTable notreJeu);

	//constructeur
	public Botte() {
	
	}
	
	public void jouer(Joueur joueur) { 
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		//ajouter la carte au jeu sur table du joueur
		joueur.getJeuSurTable().setNbKmParcouru(joueur.getJeuSurTable().getNbKmParcouru() + 100);
		//jouer une botte augmente de 100 le nb de Km parcouru
		joueur.getJeuEnMain().retirerCarte(this);
		//retirer la botte de la main du joueur
	}
	
	
	public void coupFourre(Joueur joueur) {
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		//ajouter la carte au jeu sur table du joueur
		joueur.getJeuSurTable().setNbKmParcouru(joueur.getJeuSurTable().getNbKmParcouru() + 300);
		//un coup fourree augmente de 300 le nb de Km parcouru
		joueur.getJeuEnMain().retirerCarte(this);
		//retirer la botte de la main du joueur
		//TODO : modification du tour de jeu
		
		
	}
	
}
