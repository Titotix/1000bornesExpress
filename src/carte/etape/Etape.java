package carte.etape;

import java.util.*;
import tasDeCartes.Carte;
import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.attaque.LimiteVitesse;

/**
 * Represente la carte Etape 
 * On y trouve les nombres de bornes de l'Etape, une méthod epour jouer la carte e tune méthode pour savoir si elle est jouable.
 * @author Damien
 *
 */
public class Etape extends Carte {
	
	private int nbKm;

	public Etape (int nombreKilometres){
		this.nbKm = nombreKilometres;
		
	}
	
	/**
	 * Retourne la valeur de bornes de l'Etape.
	 */
	public String toString() {
		return "" + this.nbKm+" bornes"; 
	}
	/**
	 * Permet d'obtenir la valeur de la carte
	 * @return nbKm
	 */
	public int getNbKm(){
		return this.nbKm;
	}
	
	/**
	 * Permet de poser la carte sur son jeu, de retirer la carte de sa main ainsi que d'indiquer qui est le joueur suivant.
	 * @param joueur
	 * @param inutile
	 * 
	 */
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuSurTable().ajouterCarteEtape(this);
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

	}
	
	/**
	 * Retourne vrai si la carte Etape est jouable sur son propre jeu.
	 * Retourne faux dans le cas contraire.
	 * @param joueur Joueur qui joue l'Etape.
	 * @return boolean
	 */
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		
		PartieDeJeu partie = PartieDeJeu.getInstance();
		/**
		 * Si on ne va pas depasser le nb de km max et que nous avons un feu vert
		 */
		if( (partie.getNbKmMax() - joueur.getJeuSurTable().getNbKmParcouruTotal() >= this.nbKm) && joueur.getJeuSurTable().isDemarrer()) {
			/**
			 * si l'etape qu'on veut jouer est de 200 bornes
			 */
			if(this.nbKm == 200) {
				
				int nbEtape200=0;
				for(Iterator<Etape> it = joueur.getJeuSurTable().getPileEtape().iterator(); it.hasNext() ;) {
					Etape etape = it.next();
					if(etape.nbKm == 200) {
						
						nbEtape200++;
					}
				}
				/**
				 * si ce nombre est sup ou egal a 2, l'etape qu'on voulait poser n'est pas jouable.
				 */
				if(nbEtape200 >= 2) {
					
					return false;
				}
			}
			if(joueur.getJeuSurTable().getPileBataille().isEmpty()) {	
				/**
				 * Si notre pile vitesse est vide l'etape est jouable
				 */
				if (joueur.getJeuSurTable().getPileVitesse().isEmpty()) { 
					
					return true;
				} else {
					
					if(this.nbKm <= LimiteVitesse.getBorneMaxJouable()) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
