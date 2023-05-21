package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller  implements Initializable{

ObservableList<String> list2 ;
ObservableList<String> list ;
    @FXML
    private Button btn;

    @FXML
    private PasswordField pswdtxt;

    @FXML
    private TextField usrtxt;

   
    @FXML
    private ComboBox servicess ;
   
    
    @FXML
    private ComboBox encadrants ; 
    
    @FXML
    void login(ActionEvent event) {
    	String name = usrtxt.getText();
    	    String pswd = pswdtxt.getText();
    	System.out.println(name + pswd);
    	
    	
    	
    }
    

   /* public String get() {
    	return servicess.getValue();
    }
    */
    
 
    @FXML
    void set1(ActionEvent event) throws SQLException {

 
 




    }
    
    
    
    @FXML
    void set2(ActionEvent event) {
    	String s = servicess.getSelectionModel().getSelectedItem().toString();
    	
    	
    	try {
   		 
   		 list  = FXCollections.observableArrayList();
   		Class.forName("com.mysql.cj.jdbc.Driver");
   	Connection connn2 = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
   		
   		java.sql.Statement  statement2 = connn2.createStatement();
   		ResultSet resultsett2 = null;
   	 resultsett2 = (ResultSet) statement2.executeQuery("select * from encadrant where Domaine = '"+s+"'");
   		 while(resultsett2.next()) {
   			 
   			 list.add(new String(resultsett2.getString("NomEn")));
   			 	 System.out.println(resultsett2.getString("NomEn"));
   			
   		 
   		} 
   	} catch (ClassNotFoundException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    	
    	
      	encadrants.setItems(null);
      	 encadrants.setItems(list);
    	
    	 
    	
    }
   
    public void initialize(URL url , ResourceBundle rb) {
    	try {
   		 
   		 list2  = FXCollections.observableArrayList();
   		Class.forName("com.mysql.cj.jdbc.Driver");
   	Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
   		
   		java.sql.Statement  statement = connn.createStatement();
   		ResultSet resultsett = null;
   		
   		 resultsett = (ResultSet) statement.executeQuery("Select * from services ");
   		 while(resultsett.next()) {
   			 
   			 list2.add(new String(resultsett.getString("Nom_domaine")));
   			 	 
   			
   		 
   		} 
   	} catch (ClassNotFoundException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 
   	servicess.setItems(null);
 	 servicess.setItems(list2);
	
    }
    
    
    
    

}
