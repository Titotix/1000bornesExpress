package vue;


import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

import carte.attaque.*;
import carte.bottes.*;
import carte.etape.*;

import tasDeCartes.Carte;
import tasDeCartes.Defausse;

import jeu.Menu;
import joueurs.*;
import jeu.*;
public class FenetrePrincipale extends JFrame implements Observer{
	
	
	private int nbJoueurs;
	private String nom;
	private Carte carteSelectionnee;
	private static FenetrePrincipale fenetre = null;
	private Controleur controleur = Controleur.getInstance();
	
	
	//Variables pour le Joueur 1
	private JButton etapeJ1=new JButton("Etape");
	private JButton attaqueJ1=new JButton("Attaque");
	private JButton limiteJ1=new JButton("Limite de vitesse");
	private JButton botteJ1=new JButton("Bottes");
	private JLabel kmJ1=new JLabel("Bornes:");
	private JLabel bottePossJ1=new JLabel("Bottes :");
	private JLabel isAttaqueJ1=new JLabel("Pile Bataille");
	private JLabel isLimiteJ1=new JLabel("Pile Limite");
	
	//Variables Joueur 2
	private JButton etapeJ2=new JButton("Etape");
	private JButton attaqueJ2=new JButton("Attaque");
	private JButton limiteJ2=new JButton("Limite de vitesse");
	private JButton botteJ2=new JButton("Bottes");
	private JLabel kmJ2=new JLabel("Bornes:");
	private JLabel bottePossJ2=new JLabel("Bottes :");
	private JLabel isAttaqueJ2=new JLabel("Pile Bataille");
	private JLabel isLimiteJ2=new JLabel("Pile Limite");
	
	//Variables Joueur 3
	private JButton etapeJ3=new JButton("Etape");
	private JButton attaqueJ3=new JButton("Attaque");
	private JButton limiteJ3=new JButton("Limite de vitesse");
	private JButton botteJ3=new JButton("Bottes");
	private JLabel kmJ3=new JLabel("Bornes:");
	private JLabel bottePossJ3=new JLabel("Bottes :");
	private JLabel isAttaqueJ3=new JLabel("Pile Bataille");
	private JLabel isLimiteJ3=new JLabel("Pile Limite");
	
	//Variables Joueur 4
	private JButton etapeJ4=new JButton("Etape");
	private JButton attaqueJ4=new JButton("Attaque");
	private JButton limiteJ4=new JButton("Limite de vitesse");
	private JButton botteJ4=new JButton("Bottes");
	private JLabel kmJ4=new JLabel("Bornes:");
	private JLabel bottePossJ4=new JLabel("Bottes :");
	private JLabel isAttaqueJ4=new JLabel("Pile Bataille");
	private JLabel isLimiteJ4=new JLabel("Pile Limite");
	
	//Variables cartes en main
	private JInternalFrame carte1 = new JInternalFrame(); 
	private JButton carte1Joueur=new JButton("Selectionner");
	private JInternalFrame carte2 = new JInternalFrame(); 
	private JButton carte2Joueur=new JButton("Selectionner");
	private JInternalFrame carte3 = new JInternalFrame(); 
	private JButton carte3Joueur=new JButton("Selectionner");
	private JInternalFrame carte4 = new JInternalFrame(); 
	private JButton carte4Joueur=new JButton("Selectionner");
	private JInternalFrame carte5 = new JInternalFrame(); 
	private JButton carte5Joueur=new JButton("Selectionner");
	
	//Variables talon/defausse/evenements
	private JButton talonBouton=new JButton("Piocher");
	private JButton defausseBouton=new JButton("Piocher/Defausser");
	private JLabel eventLabel = new JLabel("Ici les evenements");
	
	private JInternalFrame talon = new JInternalFrame(); 
	private JInternalFrame defausse = new JInternalFrame(); 
    
	
	Box b1 = Box.createHorizontalBox();
	
	
	public static FenetrePrincipale getInstance() {
		if(fenetre == null) {
			fenetre = new FenetrePrincipale();
		}
		return fenetre;
	}
	
