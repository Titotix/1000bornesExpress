package carte.bottes;
import tasDeCartes.Carte;
import joueurs.JeuSurTable;
import joueurs.Joueur;
import carte.attaque.Attaque;



public abstract class Botte extends Carte  {
	
	protected int Kilometres;
	
	public abstract boolean isJouableCoupFourre(JeuSurTable notreJeu);

	//constructeur
	public Botte() {
	
	}
	
	public void jouer(Joueur joueur, Joueur inutile) { 
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		//ajouter la carte au jeu sur table du joueur
		
		joueur.getJeuSurTable().addNbKmParcouruBotte(100);
		//jouer une botte augmente de 100 le nb de Km parcouru
		
		/*
		 * Si la botte posé est le contre d'une attaque du jeu du joueur, elle sera retiré.
		 */
		if(this instanceof Prioritaire) {
			if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
				joueur.getJeuSurTable().getPileVitesse().remove(0);
			}
		}
		else {
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					joueur.getJeuSurTable().getPileBataille().remove(0);
				}
			}
		}
		
		
		joueur.getJeuEnMain().retirerCarte(this);
		//retirer la botte de la main du joueur
	}
	
	public abstract boolean isCompatible(Attaque carte);
	
	
	public void coupFourre(Joueur joueur) {
		joueur.getJeuSurTable().ajouterCarteBotte(this);
		//ajouter la carte au jeu sur table du joueur
		
		/*
		 * Si la botte posé est le contre d'une attaque du jeu du joueur, elle sera retiré.
		 */
		if(this instanceof Prioritaire) {
			if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
				joueur.getJeuSurTable().getPileVitesse().remove(0);
			}
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					joueur.getJeuSurTable().getPileBataille().remove(0);
				}
			}
		}
		else {
			if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
				if(this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
					joueur.getJeuSurTable().getPileBataille().remove(0);
				}
			}
		}
		
		joueur.getJeuSurTable().addNbKmParcouruBotte( 300);
		//un coup fourree augmente de 300 le nb de Km parcouru
		
		joueur.getJeuEnMain().retirerCarte(this);
		//retirer la botte de la main du joueur
	
		joueur.piocherTalon();
		//Fais piocher le joueur dans le talon pour compenser l'utilisation de sa botte
		//Le joueur a donc toujours 4 cartes dans sa main.
		

		
	}
	
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		return true;
	}
	
}
