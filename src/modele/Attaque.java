package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Attaque extends Carte {
	
	
	//constructeur
	public Attaque (){
		
		
	}
	
	public void jouer(JeuSurTable jeuAdverse, JeuEnMain jeu, Attaque carte){
		
		jeuAdverse.ajouterCarteBataille(carte);
		jeu.retirerCarte(carte);
		
	}
	
	
	//Appelle la m�thode setEtatBataille du jeu sur table adverse
	public void changeEtatBataille (){
		
	}
	
	
}
