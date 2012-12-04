package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Defausse extends Observable {

	private LinkedList<Carte> pileCarte;
	private static Defausse defausse = null;
	
	//constructeur
	public Defausse (){
		pileCarte = new LinkedList<Carte>();
	}
	
	
	//constructeur
	
	public static Defausse getInstance() {
		if(defausse == null) {
			defausse = new Defausse();
		}
		return defausse;
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
	

	public LinkedList<Carte> getPileCarte() {
		return this.pileCarte;
	}
}
