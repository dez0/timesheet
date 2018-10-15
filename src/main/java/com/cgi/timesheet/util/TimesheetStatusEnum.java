package com.cgi.timesheet.util;

public enum TimesheetStatusEnum {

	DRAFT("Brouillon"),
	PENDING("En attente"),
	REFUSED("Refusée"),
	APPROVED("Approuvée");
	
	private String nom;
	
	//Constructor
	
	TimesheetStatusEnum(String nom) {
		this.setNom(nom);
	}

	//Getter
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
