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
	
	
	//Enum�ration des types de parade accessibles par Parade.TYPE[this.type]
	public final static String[] TYPE= {"Roue de secours", "Feu Vert", "Essence","Fin de limite de Vitesse", "Reparation"};
	
	/**En utilisant les memes association int/string des constantes définies, on renvoie ici un string correspondant au type de parade.
	 * 
	 * 
	 * @return type de la parade
	 */
	public String getType() {
		
		if (this.type == 0) {
			return "ROUE_SECOURS";
		}
		else if (this.type == 1) {
			return "FEU_VERT";
		}
		else if (this.type == 2) {
			return "ESSENCE";
		}
		else if (this.type == 3) {
			return "FIN_LIMITE_VITESSE";
		}
		else if (this.type == 4) {
			return "REPARATION";
		}
		else {
			return "ERROR";
		}
	}
	
	public String toString() {
		return this.TYPE[this.type];
	}

}