  private FenetrePrincipale(){
	  this.carteSelectionnee = null;
	  this.setTitle("1000 Bornes EXPRESS");
	  this.setSize(1366, 768);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);

	  nbJoueurs=Menu.getInstance().getNbJoueurTotal();
    
   
    if (nbJoueurs==2){

    //On crée un conteneur avec gestion horizontale pour les joueurs
    
    JInternalFrame joueur1 = new JInternalFrame(); 
    joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    
    nom=controleur.getJoueurs().get(0).getNom();
    
	joueur1.setTitle(nom);
	joueur1.setVisible(true);//On la rend visible
	joueur1.setLayout(new GridLayout(4, 2));//Quadrillage pour les tas du joueur
	
		
	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
	etapeJ1.addActionListener(new ActionListener(){
		public synchronized void actionPerformed(ActionEvent event){
			//TODO
			if (carteSelectionnee != null){
				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
				} else {
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			} else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	
	
	joueur1.add (etapeJ1);
	
	
	
	attaqueJ1.addActionListener(new ActionListener(){
		public synchronized void actionPerformed(ActionEvent event){
				if (carteSelectionnee!=null){
					if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
						controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
			
			
			
		}
	});
	joueur1.add(attaqueJ1);
	
	
	
	
	limiteJ1.addActionListener(new ActionListener(){
		public synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur1.add(limiteJ1);
	
	
	
	botteJ1.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de bottes du premier joueur");
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur1.add(botteJ1);
	
	
	joueur1.add(kmJ1);
	joueur1.add(bottePossJ1);
	joueur1.add(isAttaqueJ1);
	joueur1.add(isLimiteJ1);
	
	// On ajoute le joueur a la box horizontale
	b1.add(joueur1);
	
	/////////
	JInternalFrame joueur2 = new JInternalFrame(); 
	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(1).getNom();
	joueur2.setTitle(nom);
	joueur2.setVisible(true);//On la rend visible
	joueur2.setLayout(new GridLayout(4, 2));
	
	
	etapeJ2.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur2.add (etapeJ2);
	
	
	attaqueJ2.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez pose la carte sur le tas d'attaque du deuxieme joueur");
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur2.add(attaqueJ2);
	
	
	limiteJ2.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez pose la carte sur le tas de limite de vitesse du deuxieme joueur");
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur2.add(limiteJ2);
	
	
	botteJ2.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez pose la carte sur le tas de bottes du deuxieme joueur");
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur2.add(botteJ2);
	
	
	joueur2.add(kmJ2);
	joueur2.add(bottePossJ2);
	joueur2.add(isAttaqueJ2);
	joueur2.add(isLimiteJ2);
	
	b1.add(joueur2);
    }
	
    else if (nbJoueurs==3){
    	
    	
    	 //On crée un conteneur avec gestion horizontale pour les joueurs
        
        JInternalFrame joueur1 = new JInternalFrame(); 
        joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
        nom=controleur.getJoueurs().get(0).getNom();
    	joueur1.setTitle(nom);
    	joueur1.setVisible(true);//On la rend visible
    	joueur1.setLayout(new GridLayout(4, 2));//Quadrillage pour les tas du joueur
    	
    		
    	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
    	etapeJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add (etapeJ1);
    	
    	
    	
    	attaqueJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add(attaqueJ1);
    	
    	
    	
    	
    	limiteJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    				if (carteSelectionnee!=null){
    					if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    						controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;    		}
    	});
    	joueur1.add(limiteJ1);
    	
    	
    	
    	botteJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add(botteJ1);
    	
    	
    	joueur1.add(kmJ1);
    	joueur1.add(bottePossJ1);
    	joueur1.add(isAttaqueJ1);
    	joueur1.add(isLimiteJ1);
    	
    	// On ajoute le joueur a la box horizontale
    	b1.add(joueur1);
    	
    	/////////
    	JInternalFrame joueur2 = new JInternalFrame(); 
    	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    	nom=controleur.getJoueurs().get(1).getNom();
    	joueur2.setTitle(nom);
    	joueur2.setVisible(true);//On la rend visible
    	joueur2.setLayout(new GridLayout(4, 2));
    	
    	
    	etapeJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add (etapeJ2);
    	
    	
    	attaqueJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(attaqueJ2);
    	
    	
    	limiteJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(limiteJ2);
    	
    	
    	botteJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(botteJ2);
    	
    	
    	joueur2.add(kmJ2);
    	joueur2.add(bottePossJ2);
    	joueur2.add(isAttaqueJ2);
    	joueur2.add(isLimiteJ2);
    	
    	b1.add(joueur2);
    
    /////////
	JInternalFrame joueur3 = new JInternalFrame(); 
	joueur3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(2).getNom();
	joueur3.setTitle(nom);
	joueur3.setVisible(true);//On la rend visible
	joueur3.setLayout(new GridLayout(4, 2));
	
	
	etapeJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add (etapeJ3);
	
	
	attaqueJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
				if (carteSelectionnee!=null){
				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
					}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(attaqueJ3);
	
	
	limiteJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(limiteJ3);
	
	
	botteJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(botteJ3);
	
	
	joueur3.add(kmJ3);
	joueur3.add(bottePossJ3);
	joueur3.add(isAttaqueJ3);
	joueur3.add(isLimiteJ3);
	
	b1.add(joueur3);
	
    }
    
    else if (nbJoueurs == 4){
    	
    	//On crée un conteneur avec gestion horizontale pour les joueurs
       
        JInternalFrame joueur1 = new JInternalFrame(); 
        joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
        nom=controleur.getJoueurs().get(0).getNom();
    	joueur1.setTitle(nom);
    	joueur1.setVisible(true);//On la rend visible
    	joueur1.setLayout(new GridLayout(4, 2));//Quadrillage pour les tas du joueur
    	
    		
    	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
    	etapeJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add (etapeJ1);
    	
    	
    	
    	attaqueJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    					}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add(attaqueJ1);
    	
    	
    	
    	
    	limiteJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add(limiteJ1);
    	
    	
    	
    	botteJ1.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(0), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur1.add(botteJ1);
    	
    	
    	joueur1.add(kmJ1);
    	joueur1.add(bottePossJ1);
    	joueur1.add(isAttaqueJ1);
    	joueur1.add(isLimiteJ1);
    	
    	// On ajoute le joueur a la box horizontale
    	b1.add(joueur1);
    	
    	/////////
    	JInternalFrame joueur2 = new JInternalFrame(); 
    	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    	nom=controleur.getJoueurs().get(1).getNom();
    	joueur2.setTitle(nom);
    	joueur2.setVisible(true);//On la rend visible
    	joueur2.setLayout(new GridLayout(4, 2));
    	
    	
    	etapeJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    		
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add (etapeJ2);
    	
    	
    	attaqueJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(attaqueJ2);
    	
    	
    	limiteJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(limiteJ2);
    	
    	
    	botteJ2.addActionListener(new ActionListener(){
    		public  synchronized void actionPerformed(ActionEvent event){
    			if (carteSelectionnee!=null){
    				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee)==true){
    					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(1), carteSelectionnee);
    				}
    				else{
    					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
    					}
    			}
    			else {
    				eventLabel.setText("Il faut selectionner une carte");
    			
    			}
    			carteSelectionnee=null;
    		}
    	});
    	joueur2.add(botteJ2);
    	
    	
    	joueur2.add(kmJ2);
    	joueur2.add(bottePossJ2);
    	joueur2.add(isAttaqueJ2);
    	joueur2.add(isLimiteJ2);
    	
    	b1.add(joueur2);
    
    /////////
	JInternalFrame joueur3 = new JInternalFrame(); 
	joueur3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(2).getNom();
	joueur3.setTitle(nom);
	joueur3.setVisible(true);//On la rend visible
	joueur3.setLayout(new GridLayout(4, 2));
	
	
	etapeJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add (etapeJ3);
	
	
	attaqueJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(attaqueJ3);
	
	
	limiteJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(limiteJ3);
	
	
	botteJ3.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(2), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur3.add(botteJ3);
	
	
	joueur3.add(kmJ3);
	joueur3.add(bottePossJ3);
	joueur3.add(isAttaqueJ3);
	joueur3.add(isLimiteJ3);
	
	b1.add(joueur3);
	
	///////////
	JInternalFrame joueur4 = new JInternalFrame(); 
	joueur4.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(3).getNom();
	joueur4.setTitle(nom);
	joueur4.setVisible(true);//On la rend visible
	joueur4.setLayout(new GridLayout(4, 2));
	
	
	etapeJ4.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurEtape(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur4.add (etapeJ4);
	
	
	attaqueJ4.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurAttaque(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur4.add(attaqueJ4);
	
	
	limiteJ4.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurLimiteVitesse(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur4.add(limiteJ4);
	
	
	botteJ4.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if (carteSelectionnee!=null){
				if (controleur.isPosableSurBotte(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee)==true){
					controleur.jouer(controleur.getJoueurActuel(),controleur.getJoueurs().get(3), carteSelectionnee);
				}
				else{
					eventLabel.setText("La carte ne se pose pas la, re-selectionnez une carte");
					}
			}
			else {
				eventLabel.setText("Il faut selectionner une carte");
			
			}
			carteSelectionnee=null;
		}
	});
	joueur4.add(botteJ4);
	
	
	joueur4.add(kmJ4);
	joueur4.add(bottePossJ4);
	joueur4.add(isAttaqueJ4);
	joueur4.add(isLimiteJ4);
	
	b1.add(joueur4);
	
    }
    
