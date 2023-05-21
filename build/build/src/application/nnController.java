package application;

import javafx.scene.*;
import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JPasswordField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class nnController  implements Initializable {
	
	@FXML
    private ImageView img;
	  @FXML
	    private Button login;

	    @FXML
	    private TextField nom;

	    @FXML
	    private PasswordField password;
	    @FXML
	    private Label faild;
	    @FXML
	    private ImageView nomFaild;
	    @FXML
	    private Label D3;
	    @FXML
	    private ImageView pswdFaild;
	    @FXML
	    private Button close;
	    @FXML
	    private Button Espace_Encad;
	    
	    @FXML
	    private TextField nomEnca;

	    @FXML
	    private Button loginEncad;

	    @FXML
	    private PasswordField PasswordEncad;
	    @FXML
	    private Button EspaceAdmi;
	    public String vr ;
	    
	  public void closes(MouseEvent event) throws IOException {
	    	Stage stage  = (Stage) ((Button)event.getSource()).getScene().getWindow();
	    	stage.close();
	    	
	    	
	    }
	    public void visible() {
			faild.setVisible(false);	
			//faild.setVisible(false);
			
			
		}
	    private Stage stage1 ;
 	    private Scene scene1;
 	    private Parent root ;
 	    private double x=0 ,y=0;
	    public void GetInfos(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
	    	
	    	
	    	if ((nom.getText().equals("")) || (password.getText().equals("")) ) {
	    		
	    		faild.setVisible(true);
	    		
	    	
	    	}else {

	    		String name = nom.getText();
		    	String pswd = password.getText();  
		    	 //System.out.println(name);
	   			 //System.out.println(password.getText());
		    	
	   			
	   			 
		    	Class.forName("com.mysql.cj.jdbc.Driver");
			   	Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
			   		
			   		java.sql.Statement  statement = connn.createStatement();
			   		ResultSet resultsett = null;
			   		
			   		 resultsett = (ResultSet) statement.executeQuery("Select * from administrateur ");
			   		 
			   		
			   		 while(resultsett.next()) {
			   			
			   			 
			   	        if(name.equals(resultsett.getString("Nom_Admin"))) {
			   	        	nomFaild.setVisible(false);
			   	        	if(pswd.equals(resultsett.getString("Password"))) {
			   	        		ControllerSupervis.key = "Admin";
			   	        		Parent root  = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
			   	  	    	stage1  = (Stage)((Node)event.getSource()).getScene().getWindow();
			   	  	    	scene1 = new Scene(root);
			   	  	    	stage1.setScene(scene1);
			   	  	    	stage1.show();
			   	  	    	
			   	  			
			   	  			root.setOnMousePressed(new EventHandler<MouseEvent>() {
			   	  				@Override
			   	  				public void handle(MouseEvent event) {
			   	  					x= event.getSceneX();
			   	  					y= event.getSceneY();
			   	  				}
			   	  			});
			   	  			
			   	  			
			   	  			
			   	  				root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			   	  					@Override
			   	  					public void handle(MouseEvent event) {
			   	  						stage1.setX(event.getScreenX() - x);
			   	  						stage1.setY(event.getScreenY() - y);
			   	  				
			   	  					}
			   	  				});
			   	  					
			   	  	    	String css = this.getClass().getResource("application.css").toExternalForm();
			   	  			scene1.getStylesheets().add(css);
			   	        	}else {
			   	        		pswdFaild.setVisible(true);
			   	        		
			   	        	}
			   	        	
			   	        }else {
			   	        	nomFaild.setVisible(true);
			   	        	
			   	        }
			   			
			   			 	
			   		 
			   		} 
	    		
	    	}
	    	
	    	
	    }
	    
	    
 
	    public void GetEncad(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
	   	 if ((nomEnca.getText().equals("")) || (PasswordEncad.getText().equals("")) ) {
	    		
	    		faild.setVisible(true);
	    		 
	    	
	    	}else {

	    		String nameEnca = nomEnca.getText();
	   	    	String pswdEnca = PasswordEncad.getText();  
	   	    	 //System.out.println(name);
	   			 //System.out.println(password.getText());
	   	    	
	   			
	   			 
	   	    	Class.forName("com.mysql.cj.jdbc.Driver");
	   		   	Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
	   		   		
	   		   	
	   		   	
	   		   	
	   		   		java.sql.Statement  statement = connn.createStatement();
	   		   		ResultSet resultsett = null;
	   		   		
	   		   		 resultsett = (ResultSet) statement.executeQuery("Select * from encadrant ");
	   		   		 
	   		   		
	   		   		 while(resultsett.next()) {
	   		   			
	   		   			 
	   		   	        if(nameEnca.equals(resultsett.getString("NomEn"))) {
	   		   	        	nomFaild.setVisible(false);
	   		   	        	if(pswdEnca.equals(resultsett.getString("Password"))) {
	   		   	        	ControllerSupervis.key = "Encadrant";
	   		   	        	ControllerSupervis.encad = nomEnca.getText();
	   		   	        		Parent root  = FXMLLoader.load(getClass().getResource("Supervision.fxml"));
	   		   	        	
	   		   	  	    	stage1  = (Stage)((Node)event.getSource()).getScene().getWindow();
	   		   	  	    	scene1 = new Scene(root);
	   		   	  	    	stage1.setScene(scene1);
	   		   	  	    	stage1.show();
	   		   	  	   
	   		   	  	   
	   		   	  			root.setOnMousePressed(new EventHandler<MouseEvent>() {
	   		   	  				@Override
	   		   	  				public void handle(MouseEvent event) {
	   		   	  					x= event.getSceneX();
	   		   	  					y= event.getSceneY();
	   		   	  				}
	   		   	  			});
	   		   	  			
	   		   	  			
	   		   	  			
	   		   	  				root.setOnMouseDragged(new EventHandler<MouseEvent>() {
	   		   	  					@Override
	   		   	  					public void handle(MouseEvent event) {
	   		   	  						stage1.setX(event.getScreenX() - x);
	   		   	  						stage1.setY(event.getScreenY() - y);
	   		   	  				
	   		   	  					}
	   		   	  				});
	   		   	  					
	   		   	  	    	String css = this.getClass().getResource("application.css").toExternalForm();
	   		   	  			scene1.getStylesheets().add(css);
	   		   	  	
	   		   	        	}else {
	   		   	        		pswdFaild.setVisible(true);
	   		   	        		
	   		   	        	}
	   		   	        	
	   		   	        }else {
	   		   	        	nomFaild.setVisible(true);
	   		   	        	
	   		   	        }
	   		   			
	   		   			 	
	   		   		 
	   		   		} 
	    		
	    	}
	    }
	    
 
 public void Encad(ActionEvent event) {
	    	Espace_Encad.setVisible(false);
	    	EspaceAdmi.setVisible(true);
	    	nom.setVisible(false);
	    	password.setVisible(false);
	    nomEnca.setVisible(true);
	    PasswordEncad.setVisible(true);
	    login.setVisible(false);
	    loginEncad.setVisible(true);
		 
 }
 public void Admin(ActionEvent event) {
	 Espace_Encad.setVisible(true);
 	EspaceAdmi.setVisible(false);
	 
 	nom.setVisible(true);
 	password.setVisible(true);
 nomEnca.setVisible(false);
 PasswordEncad.setVisible(false);
 login.setVisible(true);
 loginEncad.setVisible(false);
	 
}
	
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub

}
 
}
