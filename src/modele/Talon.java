package modele;

import java.util.*;

import controleur.*;
import modele.*;


public class Talon extends Observable {
	
	private final int nombreCarteInitial = 66;
	private int nombreCarteADistribuer;
	private int nombreCarteActuel;
	private static LinkedList<Carte> pileCarte; //TODO
	
	//constructeur
	public Talon (){
		pileCarte=new LinkedList<Carte>();
		this.creerCartes();
		
		

	}
	/**
	 * Permet la creation des cartes grace aux constructeurs des types
	 * @param 
	 * 
	 */
	public static void creerCartes(){
		int i;
		//Les attaques
		System.out.println("Pour attaque :");
		for (i=1;i<3;i++){
			Attaque crevaison=new Attaque("crevaison",i);// Fonctionne avec le i comme ca ? TODO
			pileCarte.add(crevaison);
			
			}
		
		
		
		for (i=3;i<5;i++){
			Attaque accident=new Attaque("accident",i);
			pileCarte.add(accident);
			
			}
		
		for (i=5;i<7;i++){
			Attaque panneEssence=new Attaque("panneEssence",i);
			pileCarte.add(panneEssence);
			
			}
		
		for (i=7;i<9;i++){
			Attaque limiteVitesse=new Attaque("limiteVitesse",i);
			pileCarte.add(limiteVitesse);
			
			}
		
		for (i=9;i<11;i++){
			Attaque feuRouge=new Attaque("feuRouge",i);
			pileCarte.add(feuRouge);
		
			}
		
		//Les parades
		
		System.out.println("Pour parades");
		for (i=11;i<15;i++){
			Parade roueDeSecours=new Parade("roueDeSecours",i);
			pileCarte.add(roueDeSecours);
			
			}
		
		for (i=15;i<19;i++){
			Parade reparation=new Parade("reparation",i);
			pileCarte.add(reparation);
			
			}
		
		for (i=19;i<23;i++){
			Parade essence=new Parade("essence",i);
			pileCarte.add(essence);
			
			}
		
		for (i=23;i<27;i++){
			Parade finLimiteVitesse=new Parade("finLimiteVitesse",i);
			pileCarte.add(finLimiteVitesse);
			
			}
		
		for (i=27;i<32;i++){
			Parade feuVert=new Parade("feuVert",i);
			pileCarte.add(feuVert);
			
			}
		
		//Les bottes
		Botte increvable=new Botte("increvable",33);
		pileCarte.add(increvable);
		Botte asDuVolant=new Botte("asDuVolant",33);
		pileCarte.add(asDuVolant);
		Botte prioritaire=new Botte("prioritaire",34);
		pileCarte.add(prioritaire);
		Botte citerne=new Botte("citerne",35);
		pileCarte.add(citerne);
		
		//Les étapes
		System.out.println("Pour etapes");
		for (i=36;i<42;i++){
			Etape etape=new Etape(25,i);
			pileCarte.add(etape);
		
			}
		for (i=42;i<48;i++){
			Etape etape=new Etape(50,i);
			pileCarte.add(etape);
			
			}
		for (i=48;i<54;i++){
			Etape etape=new Etape(75,i);
			pileCarte.add(etape);
			
			}
		for (i=54;i<64;i++){
			Etape etape=new Etape(100,i);
			pileCarte.add(etape);
		
			}
		for (i=64;i<67;i++){
			Etape etape=new Etape(200,i);
			pileCarte.add(etape);
			
			}
		
		
	}
	
	/**
	 * Calcul du nombre de cartes a distribuer
	 * @param menu
	 * @return nombre de carte a distribuer au total
	 */
	public int nbCarteADistribuer(Menu menu){
	
		return menu.getNbJoueurTotal() * 4; 
	}
	
	//Trier les cartes alï¿½atoirement
	public void aleatoirePileCarte(){
		
	}
	
	//Distribuer les cartes depuis le talon
	public void distribuer(){
		
	}
	
	/*//Piocher dans le talon
	public Carte piocheTalon(){
		
	}*/
	

}
