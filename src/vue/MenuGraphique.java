package vue;

import javax.swing.*;

import jeu.Menu;
/**
 * Correspond au menu graphique du debut de partie
 * @author Damien
 *
 */
public class MenuGraphique {

	public MenuGraphique() {
		this.choix();
	}
	/**
	 * Permet le choix et l'affichage du nombre de joueurs
	 */
	public void choix() {
		int nbHumain=0, nbRobot=0;
		try {
			nbHumain = this.choixNbHumain();
			nbRobot = this.choixNbRobot();
			if(nbHumain + nbRobot > 4 || nbHumain + nbRobot <=1) {
				JOptionPane.showMessageDialog(null, "Vous avez rentrer un mauvais nombre de joueurs, le jeu est jouable de 2 et 4 joueurs.");
				throw new NumberFormatException();
			}
			this.setNbHumain(nbHumain);
			this.setNbRobot(nbRobot);
			for(int i=0; i < (nbHumain ) ; i++) {
				this.setNomHumain(this.choixNomHumain(i+1) , i);
		
			}
		} catch (NumberFormatException e) {
			this.choix();
		}
		
	}
	
	public int choixNbHumain() {
		try {
			int nbHumain = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer.")) ;				
			if(nbHumain > 4) {
				JOptionPane.showMessageDialog(null, "Vous avez rentrer trop d'humains. Nombre max de joueur : 4");
				throw new NumberFormatException();
			}
			return nbHumain;
		} catch(NumberFormatException e) {					
			this.choixNbHumain();
		}
		return 0;
	}
	
	public int choixNbRobot() {
		try {
			int nbRobot =  Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
			if(nbRobot > 3) {
				JOptionPane.showMessageDialog(null, "Vous avez rentrer trop de robots. Nombre max de joueur : 4");
				throw new NumberFormatException();
			}
			return nbRobot;
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
	
	
	///////////// CONTROLEUR //////////////////
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
