package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Defausse extends TasDeCarte {

	private LinkedList<Carte> pileCarte;
	private static Defausse defausse = null;
	
	//constructeur
	public Defausse (){
		pileCarte = new LinkedList<Carte>();
	}
	
	//singleton
	public static Defausse getInstance() {
		if(defausse == null) {
			defausse = new Defausse();
		}
		return defausse;
	}
	
	
	//Piocher une carte dans la d�fausse
	public Carte piocher(){
		return this.pileCarte.removeFirst();
		
	}
	/**
	 * 
	 * 
	 * @param carte1 : premiere carte a etre defausser
	 * @param carte2 : carte qui restera apparente après le defausse des 2 cartes
	 */
	
	public void ajouter2Carte(Carte carte1, Carte carte2) {
		this.pileCarte.addFirst(carte1);
		this.pileCarte.addFirst(carte2);
		
	}
	
	//Mettre la carte dans la defausse 
	public void ajouterCarte (Carte carte){
		this.pileCarte.addFirst(carte);//Pourquoi un addFirst ici ?  un add serait mieux ?
	}
	
	public boolean isEmpty() {
		return this.pileCarte.isEmpty();
	}
	

	public LinkedList<Carte> getPileCarte() {
		return this.pileCarte;
	}
}
