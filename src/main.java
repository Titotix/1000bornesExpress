
import modele.*;
import modele.*;
import controleur.*;

public class main {

	public static void main(String[] args) {
	
		
	Menu menu = Menu.getInstance();
	menu.nouvellePartie();
	menu.creationJoueurs();
	Talon talon = new Talon();
	talon.distribuer();
	
	
	
	}
}
