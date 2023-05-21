package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
public class ControllerDelete implements Initializable {
	private ObservableList<ModelStag> dataTable2;
	
	@FXML
    private TableView<ModelStag> TABLE2;
    @FXML
    private TableColumn<ModelStag, Integer> iD;
    @FXML
    private TableColumn<ModelStag, String> PrenST;
    @FXML
    private TableColumn<ModelStag, String> NomST;
    @FXML
    private TableColumn<ModelStag, Integer> TelephoneST;
    @FXML
    private TableColumn<ModelStag, String> EmailST;
    @FXML
    private TableColumn<ModelStag, String> DiplomeST;
    @FXML
    private TableColumn<ModelStag, String> Date_Debut;

    @FXML
    private TableColumn<ModelStag, String> Date_Fin;
    @FXML
    private TableColumn<ModelStag, String> ServiceST;

    @FXML
    private TableColumn<ModelStag, String> Encadrant;
	
	
	
static int i;
static String sv;
    @FXML
    private Button Actualiser;

    @FXML
    private Label D1;

    

    @FXML
    private Button Delet;

   

    @FXML
    private Button Search;

    
    @FXML
    private ImageView close;

    @FXML
    private Button exit;

    @FXML
    private TextField fstname;



    @FXML
    private TextField lstname;

    @FXML
    private Label nam;
  

