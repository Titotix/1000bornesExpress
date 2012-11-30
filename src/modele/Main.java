package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Main extends Observable{

	private int nombreCarte;
	private boolean carteJouee;
	private Carte cartes;//TODO Revenir dessus pour faire une collection
	
	public Main (int nombreCarte, boolean carteJouee){
		this.nombreCarte=nombreCarte;
		this.carteJouee=carteJouee;

	}
	
	//Permet d'ajouter une carte apres la pioche
	public void ajouterCarte(){
		
	}
	
	//Permet de retirer une carte de la main apres l'avoir pos�e
	public void retirerCarte (){
		
	}
	
}
