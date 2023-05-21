package application;

public class ModelAbsents {
	String Date ,Status , Nom  , Prenom ;
	int ID, id_Stagiaire ;
	public ModelAbsents (Integer ID , String Date,String Status ,Integer id_Stagiaire,String Nom ,String Prenom) {
		this.ID = ID;
		this.Date = Date;
		this.Status = Status;
		this.id_Stagiaire = id_Stagiaire ;
		this.Nom = Nom ;
		this.Prenom  = Prenom  ;
	
	}
	
	
	public String getDate() {
		return Date;
	}
	
	public Integer getID() {
		return ID;
	}
	public String getNom() {
		return Nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public String getStatus() {
		return Status;
	}
	
	
	
	

public int getId_Stagiaire() {
	return id_Stagiaire;
}

public void setStatus(String status) {
	Status = status;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public void setNom(String nom) {
	Nom = nom;
}

public void setId_Stagiaire(int id_Stagiaire) {
	this.id_Stagiaire = id_Stagiaire;
}
public void setID(int iD) {
	ID = iD;
}
public void setDate(String date) {
	Date = date;
}


}
