package carte.etape;

import java.util.*;

import tasDeCartes.Carte;

import jeu.PartieDeJeu;

import joueurs.Joueur;


import carte.attaque.LimiteVitesse;
/**
 * Represente la carte Etape 
 * On y trouve les valeurs des cartes etapes, les booleens precisant si elle est jouable en coup fourré et quelle attaque elle bloque
 * et la methode permettant d'obtenir le nombre de km
 * @author Damien
 *
 */
public class Etape extends Carte {
	
	private int nbKm;

	
	
	public Etape (int nombreKilometres){
		this.nbKm = nombreKilometres;
		
	}
	
	
	/**
	 * Affiche la valeur de la carte et "bornes"
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
	 * Permet de poser la carte au bon endroit
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
	 * On verifie qu'on ne depasse pas le nombre de km max, que on joue 2 carte de 200 maximum et on peut ainsi verifier si 
	 * la carte est jouable
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
