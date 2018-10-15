package com.cgi.timesheet.util;

public enum RoleEnum {

	EMPLOYEE("Employé"),
	MANAGER("Gestionnaire"),
	PROJECT_MANAGER("Chef de projet"),
	ADMINISTRATOR("Administrateur");
	
	private String nom;
	
	//Constructor
	
	RoleEnum(String nom) {
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
