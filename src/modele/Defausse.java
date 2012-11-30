package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Defausse extends Observable {

	private int nombreCarteActuel;
	private Carte pileCarte;
	
	//constructeur
	public Defausse (int nbCarte, Carte pileCarte){
		this.nombreCarteActuel=nbCarte;
		this.pileCarte=pileCarte;
	}
	
	
	//Piocher une carte dans la d�fausse
	public void piocherDefausse (){
		
	}
	
	
	//Enlever la carte de la defausse (quand elle est pioch�e)
	public void retirerCarte (){
		
	}
	
	//Mettre la carte dans la defausse 
	public void ajouterCarte (){
		
	}

	//Mettre la carte accident dans la d�fausse
	public void defausseAccident(){
		
	}
	
	//Mettre la carte Repa dans la defausse
	public void defausseReparation(){
		
	}
	
	
}
