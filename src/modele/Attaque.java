package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Attaque extends Carte {
	
	public final static int CREVAISON=0;
	public final static int FEU_ROUGE=1;
	public final static int PANNE_ESSENCE=2;
	public final static int LIMITE_VITESSE=3;
	public final static int ACCIDENT=4;
	
	private int type;
	
	
	//Enum�ration des types d'attaque accessibles par Attaque.TYPE[this.valeur]
	public final static String[] TYPE= {"Crevaison", "Feu Rouge", "Panne d'essence","Limite de Vitesse", "Accident"};
	
	
	//constructeur
	public Attaque (int type){
		this.type = type;
		
	}
	
	
	//Appelle la m�thode setEtatBataille du jeu sur table adverse
	public void changeEtatBataille (){
		
	}
	
	public String toString() {
		return this.TYPE[this.type];
	}

}
