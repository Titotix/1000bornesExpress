package jeu;
import java.util.*;

import joueurs.Humain;
import joueurs.Joueur;
import joueurs.Robot;


import strategie.AggressifMeilleurJoueur;
import strategie.AggressifTousJoueurs;
import strategie.Strategy;
import strategie.Vitesse;
import tasDeCartes.Talon;

import carte.attaque.Accident;
import carte.attaque.Crevaison;
import carte.attaque.FeuRouge;
import carte.attaque.LimiteVitesse;
import carte.attaque.PanneEssence;
import carte.bottes.AsDuVolant;
import carte.bottes.CiterneEssence;
import carte.bottes.Increvable;
import carte.bottes.Prioritaire;
import carte.etape.Etape;
import carte.parade.Essence;
import carte.parade.FeuVert;
import carte.parade.FinLimiteVitesse;
import carte.parade.Reparation;
import carte.parade.RoueSecours;

public class Menu {
	

	private int nbRobot, nbHumain;

	private LinkedList<Humain> humain;
	private LinkedList<Robot> robot;
	private static Menu menu = null;
	//constructeur
	private Menu() {
		
	}
	public static Menu getInstance() {
		if(menu == null) {
			menu = new Menu();
		}
		return menu;
	}
	
	
	//Creer une nouvelle partie
	public void nouvellePartie () {
		this.nbRobot=3; //TODO A VIRER
		this.creationJoueurs();
		Talon talon = Talon.getInstance();
		this.creerCartes();
		talon.aleatoirePileCarte();
	
		talon.distribuer();
	}
	
	public void creationJoueurs() {
		
		
		humain = new LinkedList<Humain>();
		
		for(int i = 0; i < this.nbHumain; i++) {

			humain.add(new Humain(this.getNomHumain(i+1), i+1));
		}

		robot = new LinkedList<Robot>();

		for(int j = 0; j < this.nbRobot; j++) {
			
			robot.add ( new Robot ( this.getNomRobot(j+1), j+1+this.getNbHumain(), this.getRandomStrategy() ) );
		}
	}
	
	
	
	public Strategy getRandomStrategy() {
		Random r = new Random();
		int i = r.nextInt(3);
		if(i==1) {
			return new Vitesse();
		} else if (i==2) {
			return new AggressifTousJoueurs();
		} else {
			return new AggressifMeilleurJoueur();
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
			Crevaison crevaison=new Crevaison();// Fonctionne avec le i comme ca ? TODO
			talon.getPileCarte().add(crevaison);			
			}
			
		for (i=3;i<5;i++){
			Accident accident=new Accident();
			talon.getPileCarte().add(accident);		
			}
		
		for (i=5;i<7;i++){
			PanneEssence panneEssence=new PanneEssence();
			talon.getPileCarte().add(panneEssence);			
			}
		
		for (i=7;i<9;i++){
			LimiteVitesse limiteVitesse=new LimiteVitesse();
			talon.getPileCarte().add(limiteVitesse);			
			}
		
		for (i=9;i<11;i++){
			FeuRouge feuRouge=new FeuRouge();
			talon.getPileCarte().add(feuRouge);		
			}
		
		//Les parades
		
		for (i=11;i<15;i++){
			RoueSecours roueDeSecours=new RoueSecours();
			talon.getPileCarte().add(roueDeSecours);			
			}
		
		for (i=15;i<19;i++){
			Reparation reparation=new Reparation();
			talon.getPileCarte().add(reparation);			
			}
		
		for (i=19;i<23;i++){
			Essence essence=new Essence();
			talon.getPileCarte().add(essence);		
			}
		
		for (i=23;i<27;i++){
			FinLimiteVitesse finLimiteVitesse=new FinLimiteVitesse();
			talon.getPileCarte().add(finLimiteVitesse);			
			}
		
		for (i=27;i<32;i++){
			FeuVert feuVert=new FeuVert();
			talon.getPileCarte().add(feuVert);			
			}
		
		//Les bottes
		Increvable increvable=new Increvable();
		talon.getPileCarte().add(increvable);
		
		AsDuVolant asDuVolant=new AsDuVolant();
		talon.getPileCarte().add(asDuVolant);
		
		Prioritaire prioritaire=new Prioritaire();
		talon.getPileCarte().add(prioritaire);
		
		CiterneEssence citerne=new CiterneEssence();
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
		
		
	}
		

	
	
	public String getNomHumain(int i) { //TODO a virer
		String nomJoueur;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du joueur numero " + i);
		nomJoueur = clavier.next();
		return nomJoueur;
		
	}
	/**
	 * Génére des noms prédéfinis pour les robots
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
	public void setNbRobot (int nbRobot){ 
		this.nbRobot = nbRobot;
	}
	
	//D�finir nombre d'humains
	public void setNbHumain (int nbHumain){ 

		this.nbHumain = nbHumain;
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
	
	public LinkedList<Humain> getHumain() {
		return this.humain;
	}
	
	public LinkedList<Robot> getRobot() {
		return this.robot;
	}
	

	public LinkedList<Joueur> getJoueurs() {
		LinkedList<Joueur> joueur = new LinkedList<Joueur>();
		joueur.addAll(menu.getHumain());
		joueur.addAll(menu.getRobot());
		return joueur;
	}
}