    private Stage stage1 ;
    private Scene scene1;
    private Parent root ;
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
	
		
	public void selec(MouseEvent MouseEvent) {
		 i =	TABLE2.getSelectionModel().getSelectedItem().getID();
	 sv   = 	TABLE2.getSelectionModel().getSelectedItem().getServiceST();

	}
    
	
	
	
    public void stag(MouseEvent MouseEvent) {
    	String fnam = fstname.getText();
    	String lsnam = lstname.getText();
    	
    	
    	
    
		TABLE2.setVisible(true);
		dataTable2 = FXCollections.observableArrayList();
				try {
					Connection con = (Connection) DBConnection.getConnection();
					java.sql.ResultSet res =  con.createStatement().executeQuery("select * from stagiare where NomSt = '"+lsnam+"' OR PrenSt = '"+fnam+"'");
					while (res.next()) {
						dataTable2.add(new ModelStag(res.getInt("id"), res.getString("PrenSt"), res.getString("NomSt"), res.getString("EmailSt"), res.getInt("TelphoneSt"), res.getString("DiplomeSt") ,  res.getString("Date_Debut"),  res.getString("Date_Fin") , res.getString("ServiceSt"),  res.getString("Encadrant")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
					iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
					PrenST.setCellValueFactory(new PropertyValueFactory<>("PrenomST"));
					NomST.setCellValueFactory(new PropertyValueFactory<>("NomST"));
					EmailST.setCellValueFactory(new PropertyValueFactory<>("EmailST"));
					TelephoneST.setCellValueFactory(new PropertyValueFactory<>("TelephoneST"));
					DiplomeST.setCellValueFactory(new PropertyValueFactory<>("DiplomeST"));
					Date_Debut.setCellValueFactory(new PropertyValueFactory<>("DateDB"));
					Date_Fin.setCellValueFactory(new PropertyValueFactory<>("DateFn"));
					ServiceST.setCellValueFactory(new PropertyValueFactory<>("ServiceST"));
					Encadrant.setCellValueFactory(new PropertyValueFactory<>("Enca"));
				
				TABLE2.setItems(dataTable2);
	}
	
    public void Dele(MouseEvent MouseEvent) throws ClassNotFoundException, SQLException {
    	

		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmt5 = null;
		Connection con5 =DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
		stmt5 = con5.createStatement();
		String Sql5 = "delete from absentes where id_Stagiaires = '"+i+"'";
		stmt5.executeUpdate(Sql5);
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmt = null;
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
		stmt =con.createStatement();
		String sql= "delete from stagiare where id = '"+i+"'";
		stmt.executeUpdate(sql);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmt22 = null;
		Connection con22 =DriverManager.getConnection("jdbc:mysql://localhost:3306/pfe","root","");
		stmt22 =con22.createStatement();
    	String sql22= "update services set Places_vides = (Places_vides+1) where Nom_domaine = '"+sv+"'";
		stmt22.executeUpdate(sql22);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Statement stmt3 = null;
		Connection con3 =DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
		stmt3 =con3.createStatement();
		String sql3= "ALTER TABLE stagiare AUTO_INCREMENT = 1";
		stmt3.executeUpdate(sql3);
	}
    
    
    public void act(MouseEvent MouseEvent) {
    	TABLE2.setVisible(true);
		dataTable2 = FXCollections.observableArrayList();
		
				
		fstname.setText("");
		lstname.setText("");
		
				try {
					Connection con = (Connection) DBConnection.getConnection();
					ResultSet res =  con.createStatement().executeQuery("select * from stagiare ");
					while (res.next()) {
						dataTable2.add(new ModelStag(res.getInt("id"), res.getString("PrenSt"), res.getString("NomSt"), res.getString("EmailSt"), res.getInt("TelphoneSt"), res.getString("DiplomeSt") ,  res.getString("Date_Debut"),  res.getString("Date_Fin") , res.getString("ServiceSt"),  res.getString("Encadrant")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			
				
			

					
					iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
					PrenST.setCellValueFactory(new PropertyValueFactory<>("PrenomST"));
					NomST.setCellValueFactory(new PropertyValueFactory<>("NomST"));
					EmailST.setCellValueFactory(new PropertyValueFactory<>("EmailST"));
					TelephoneST.setCellValueFactory(new PropertyValueFactory<>("TelephoneST"));
					DiplomeST.setCellValueFactory(new PropertyValueFactory<>("DiplomeST"));
					Date_Debut.setCellValueFactory(new PropertyValueFactory<>("DateDB"));
					Date_Fin.setCellValueFactory(new PropertyValueFactory<>("DateFn"));
					ServiceST.setCellValueFactory(new PropertyValueFactory<>("ServiceST"));
					Encadrant.setCellValueFactory(new PropertyValueFactory<>("Enca"));
				
				
				TABLE2.setItems(dataTable2);
		
	}
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TABLE2.setVisible(true);
		dataTable2 = FXCollections.observableArrayList();
		
				
				try {
					Connection con = (Connection) DBConnection.getConnection();
				ResultSet res =  con.createStatement().executeQuery("select * from stagiare ");
					while (res.next()) {
						dataTable2.add(new ModelStag(res.getInt("id"), res.getString("PrenSt"), res.getString("NomSt"), res.getString("EmailSt"), res.getInt("TelphoneSt"), res.getString("DiplomeSt") ,  res.getString("Date_Debut"),  res.getString("Date_Fin") , res.getString("ServiceSt"),  res.getString("Encadrant")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			
				
			

					
					iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
					PrenST.setCellValueFactory(new PropertyValueFactory<>("PrenomST"));
					NomST.setCellValueFactory(new PropertyValueFactory<>("NomST"));
					EmailST.setCellValueFactory(new PropertyValueFactory<>("EmailST"));
					TelephoneST.setCellValueFactory(new PropertyValueFactory<>("TelephoneST"));
					DiplomeST.setCellValueFactory(new PropertyValueFactory<>("DiplomeST"));
					Date_Debut.setCellValueFactory(new PropertyValueFactory<>("DateDB"));
					Date_Fin.setCellValueFactory(new PropertyValueFactory<>("DateFn"));
					ServiceST.setCellValueFactory(new PropertyValueFactory<>("ServiceST"));
					Encadrant.setCellValueFactory(new PropertyValueFactory<>("Enca"));
				
				
				TABLE2.setItems(dataTable2);
		
	}
}
