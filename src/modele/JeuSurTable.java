package modele;

import java.util.*;

import controleur.*;

public class JeuSurTable extends Observable {

	private int nbKilometreParcouru=0;
	private boolean feuVertInitial=false;
	private boolean increvable=false;
	private boolean citerneEssence=false;
	private boolean asDuVolant=false;
	private boolean vehiculePrioritaire=false;
	
	private boolean vitesseLimitee=false;
	private boolean stoppe=false;
	
	private int nbKmMax;
	
	private ArrayList<Carte> jeu;

	public JeuSurTable() {
		this.jeu = new ArrayList();
		
	}
	/** 
	 * @param Carte
	 * 
	 */
	public void ajouterCarte()
	{
		//TODO
	}
	
	/*
	 * @param Carte
	 * 
	 */
	public void retirerCarte()
	{
		//TODO
		
	}
	
	public void verifVictoire()
	{
		
		if(this.nbKilometreParcouru == this.nbKmMax)
		{
			//TODO VICTOIRE
		}
		
	}
	
	public boolean verifDepassementKm()
	{
		return true;
		//TODO
	}
	
	/**
	 * @return the nbKilometreParcouru
	 */
	public int getNbKilometreParcouru() {
		return nbKilometreParcouru;
	}

	/**
	 * @param nbKilometreParcouru the nbKilometreParcouru to set
	 */
	public void setNbKilometreParcouru(int nbKilometreParcouru) {
		this.nbKilometreParcouru += nbKilometreParcouru;
	}

	/**
	 * @return the feuVertInitial
	 */
	public boolean isFeuVertInitial() {
		return feuVertInitial;
	}

	/**
	 * @param feuVertInitial the feuVertInitial to set
	 */
	public void setFeuVertInitial(boolean feuVertInitial) {
		this.feuVertInitial = feuVertInitial;
	}

	/**
	 * @return the increvable
	 */
	public boolean isIncrevable() {
		return increvable;
	}

	/**
	 * @param increvable the increvable to set
	 */
	public void setIncrevable(boolean increvable) {
		this.increvable = increvable;
	}

	/**
	 * @return the citerneEssence
	 */
	public boolean isCiterneEssence() {
		return citerneEssence;
	}

	/**
	 * @param citerneEssence the citerneEssence to set
	 */
	public void setCiterneEssence(boolean citerneEssence) {
		this.citerneEssence = citerneEssence;
	}

	/**
	 * @return the asDuVolant
	 */
	public boolean isAsDuVolant() {
		return asDuVolant;
	}

	/**
	 * @param asDuVolant the asDuVolant to set
	 */
	public void setAsDuVolant(boolean asDuVolant) {
		this.asDuVolant = asDuVolant;
	}

	/**
	 * @return the vehiculePrioritaire
	 */
	public boolean isVehiculePrioritaire() {
		return vehiculePrioritaire;
	}

	/**
	 * @param vehiculePrioritaire the vehiculePrioritaire to set
	 */
	public void setVehiculePrioritaire(boolean vehiculePrioritaire) {
		this.vehiculePrioritaire = vehiculePrioritaire;
	}

	/**
	 * @return the vitesseLimitee
	 */
	public boolean isVitesseLimitee() {
		return vitesseLimitee;
	}

	/**
	 * @param vitesseLimitee the vitesseLimitee to set
	 */
	public void setVitesseLimitee(boolean vitesseLimitee) {
		this.vitesseLimitee = vitesseLimitee;
	}

	/**
	 * @return the stoppe
	 */
	public boolean isStoppe() {
		return stoppe;
	}

	/**
	 * @param stoppe the stoppe to set
	 */
	public void setStoppe(boolean stoppe) {
		this.stoppe = stoppe;
	}

	/**
	 * @return the nbKmMax
	 */
	public int getNbKmMax() {
		return nbKmMax;
	}

	/**
	 * @param nbKmMax the nbKmMax to set
	 */
	public void setNbKmMax(int nbKmMax) {
		this.nbKmMax = nbKmMax;
	}
	
	
}
