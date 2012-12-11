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
		return "" + this.nbKm; 
	}
	
	public int getNbKm(){
		return this.nbKm;
	}
	
	public void jouer(JeuSurTable notreJeu, JeuEnMain jeu, Etape carte){
		notreJeu.ajouterCarteEtape(carte);
		jeu.retirerCarte(carte);
		
	}

	
}
