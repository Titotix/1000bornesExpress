package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Parade extends Carte {
	
	public final static int ROUE_SECOURS=1;
	public final static int FEU_VERT=2;
	public final static int ESSENCE=3;
	public final static int FIN_LIMITE_VITESSE=4;
	public final static int REPARATION=5;
	
	
	//constructeur
	public Parade(){
		
	}
	
	
	//Enum�ration des types de parade accessibles par Parade.TYPE[this.valeur]
	public final static String[] TYPE= {"Roue de secours", "Feu Vert", "Essence","Fin de limite de Vitesse", "Reparation"};
	
	

}
