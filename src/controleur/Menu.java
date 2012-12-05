package controleur;
import java.util.*;

import modele.*;

public class Menu {
	
	private int nbRobot, nbHumain;
	private byte variante;
	private Humain[] humain;
	private Robot[] robot;
	private static Menu menu = null;
	//constructeur
	
	public static Menu getInstance() {
		if(menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	//Cette méthode n'a de raison d'etre que tant qu'on a pas implementer l'interface graphique,
	// c'est la vue qui fera ce travail.
	public void contextuel() {
		int choix;
		System.out.println("Entrer le numero correspondant a ce que vous souhaitez");
		System.out.println("\n 1. Nouvelle partie");
		Scanner a = new Scanner(System.in);
		choix = a.nextInt();
		switch(choix) {
		case 1: this.nouvellePartie();
		break;
		}
	}
	
	
	//Cr�er une nouvelle partie
	public void nouvellePartie (){
		
		this.setNbRobot();
		this.setNbHumain();
		this.creationJoueurs();
		Talon talon = Talon.getInstance();
		this.creerCartes();
		talon.aleatoirePileCarte();
		
		
		
		talon.distribuer();
		
		
	}
	
	public void creationJoueurs() {
		
		String nomJoueur;
		
		humain = new Humain[this.getNbHumain()];
		
		for(int i = 0; i < this.nbHumain; i++) {

			humain[i] =  new Humain(this.getNomHumain(i+1), i+1);
		}

		robot = new Robot[this.getNbRobot()];

		for(int j = 0; j < this.nbRobot; j++) {
			
			robot[j] =  new Robot(this.getNomRobot(j+1), j+1+this.getNbHumain());
		}
	}
	
	/**
	 * Permet la creation des cartes grace aux constructeurs des types
	 * @param 
	 * 
	 */
	public void creerCartes() {
		int i;
		Talon talon = Talon.getInstance();
		//Les attaques
		for (i=1;i<3;i++){
			Attaque crevaison=new Attaque(Attaque.CREVAISON);// Fonctionne avec le i comme ca ? TODO
			talon.getPileCarte().add(crevaison);			
			}
			
		for (i=3;i<5;i++){
			Attaque accident=new Attaque(Attaque.ACCIDENT);
			talon.getPileCarte().add(accident);		
			}
		
		for (i=5;i<7;i++){
			Attaque panneEssence=new Attaque(Attaque.PANNE_ESSENCE);
			talon.getPileCarte().add(panneEssence);			
			}
		
		for (i=7;i<9;i++){
			Attaque limiteVitesse=new Attaque(Attaque.LIMITE_VITESSE);
			talon.getPileCarte().add(limiteVitesse);			
			}
		
		for (i=9;i<11;i++){
			Attaque feuRouge=new Attaque(Attaque.FEU_ROUGE);
			talon.getPileCarte().add(feuRouge);		
			}
		
		//Les parades
		
		for (i=11;i<15;i++){
			Parade roueDeSecours=new Parade(Parade.ROUE_SECOURS);
			talon.getPileCarte().add(roueDeSecours);			
			}
		
		for (i=15;i<19;i++){
			Parade reparation=new Parade(Parade.REPARATION);
			talon.getPileCarte().add(reparation);			
			}
		
		for (i=19;i<23;i++){
			Parade essence=new Parade(Parade.ESSENCE);
			talon.getPileCarte().add(essence);		
			}
		
		for (i=23;i<27;i++){
			Parade finLimiteVitesse=new Parade(Parade.FIN_LIMITE_VITESSE);
			talon.getPileCarte().add(finLimiteVitesse);			
			}
		
		for (i=27;i<32;i++){
			Parade feuVert=new Parade(Parade.FEU_VERT);
			talon.getPileCarte().add(feuVert);			
			}
		
		//Les bottes
		Botte increvable=new Botte(Botte.INCREVABLE);
		talon.getPileCarte().add(increvable);
		Botte asDuVolant=new Botte(Botte.AS_DU_VOLANT);
		talon.getPileCarte().add(asDuVolant);
		Botte prioritaire=new Botte(Botte.PRIORITAIRE);
		talon.getPileCarte().add(prioritaire);
		Botte citerne=new Botte(Botte.CITERNE_ESSENCE);
		talon.getPileCarte().add(citerne);
		
		//Les �tapes
		for (i=36;i<42;i++){
			Etape etape=new Etape(25);
			talon.getPileCarte().add(etape);		
			}
		
		for (i=42;i<48;i++){
			Etape etape=new Etape(50);
			talon.getPileCarte().add(etape);			
			}
		
		for (i=48;i<54;i++){
			Etape etape=new Etape(75);
			talon.getPileCarte().add(etape);			
			}
		
		for (i=54;i<64;i++){
			Etape etape=new Etape(100);
			talon.getPileCarte().add(etape);	
			}
		
		for (i=64;i<67;i++){
			Etape etape=new Etape(200);
			talon.getPileCarte().add(etape);		
			}
		
		//Ce message permet d'avoir la liste de toutes les cartes de la pileCarte
	//System.out.println(talon.getPileCarte().toString()); //TODO ( a virer a l'avenir)
		
		
	}
		

	
	
	
	public String getNomHumain(int i) {
		String nomJoueur;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du joueur numero " + i);
		nomJoueur = clavier.next();
		return nomJoueur;
		
	}
	/**
	 * Génére des noms prédéfini pour les robots
	 * @param i
	 * @return nom de robot
	 */
	public String getNomRobot(int i) {
		String[] nomRobot = new String[6];
		nomRobot[1] = "Gérard";
		nomRobot[2] = "Jeau-Paul";
		nomRobot[3] = "Jeannine";
		nomRobot[4] = "Grégoire";
		nomRobot[5] = "Paulette";
		return nomRobot[i];
		
	}
	
	//D�finir nombre d'IA
	public void setNbRobot (){
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez le nombre d'adversaire géré par l'ordinateur que vous voulez créer.");
		this.nbRobot = clavier.nextInt();
		
		
	}
	
	//D�finir nombre d'humains
	public void setNbHumain (){

		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Entrez le nombre d'adversaire humain avec qui vous allez jouer, en vous incluant vous même.");
		this.nbHumain = clavier2.nextInt();
	}
	
	public int getNbJoueurTotal() {
		return this.nbHumain + this.nbRobot ;
	}
	
	public int getNbHumain() {
		return this.nbHumain;
	}
	
	public int getNbRobot() {
		return this.nbRobot;
	}
	
	public Humain[] getHumain() {
		return this.humain;
	}
	
	public Robot[] getRobot() {
		return this.robot;
	}
	


	
}
