package application;

public class ModelClass {

	String PrenomEn,NomEn,EmailEn,Diplome;
	int ID,NumEn ;
	public ModelClass (Integer ID , String PrenomEn,String NomEn,String EmailEn, Integer NumEn, String Diplome) {
		this.ID = ID;
		this.PrenomEn = PrenomEn;
		this.NomEn = NomEn ;
		this.EmailEn = EmailEn ;
		this.NumEn = NumEn ;
		this.Diplome = Diplome;
	}
	
	
	public String getDiplome() {
		return Diplome;
	}
	public String getEmailEn() {
		return EmailEn;
	}
	public Integer getID() {
		return ID;
	}
	public String getNomEn() {
		return NomEn;
	}
	public Integer getNumEn() {
		return NumEn;
	}
public String getPrenomEn() {
	return PrenomEn;
}

public void setDiplome(String diplome) {
	Diplome = Diplome;
}
public void setEmailEn(String EmailEn) {
	EmailEn = EmailEn;
}
public void setID(Integer ID) {
	ID = ID;
}
public void setNomEn(String NomEn) {
	NomEn = NomEn;
}
public void setNumEn(Integer NumEn) {
	NumEn = NumEn;
}
public void setPrenomEn(String PrenomEn) {
	PrenomEn = PrenomEn;
}


}
