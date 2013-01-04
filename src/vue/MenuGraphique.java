package vue;

import javax.swing.*;

public class MenuGraphique {

	public MenuGraphique() {
		
	
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				try {
					int nbHumain = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer.")) ;				
					
				} catch(NumberFormatException e) {					
					
					int nbHumain = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre total d'humain (en vous comptant) qui vont jouer.")) ;					
				}
				
				try {
					int nbRobot = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
				} catch(NumberFormatException e) {
					int nbRobot = Integer.parseInt(JOptionPane.showInputDialog(null, "Entrez le nombre de joueur géré par l'ordinateur avec qui vous souhaitez jouer.")) ;
					
				}
			}
		});
	}
	
	
	
	
}
