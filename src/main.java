
import vue.CmdLineInterface;
import modele.*;
import modele.*;
import controleur.*;

public class main {

	public static void main(String[] args) {
	
		
	Menu menu = Menu.getInstance();
	CmdLineInterface cmd = new CmdLineInterface();
	cmd.run();
	Talon talon = Talon.getInstance();
	cmd.afficherJeuDesHumains();
	cmd.afficherJeuDesRobots();
	PartieDeJeu partie = new PartieDeJeu();
	partie.jouerPartie();
	cmd.afficherJeuDesHumains();
	cmd.afficherJeuDesRobots();
	
	
	}
}