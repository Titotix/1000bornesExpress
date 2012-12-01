package modele;

import java.util.*;

import controleur.*;
import modele.*;

public class Parade extends Carte {
	
	public final static int ROUE_SECOURS=0;
	public final static int FEU_VERT=1;
	public final static int ESSENCE=2;
	public final static int FIN_LIMITE_VITESSE=3;
	public final static int REPARATION=4;
	
	private int type;
	//constructeur
	public Parade(int type){
		this.type = type;
	}
	
	
	//Enum�ration des types de parade accessibles par Parade.TYPE[this.valeur]
	public final static String[] TYPE= {"Roue de secours", "Feu Vert", "Essence","Fin de limite de Vitesse", "Reparation"};
	
	public String toString() {
		return this.TYPE[this.type];
	}

}
