package application;

public class ModelPlac {
	String Nom_Domaine;
	int ID,Places_Vides , encadrants , Places_Generales ;
	public ModelPlac (Integer ID , String Nom_Domaine,Integer Places_Vides,Integer encadrants ,Integer Places_Generales) {
		this.ID = ID;
		this.Nom_Domaine = Nom_Domaine;
		this.Places_Vides = Places_Vides ;
		this.encadrants = encadrants ;
		this.Places_Generales  = Places_Generales  ;
	
	}
	
	
	public String getNom_Domaine() {
		return Nom_Domaine;
	}
	public Integer getPlaces_Vides() {
		return Places_Vides;
	}
	public Integer getID() {
		return ID;
	}
	public Integer getEncadrants() {
		return encadrants;
	}
	public Integer getPlaces_Generales() {
		return Places_Generales;
	}
	
	
	
	
	

public void setPlaces_Vides(int places_Vides) {
	Places_Vides = places_Vides;
}
public void setPlaces_Generales(int places_Generales) {
	Places_Generales = places_Generales;
}
public void setNom_Domaine(String nom_Domaine) {
	Nom_Domaine = nom_Domaine;
}
public void setID(int iD) {
	ID = iD;
}
public void setEncadrants(int encadrants) {
	this.encadrants = encadrants;
}

}
