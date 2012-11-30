package modele;

import java.util.*;

import controleur.*;
import modele.*;


public class Talon extends Observable {
	
	private final int nombreCarteInitial = 66;
	private int nombreCarteADistribuer;
	private int nombreCarteActuel;
	private Carte pileCarte; //TODO
	
	//constructeur
	public Talon (){

	}
	/**
	 * Permet la creation des cartes grace aux constructeurs des types
	 * @param 
	 * 
	 */
	public void creerCartes(){
		int i;
		//Les attaques
		for (i=1;i<3;i++){
			Attaque crevaison=new Attaque("crevaison",i);// Fonctionne avec le i comme ca ? TODO
			}
		
		
		
		for (i=3;i<5;i++){
			Attaque accident=new Attaque("accident",i);
			}
		
		for (i=5;i<7;i++){
			Attaque panneEssence=new Attaque("panneEssence",i);
			}
		
		for (i=7;i<9;i++){
			Attaque limiteVitesse=new Attaque("limiteVitesse",i);
			}
		
		for (i=9;i<11;i++){
			Attaque feuRouge=new Attaque("feuRouge",i);
			}
		
		//Les parades
		
		for (i=11;i<15;i++){
			Parade roueDeSecours=new Parade("roueDeSecours",i);
			}
		
		for (i=15;i<19;i++){
			Parade reparation=new Parade("reparation",i);
			}
		
		for (i=19;i<23;i++){
			Parade essence=new Parade("essence",i);
			}
		
		for (i=23;i<27;i++){
			Parade finLimiteVitesse=new Parade("finLimiteVitesse",i);
			}
		
		for (i=27;i<32;i++){
			Parade feuVert=new Parade("feuVert",i);
			}
		
		//Les bottes
		Botte increvable=new Botte("increvable",33);
		Botte asDuVolant=new Botte("asDuVolant",33);
		Botte prioritaire=new Botte("prioritaire",34);
		Botte citerne=new Botte("citerne",35);
		
		//Les étapes
		for (i=36;i<42;i++){
			Etape etape=new Etape(25,i);
			}
		for (i=42;i<48;i++){
			Etape etape=new Etape(50,i);
			}
		for (i=48;i<54;i++){
			Etape etape=new Etape(75,i);
			}
		for (i=54;i<63;i++){
			Etape etape=new Etape(100,i);
			}
		for (i=63;i<66;i++){
			Etape etape=new Etape(200,i);
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
	
	//Piocher dans le talon
	public Carte piocheTalon(){
		
	}
	

}
