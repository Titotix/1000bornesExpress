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
	public void augmenterKmParcourus(){
		
	}
	
	public String toString() {
		return "" + nombreKilometres; 
	}
	

}
