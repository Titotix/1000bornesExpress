package controleur;

public class Joueur {

	private String nom;
	private int numeroPassage;
	/** 
	 * TODO
	 * Creer une partie
	 * Piocher(prendre une carte dans le talon/Defausse
	 * Choix de la carte � poser (parmis la main)
	 * Poser une carte sur son jeu
	 * Attaquer (poser une carte sur le jeu adverse)
	 * D�fausser(poser une carte dans la defausse)
	 * Choisir une cible
	 * Sortir la carte Botte qui convient
	 * 
	 * 
	 */

	
	//constructeur
	public Joueur (String nomJoueur, int numPassage){
		this.nom=nomJoueur;
		this.numeroPassage=numPassage;
	}
	
	
	//Le choix de la carte
	public void choixCarte (){
		
	}

	//Pour commencer � attaquer
	public void attaquer (){
		
	}
	
	
	//Pour l'attaque autre que limite de vitesse
	public void poseCarteAttaque(){
		
	}
	
	
	//Pour la limite de vitesse
	public void poseLimiteVitesse (){
		
	}
	
	
	//Pour la parade
	public void parade (){
		
	}
	
	//Pour avancer
	public void parcourir (){
		
	}
	
	//Pour d�marrer
	public void feuVertInitial (){
		
	}
	
	//Pour finir son tour et que ce soit au joueur suivant
	public void joueurSuivant (){
		
	}
	
	
}
