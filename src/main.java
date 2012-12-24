
import vue.CmdLineInterface;
import modele.*;
import modele.*;
import controleur.*;

public class main {

	public static void main(String[] args) {
	
		
	Menu menu = Menu.getInstance();
	CmdLineInterface cmd = new CmdLineInterface();
	cmd.start();
	Talon talon = Talon.getInstance();
	cmd.afficherJeuDesHumains();
	cmd.afficherJeuDesRobots();
	
	
	
	}
}