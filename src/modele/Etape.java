package modele;

import java.util.*;

import controleur.*;


public class Etape extends Carte {
	
	private int nombreKilometres;

	
	//constructeur
	public Etape (int nombreKilometres){
		this.nombreKilometres = nombreKilometres;
		
	}
	
	//Augmenter le nb de km parcourus 
	/*public void augmenterKmParcourus(){
		/*JeuSurTable jeu=new JeuSurTable();
		this.kmParcourus=jeu.getNbKilometreParcouru()+this.nombreKilometres;//Utile ? Psk quelque chose semblable dans JeuSurTable
		
	}*/
	
	public String toString() {
		return "" + nombreKilometres; 
	}
	
	public int getNombreKilometres(){
		return this.nombreKilometres;
	}

	
}
