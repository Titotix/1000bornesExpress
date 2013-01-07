package vue;

import javax.swing.*;

import jeu.Menu;

public class MenuGraphique {

	public MenuGraphique() {
		int nbHumain = this.choixNbHumain();
		int nbRobot = this.choixNbRobot();
		
		this.setNbHumain(nbHumain);
		this.setNbRobot(nbRobot);
		for(int i=0; i < (nbHumain ) ; i++) {
			this.setNomHumain(this.choixNomHumain(i+1) , i);
	
		}	
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
	
	public String choixNomHumain(int numeroJoueur) {
		try {
			return JOptionPane.showInputDialog(null, "Entrez le nom du joueur numero "+numeroJoueur) ;
			
		} catch(NumberFormatException e) {
			this.choixNomHumain(numeroJoueur);
		}
		return "";
	}
	
	
	///////////// CONTROLEUR /////////////////
	public void setNbHumain(int nbHumain) {
		Menu.getInstance().setNbHumain(nbHumain);
	
	}
	
	public void setNbRobot(int nbRobot) {
		Menu.getInstance().setNbRobot(nbRobot);
	}
	
	public void setNomHumain(String nom, int numeroJoueur) {
		Menu.getInstance().setNoms(nom);
	}
	
	
}
