
import jeu.Menu;
import jeu.PartieDeJeu;
import tasDeCartes.Talon;
import vue.CmdLineInterface;
import vue.MenuGraphique;


public class main {

	public static void main(String[] args) {
	
	MenuGraphique menuGui = new MenuGraphique();
	Menu menu = Menu.getInstance();
	CmdLineInterface cmd = new CmdLineInterface();
	cmd.run();
	Talon talon = Talon.getInstance();
	cmd.afficherJeuDesHumains();
	cmd.afficherJeuDesRobots();
	PartieDeJeu partie = PartieDeJeu.getInstance();
	partie.jouerPartie();
	
	}
}