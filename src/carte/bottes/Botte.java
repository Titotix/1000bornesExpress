package carte.bottes;
import jeu.PartieDeJeu;
import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import joueurs.JeuSurTable;
import joueurs.Joueur;
import carte.attaque.Attaque;



public abstract class Botte extends Carte  {
	
	protected int Kilometres;
	
	public abstract boolean isJouableCoupFourre(JeuSurTable notreJeu);

	
	public Botte() {
	
	}
	
	public void jouer(Joueur joueur, Joueur inutile) { 
		/**
		 * ajouter la carte au jeu sur table du joueur
		 */
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		
		/**
		 * jouer une botte augmente de 100 le nb de Km parcouru
		 */
		joueur.getJeuSurTable().addNbKmParcouruBotte(100);
		
		
		/**
		 * Si la botte posé est le contre d'une attaque du jeu du joueur, elle sera retiré.
		 */
		if(this instanceof Prioritaire) {
			if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
				Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileVitesse().remove(0));
			}
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileBataille().remove(0));
				}
			}
		}
		else {
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileBataille().remove(0));
				}
			}
		}
		
		
		joueur.getJeuEnMain().retirerCarte(this);
		
		/**
		 * pour que le joueur rejoue.
		 */
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() - 1); 
	}
	
	public abstract boolean isCompatible(Attaque carte);
	
	
	public void coupFourre(Joueur joueur) {
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		
		
		/**
		 * Si la botte posé est le contre d'une attaque du jeu du joueur, elle sera retiré.
		 */
		if(this instanceof Prioritaire) {
			if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
				Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileVitesse().remove(0));
			}
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileBataille().remove(0));
				}
			}
		}
		else {
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					Defausse.getInstance().ajouterCarte(joueur.getJeuSurTable().getPileBataille().remove(0));
				}
			}
		}
		
		joueur.getJeuSurTable().addNbKmParcouruBotte( 300);
		
		
		joueur.getJeuEnMain().retirerCarte(this);
		
		/**
		 * Fais piocher le joueur dans le talon pour compenser l'utilisation de sa botte
		 * Le joueur a donc toujours 4 cartes dans sa main.
		 */
		joueur.piocherTalon();
		
		/**
		 * pour que le joueur prenne la main..
		 */
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() - 1); 

		
	}
	
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		return true;
	}
	
}
