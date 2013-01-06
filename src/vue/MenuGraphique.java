package vue;

import javax.swing.*;

import jeu.Menu;

public class MenuGraphique {

	public MenuGraphique() {
			
			try {
				//this.setNbHumain(Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer."))) ;				
				
			} catch(NumberFormatException e) {					
				
				int nbHumain = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer.")) ;					
			}
			
			try {
				int nbRobot = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
			} catch(NumberFormatException e) {
				int nbRobot = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
				
			}
		}
	
	
	
	
	///////////// CONTROLEUR /////////////////
	public void setNbHumain(int nbHumain) {
		Menu.getInstance().setNbHumain(nbHumain);
	}
	
	public void setNbRobot(int nbRobot) {
		Menu.getInstance().setNbHumain(nbRobot);
	}
	
	
	
	
}
