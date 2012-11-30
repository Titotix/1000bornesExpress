import controleur.*;
import modele.*;

public class main {

	public static void main(String[] args) {

		System.out.println("SALUT");
		Menu menu1 = new Menu();
		Talon talon = new Talon();
		System.out.println(talon.nbCarteADistribuer(menu1));
		
		menu1.setNbRobot();
	}
}
