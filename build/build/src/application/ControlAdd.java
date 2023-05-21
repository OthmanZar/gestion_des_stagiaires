
package application;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.EventHandler ;
import javafx.collections.FXCollections;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ControlAdd implements Initializable {
	
	ObservableList<String> list2 ;
	ObservableList<String> list ;
	ObservableList<String> list3 ;
	 @FXML
	    private ComboBox<String> servicess ;
	 @FXML
	    private BorderPane BPADd;
	 @FXML
	    private Label succ;  
@FXML
private TextField fstname ;
@FXML
private TextField lstname ;	 
@FXML
private TextField numph ;
@FXML
private TextField mail ;	
@FXML
private DatePicker DtDeb ;
@FXML
private DatePicker DtDfin ;
	    @FXML
	    private ComboBox<String> encadrants ; 
	    @FXML
	    private ComboBox<String> Diplome;
	    @FXML
	    private Label faild;
	    @FXML
	    private ImageView prblm;
	    @FXML
	    void set1(ActionEvent event) {
	    	list3  = FXCollections.observableArrayList();
			list3.addAll("Diplome en Informatique","Diplome en Finance","Diplome En Electricité");

			Diplome.setItems(null);
			 Diplome.setItems(list3);	 
	   	
	    }
	    private int num = 0612121212;
		private int lenght = (int) (Math.log10(num) + 2);
	    private Stage stage1 ;
	    private Scene scene1;
	    private double x=0 ,y=0;
	    @FXML
	    void close(MouseEvent event) throws IOException {
	    	Stage stage  = (Stage) ((Button)event.getSource()).getScene().getWindow();
	    	stage.close();
	    	
	    	
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
static String nbr ;
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	 	try {
	 		nbr = numph.getText();
			
	   		 
	 		
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
	 	
	 	set1(null);
	    }
	
	
	public void visible() {
		succ.setVisible(false);	
		//faild.setVisible(false);
		
		
	}
	public void visible2() {
		
		faild.setVisible(false);
		
		
	}
	
	
	//private int nbr = Integer.parseInt(numph.getText());
	 @FXML
	    void ADD(ActionEvent event) throws IOException {
		
	
					
					if((fstname.getText()).equals("") || (lstname.getText()).equals("")  || (numph.getText()).equals("")  || (mail.getText()).equals("")   ) {
						faild.setVisible(true);
						 
								 }else {
									 
									 try {
										 if (numph.getText().length()!=10 ) {
											 prblm.setVisible(true);
											// System.out.println("Numero Invalid" + numph.getText().length()+ numph.getText());
										 }else {
											 prblm.setVisible(false);
											 Connection conn;
												
											 PreparedStatement ps;
												
														Class.forName("com.mysql.cj.jdbc.Driver");
														conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
														 ps = conn.prepareStatement("insert into stagiare(PrenST,NomSt,TelphoneSt,EmailSt,DiplomeSt,Date_Debut,Date_Fin,ServiceSt,Encadrant) values(?,?,?,?,?,?,?,?,?);");
														 conn.createStatement();
														 ps.setString(1, fstname.getText() );
												ps.setString(2, lstname.getText());	
												
													ps.setString(3, (numph.getText()));
												
													
												
												
												ps.setString(4, mail.getText());
												ps.setString(5, Diplome.getSelectionModel().getSelectedItem().toString());
												ps.setString(6, DtDeb.getValue().toString());
												ps.setString(7, DtDfin.getValue().toString());
												ps.setString(8, servicess.getSelectionModel().getSelectedItem().toString());
												ps.setString(9, encadrants.getSelectionModel().getSelectedItem().toString());
												
												
												int x1 = ps.executeUpdate();
												if(x1>0) {
												}else {
													
												
												
												}	
																								Statement stmt = null;
												Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
												stmt =con.createStatement();
												String sql= "update services set Places_vides = (Places_vides-1) where Nom_domaine = '"+servicess.getSelectionModel().getSelectedItem().toString()+"'";
												stmt.executeUpdate(sql);
												
												succ.setVisible(true);
										 }
	
											
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									 
								 }
	 }
}