    //Idem pour les cartes en main du joueur qui joue
    
    Box b2 = Box.createHorizontalBox();
    
  
	carte1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte1.setTitle("Carte 1");
	carte1.setVisible(true);//On la rend visible
	
	
	carte1Joueur.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.hasPioche(controleur.getJoueurActuel()) ){
					eventLabel.setText("Vous avez choisi la premiere carte");
					carteSelectionnee=controleur.getMain(controleur.getJoueurActuel()).get(0);
				
				} else {
					eventLabel.setText("Vous devez piochez avant de sélectionner une carte.");
					
				}
			} else {
				eventLabel.setText("Ce n'est pas votre tour."); 
				
			}
		}
	});
	carte1.add(carte1Joueur);
	b2.add(carte1);
	
	
	carte2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte2.setTitle("Carte 2");
	carte2.setVisible(true);//On la rend visible
	
	
	carte2Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.hasPioche(controleur.getJoueurActuel()) ){
					eventLabel.setText("Vous avez choisi la seconde carte");
					carteSelectionnee=controleur.getMain(controleur.getJoueurActuel()).get(1);
				
				} else {
					eventLabel.setText("Vous devez piochez avant de sélectionner une carte.");
					
				}
			} else {
				eventLabel.setText("Ce n'est pas votre tour."); 
			}
		}
	});
	
	carte2.add(carte2Joueur);
	b2.add(carte2);
	
	
	carte3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte3.setTitle("Carte 3");
	carte3.setVisible(true);//On la rend visible

	
	carte3Joueur.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.hasPioche(controleur.getJoueurActuel()) ){
					eventLabel.setText("Vous avez choisi la troisième carte");
					carteSelectionnee=controleur.getMain(controleur.getJoueurActuel()).get(2);
				
				} else {
					eventLabel.setText("Vous devez piochez avant de sélectionner une carte.");
					
				}
			} else {
				eventLabel.setText("Ce n'est pas votre tour."); 
			}
		}
	});
	carte3.add(carte3Joueur);
	b2.add(carte3);
	
	
	carte4.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte4.setTitle("Carte 4");
	carte4.setVisible(true);//On la rend visible
	
	
	carte4Joueur.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.hasPioche(controleur.getJoueurActuel()) ){
					eventLabel.setText("Vous avez choisi la quatrième carte");
					carteSelectionnee=controleur.getMain(controleur.getJoueurActuel()).get(3);
				
				} else {
					eventLabel.setText("Vous devez piochez avant de sélectionner une carte.");
					
				}
			} else {
				eventLabel.setText("Ce n'est pas votre tour."); 
			}
		}
	});
	carte4.add(carte4Joueur);
	b2.add(carte4);
	
	
	carte5.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte5.setTitle("Carte 5");
	carte5.setVisible(false);//On la rend visible
	
	
	carte5Joueur.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				eventLabel.setText("Vous avez choisi la cinquieme carte");
				carteSelectionnee=controleur.getMain(controleur.getJoueurActuel()).get(4);
		
			} else {
				eventLabel.setText("Ce n'est pas votre tour.");
				
			}
		}
	});
	carte5.add(carte5Joueur);
	b2.add(carte5);
	
    //Idem
    Box b3 = Box.createHorizontalBox();
    
    talon.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	talon.setTitle("Talon");
	talon.setVisible(true);//On la rend visible
	
	
	talonBouton.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.getJoueurActuel().getJeuEnMain().getMain().size() == 4) {
					Joueur joueurActuel = controleur.getJoueurActuel();
					joueurActuel.piocherTalon();
					eventLabel.setText("Vous avez pioché dans le talon.");
					
				} else {
					eventLabel.setText("Vous avez déjà pioché.");
					
				}
			}
		}
	});
	talon.add(talonBouton);
	b3.add(talon);
	
	///////
	defausse.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	defausse.setTitle("Defausse");
	defausse.setVisible(true);//On la rend visible
	
	
	defausseBouton.addActionListener(new ActionListener(){
		public  synchronized void actionPerformed(ActionEvent event){
			if(controleur.getJoueurActuel() instanceof Humain) {
				if(controleur.isDefausseEmpty() == false) {
					if(controleur.getJoueurActuel().getJeuEnMain().getMain().size() == 4) {
						Joueur joueurActuel = controleur.getJoueurActuel();
						joueurActuel.piocherDefausse();
						eventLabel.setText("Vous avez pioché dans le talon.");
						
					} else {
						eventLabel.setText("Vous avez déjà pioché.");
						
					}
				} else {
					eventLabel.setText("La défausse est vide.");
					
				}
			}
		}
	});
	defausse.add(defausseBouton);
	b3.add(defausse);
	
	//////
	JInternalFrame evenement = new JInternalFrame(); 
	eventLabel.setForeground(Color.BLUE);
	evenement.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	evenement.setTitle("Evenements");
	evenement.setVisible(true);//On la rend visible
	evenement.add(eventLabel);
	b3.add(evenement);
    
    
    //On crée un conteneur avec gestion verticale
    Box b4 = Box.createVerticalBox();
    b4.add(b1);
    b4.add(b2);
    b4.add(b3);

    this.getContentPane().add(b4);
    this.setVisible(true);
  
	  
}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof Defausse) {
			this.defausse.setTitle("Defausse : "+this.controleur.getCarteVisibleDefausse().toString());
			
		} else if (arg0 instanceof JeuEnMain) {
			this.carte5.setVisible(false);//On cache la 5e carte qui est vide a ce moment
			this.carte1.setTitle(""+((JeuEnMain) arg0).getMain().get(0).toString());

			this.carte2.setTitle(""+((JeuEnMain) arg0).getMain().get(1).toString());
			this.carte3.setTitle(""+((JeuEnMain) arg0).getMain().get(2).toString());
	  		this.carte4.setTitle(""+((JeuEnMain) arg0).getMain().get(3).toString());
	  		if(((JeuEnMain) arg0).getMain().size() == 5) {
	  			this.carte5.setVisible(true);//TODO il faut le remettre a false a chaque fin de tour des joueurs.
	  			this.carte5.setTitle(""+((JeuEnMain) arg0).getMain().get(4).toString());
	  		}
	  		
		} else if(arg0 instanceof Humain) {
			this.carte5.setVisible(false);//On cache la 5e carte qui est vide a ce moment
			this.carte1.setTitle(""+((JeuEnMain) arg0).getMain().get(0).toString());

			this.carte2.setTitle(""+ ((Humain) arg0).getJeuEnMain().getMain().get(1).toString());
			this.carte3.setTitle(""+ ((Humain) arg0).getJeuEnMain().getMain().get(2).toString());
	  		this.carte4.setTitle(""+((Humain) arg0).getJeuEnMain().getMain().get(3).toString());
	  		if(((Humain) arg0).getJeuEnMain().getMain().size() == 5) {
	  			this.carte5.setVisible(true);//TODO il faut le remettre a false a chaque fin de tour des joueurs.
	  			this.carte5.setTitle(""+((Humain) arg0).getJeuEnMain().getMain().get(4).toString());

	  		}
		
		} else if (arg0 instanceof PartieDeJeu) {
			
			if(arg1 instanceof Joueur) {
				if(controleur.isPartieFinie()) {
					JOptionPane.showMessageDialog(null, "Victoire de "+((Joueur) arg1).getNom());
			
				}
			}
			
			this.carte5.setVisible(false);//On cache la 5e carte qui est vide a ce moment
			Joueur joueurActuel = controleur.getJoueurActuel();
			this.carte1.setTitle(""+joueurActuel.getJeuEnMain().getMain().get(0).toString());

			this.carte2.setTitle(""+ joueurActuel.getJeuEnMain().getMain().get(1).toString());
			this.carte3.setTitle(""+ joueurActuel.getJeuEnMain().getMain().get(2).toString());
	  		this.carte4.setTitle(""+joueurActuel.getJeuEnMain().getMain().get(3).toString());
	  		if(joueurActuel.getJeuEnMain().getMain().size() == 5) {
	  			this.carte5.setVisible(true);//TODO il faut le remettre a false a chaque fin de tour des joueurs.
	  			this.carte5.setTitle(""+joueurActuel.getJeuEnMain().getMain().get(4).toString());

	  		}
	  		
	  		
		}
	}
	
	
	//Update lors de la pose d'une carte (pour le joueur 1) (ou variante Si on clique sur CE bouton)
	/*public void update(Observable arg0, Carte carte){
		
	/*if (on pose dans la defausse){
	 * if (carte instanceof Attaque){
			if (carte instanceof Accident){
				defausse.setTitle("Defausse: Accident");
			}
			if (carte instanceof Crevaison){
				defausse.setTitle("Defausse: Crevaison");
			}
			if (carte instanceof FeuRouge){
				defausse.setTitle("Defausse: Feu rouge");
			}
			if (carte instanceof PanneEssence){
				defausse.setTitle("Defausse: Panne d'essence");
			}
			if (carte instanceof LimiteVitesse){
				defausse.setTitle("Defausse: Limite de vitesse");
			}
			
		}
		if (carte instanceof Etape){
			defausse.setTitle("Defausse: Etape");//TODO
		}
		if (carte instanceof Botte){
			defausse.setTitle("Defausse: Botte");
		}
	}
	 *}
	 *
		
	else if{// Si on pose sur un tas de joueur1
		if (carte instanceof Attaque){
			if (carte instanceof Accident){
				isAttaqueJ1.setText("Oui accident");
			}
			if (carte instanceof Crevaison){
				isAttaqueJ1.setText("Oui crevaison");
			}
			if (carte instanceof FeuRouge){
				isAttaqueJ1.setText("Oui feu rouge");
			}
			if (carte instanceof PanneEssence){
				isAttaqueJ1.setText("Oui panne d'essence");
			}
			if (carte instanceof LimiteVitesse){
				isLimiteJ1.setText("Oui");
			}
			
		}
		if (carte instanceof Etape){
			kmJ1.setText("");//Mettre la valeur de km parcourus
		}
		if (carte instanceof Botte){
			bottePossJ1.setText("");//Mettre initiales ?
		}
		
		carte=null;//remise a zero
		//remettre carte5visible a false
		//fin tour-> joueur suivant (l'autre update)
		
		
	}
	}*/

}