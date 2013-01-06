package vue;

import javax.swing.*;

import jeu.Menu;

public class MenuGraphique {

	public MenuGraphique() {
		this.setNbHumain(this.choixNbHumain());
		this.setNbRobot(this.choixNbRobot());
			
	}
	
	public int choixNbHumain() {
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer.")) ;				
			
		} catch(NumberFormatException e) {					
			this.choixNbHumain();
		}
		return 0;
	}
	
	public int choixNbRobot() {
		try {
			return Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
		} catch(NumberFormatException e) {
			this.choixNbRobot();
		}
		return 0;
	}
	
	
	///////////// CONTROLEUR /////////////////
	public void setNbHumain(int nbHumain) {
		Menu.getInstance().setNbHumain(nbHumain);
	
	}
	
	public void setNbRobot(int nbRobot) {
		Menu.getInstance().setNbRobot(nbRobot);
	}
	
	
	
	
}
