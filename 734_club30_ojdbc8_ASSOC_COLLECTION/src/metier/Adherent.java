package metier;

import java.util.*;

public class Adherent
{
	private int idA;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private Set<Sport> sports = new HashSet<>(); //assoc manyToMany
	
	//CONSTRUCTEURS
	
	public Adherent(String nom, String prenom, Date dateNaiss)
	{
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setDateNaiss(dateNaiss);
	}
	public Adherent(){	}

	//REDEFINITION DE toString()
	public String toString()
	{
		return  "[Adherent idA :" + idA + " nom :" +nom+ " prenom :" +prenom+ " dateNaiss :" + dateNaiss +
					" sports :[collection d'objets]]" ;

	}	
/*	public String toString()
	{
		String sortie="";
		sortie= sortie + idA + " nom :<" +nom+ "> prenom :<" +prenom+ "> dateNaiss :" + dateNaiss +
					"   nb sports :" +  sports.size();
		return sortie;
	}*/
	
	//GETTEURs SETTEURs
	public int getIdA() {
		return idA;
	}
	private void setIdA(int idA) {
		this.idA = idA;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomA) {
		this.nom = nomA;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenomA) {
		this.prenom = prenomA;
	}
	public Date getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(Date dateNaissA) {
		this.dateNaiss = dateNaissA;
	}
	public Set<Sport> getSports() {
		return sports;
	}
	
	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
	
	public boolean addSport( Sport s){
		boolean b = sports.add(s);
		return b;
	}

}
