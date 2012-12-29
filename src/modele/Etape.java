package modele;

import java.util.*;

import controleur.*;


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
		if( (joueur.getJeuSurTable().getNbKmMax() - joueur.getJeuSurTable().nbKmParcouru() >= this.nbKm) && joueur.getJeuSurTable().isDemarrer()) {
			//Si on ne va pas depasser le nb de km max et que nous avons un feu vert
			if (joueur.getJeuSurTable().getPileVitesse().isEmpty()) { 
				//Si notre pile vitesse est vide l'etape est jouable
				return true;
			} else if(!joueur.getJeuSurTable().getPileVitesse().isEmpty()) {
				//Si notre pile vitesse n'est pas vide
				if(this.nbKm <= LimiteVitesse.getBorneMaxJouable()) {
					return true;
				}
			}
		}
		
		return false;
		
	}

}
