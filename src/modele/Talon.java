package modele;

import java.util.*;

import controleur.*;
import modele.*;


public class Talon extends Observable {
	
	private final int nombreCarteInitial = 66;
	private int nombreCarteADistribuer;
	private int nombreCarteActuel;
	private Carte pileCarte; //TODO
	
	//constructeur
	public Talon (){

	}
	
	/**
	 * Calcul du nombre de cartes a distribuer
	 * @param menu
	 * @return nombre de carte a distribuer au total
	 */
	public int nbCarteADistribuer(Menu menu){
	
		return menu.getNbJoueurTotal() * 4; 
	}
	
	//Trier les cartes al�atoirement
	public void aleatoirePileCarte(){
		
	}
	
	//Distribuer les cartes depuis le talon
	public void distribuer(){
		
	}
	
	//Piocher dans le talon
	public Carte piocheTalon(){
		
	}
	

}
