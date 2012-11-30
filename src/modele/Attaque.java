package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Attaque extends Carte {
	
	public final static int CREVAISON=1;
	public final static int FEU_ROUGE=2;
	public final static int PANNE_ESSENCE=3;
	public final static int LIMITE_VITESSE=4;
	public final static int ACCIDENT=5;
	
	
	
	//Enum�ration des types d'attaque accessibles par Attaque.TYPE[this.valeur]
	public final static String[] TYPE= {"Crevaison", "Feu Rouge", "Panne d'essence","Limite de Vitesse", "Accident"};
	
	
	//constructeur
	public Attaque (String nom, int ID){
		
		
	}
	
	
	//Appelle la m�thode setEtatBataille du jeu sur table adverse
	public void changeEtatBataille (){
		
	}
	

}
