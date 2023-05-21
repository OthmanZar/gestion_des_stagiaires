package application;

public class ModelStag {
	String PrenomST,NomST,EmailST,DiplomeST,DateDB,DateFn , ServiceST , Enca;
	int ID,TelephoneST ;
	public ModelStag (Integer ID , String PrenomST,String NomST,String EmailST ,Integer TelephoneST, String DiplomeST , String DateDB , String DateFn , String ServiceST , String Enca) {
		this.ID = ID;
		this.PrenomST = PrenomST;
		this.NomST = NomST ;
		this.EmailST = EmailST ;
		this.TelephoneST  = TelephoneST  ;
		this.DiplomeST = DiplomeST;
		this.DateDB = DateDB;
		this.DateFn = DateFn ;
		this.ServiceST = ServiceST ;
		this.Enca = Enca ;
		
	}
	
	
	public String getDiplomeST() {
		return DiplomeST;
	}
	public String getEmailST() {
		return EmailST;
	}
	public Integer getID() {
		return ID;
	}
	public String getNomST() {
		return NomST;
	}
	public Integer getTelephoneST() {
		return TelephoneST;
	}
public String getPrenomST() {
	return PrenomST;
}

public String getDateDB() {
	return DateDB;
}
public String getDateFn() {
	return DateFn;
}
public String getEnca() {
	return Enca;
}
public String getServiceST() {
	return ServiceST;
}


public void setDiplomeST(String diplomeST) {
	DiplomeST = DiplomeST;
}
public void setEmailST(String EmailST) {
	EmailST = EmailST;
}
public void setID(Integer ID) {
	ID = ID;
}
public void setNomST(String NomST) {
	NomST = NomST;
}
public void setNumST(Integer TelephoneST) {
	TelephoneST = TelephoneST;
}
public void setPrenomST(String PrenomST) {
	PrenomST = PrenomST;
}

public void setServiceST(String serviceST) {
	ServiceST = serviceST;
}
public void setEnca(String enca) {
	Enca = enca;
}
public void setDateDB(String dateDB) {
	DateDB = dateDB;
}
public void setDateFn(String dateFn) {
	DateFn = dateFn;
}

	
	
	
}
