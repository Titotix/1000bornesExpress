package modele;
import java.util.*;

import controleur.*;
import modele.*;

public class Botte extends Carte  {
	
	public final static int INCREVABLE=1;
	public final static int PRIORITAIRE=2;
	public final static int CITERNE_ESSENCE=3;
	public final static int AS_DU_VOLANT=4;
	
	
	
	//Enum�ration des types de botte accessibles par Botte.TYPE[this.valeur]
	public final static String[] TYPE= {"Increvable", "Prioritaire", "Citerne d'essence", "As du volant"};
	

	//constructeur
	public Botte() {
		
	}
	
	//Augmenter les km lors de la pose d'une botte
	public void augmenterKmParcourus(){
		
	}
	
}
