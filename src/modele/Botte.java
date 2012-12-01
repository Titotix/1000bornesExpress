package modele;
import java.util.*;

import controleur.*;


public class Botte extends Carte  {
	
	public final static int INCREVABLE=0;
	public final static int PRIORITAIRE=1;
	public final static int CITERNE_ESSENCE=2;
	public final static int AS_DU_VOLANT=3;
	
	private int type;
	
	//Enum�ration des types de botte accessibles par Botte.TYPE[this.valeur]
	public final static String[] TYPE= {"Increvable", "Prioritaire", "Citerne d'essence", "As du volant"};
	

	//constructeur
	public Botte(int type) {
		this.type=type;
	}
	
	//Augmenter les km lors de la pose d'une botte
	public void augmenterKmParcourus(){
		
	}
	
	public String toString() {
		return this.TYPE[this.type];
	}
	
}
