package carte.etape;

import java.util.*;

import tasDeCartes.Carte;

import jeu.PartieDeJeu;

import joueurs.Joueur;


import carte.attaque.LimiteVitesse;

public class Etape extends Carte {
	
	private int nbKm;

	
	//constructeur
	public Etape (int nombreKilometres){
		this.nbKm = nombreKilometres;
		
	}
	
	//Augmenter le nb de km parcourus 
	/*public void augmenterKmParcourus(){
		/*JeuSurTable jeu=new JeuSurTable();
		this.kmParcourus=jeu.getNbKilometreParcouru()+this.nombreKilometres;//Utile ? Psk quelque chose semblable dans JeuSurTable
		
	}*/
	
	public String toString() {
		return "" + this.nbKm+" bornes"; 
	}
	
	public int getNbKm(){
		return this.nbKm;
	}
	
	public void jouer(Joueur joueur, Joueur inutile) {
		joueur.getJeuSurTable().ajouterCarteEtape(this);
		joueur.getJeuEnMain().retirerCarte(this);
		
	}
	
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		
		PartieDeJeu partie = PartieDeJeu.getInstance();
		if( (partie.getNbKmMax() - joueur.getJeuSurTable().nbKmParcouru() >= this.nbKm) && joueur.getJeuSurTable().isDemarrer()) {
			//Si on ne va pas depasser le nb de km max et que nous avons un feu vert
			if(this.nbKm == 200) {
				//si l'etape qu'on veut jouer est de 200 bornes
				int nbEtape200=0;
				for(Iterator<Etape> it = joueur.getJeuSurTable().getPileEtape().iterator(); it.hasNext() ;) {
					Etape etape = it.next();
					if(etape.nbKm == 200) {
						//On compte le nombre d'etape de 200 bornes dans le jeu
						nbEtape200++;
					}
				}
				if(nbEtape200 >= 2) {
					//si ce nombre est sup ou egal a 2, l'etape qu'on voulait poser n'est pas jouable.
					return false;
				}
			}
			if(joueur.getJeuSurTable().getPileBataille().isEmpty()) {	
				if (joueur.getJeuSurTable().getPileVitesse().isEmpty()) { 
					//Si notre pile vitesse est vide l'etape est jouable
					return true;
				} else {
					//Si notre pile vitesse n'est pas vide
					if(this.nbKm <= LimiteVitesse.getBorneMaxJouable()) {
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
