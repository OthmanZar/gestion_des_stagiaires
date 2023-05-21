package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.EventHandler ;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControlBD implements Initializable {
	
	private ObservableList<ModelClass> dataTable;
private ObservableList<ModelStag> dataTable2;
private ObservableList<ModelPlac> dataTable3;
private ObservableList<ModelAbsents> dataTable4;
	     @FXML
	    private Button AffEnca;

	    @FXML
	    private Button AffPlac;

	    @FXML
	    private Button AffStag;
       @FXML
       private Button ABs;
	@FXML
	private TableView<ModelClass> TABLE ;
	@FXML
	private TableColumn<ModelClass, Integer> ID ;
	@FXML
	private TableColumn<ModelClass, String> PrenomEn ;
	@FXML
	private TableColumn<ModelClass, String> NomEn ;
	@FXML
	private TableColumn<ModelClass, String> EmailEn ;
	@FXML
	private TableColumn<ModelClass, Integer> NumEn ;
	@FXML
	private TableColumn<ModelClass, String> Domaine ;

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
    
    @FXML
    private TableView<ModelPlac> TABLE3;
    @FXML
    private TableColumn<ModelPlac, Integer> Id;
    @FXML
    private TableColumn<ModelPlac, String> Nom_Domaine;
    @FXML
    private TableColumn<ModelPlac, Integer> Places_Generales;

    @FXML
    private TableColumn<ModelPlac, Integer> Places_Vides;
    @FXML
    private TableColumn<ModelPlac, Integer> Encadrants;

    @FXML
   private TableView<ModelAbsents> TABLE4;
    @FXML
    private TableColumn<ModelAbsents, Integer> idAB;
    @FXML
    private TableColumn<ModelAbsents, String> DateAB;
    @FXML
    private TableColumn<ModelAbsents, String> StatusAB;
    @FXML
    private TableColumn<ModelAbsents, Integer> Id_STAB;

    @FXML
    private TableColumn<ModelAbsents, String> NomAB;
    @FXML
    private TableColumn<ModelAbsents, String> PrenomAB;
    
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
    
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	
	
	public void Encad() {
		TABLE2.setVisible(false);
		TABLE3.setVisible(false);
		TABLE4.setVisible(false);
		TABLE.setVisible(true);
		
dataTable = FXCollections.observableArrayList();
		
		
		
		try {
			Connection con = (Connection) DBConnection.getConnection();
			java.sql.ResultSet res =  con.createStatement().executeQuery("Select * from encadrant ");
			while (res.next()) {
				dataTable.add(new ModelClass(res.getInt("ID"), res.getString("PrenomEn"), res.getString("NomEn"), res.getString("EmailEn"), res.getInt("TelphoneEn"), res.getString("Domaine")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		PrenomEn.setCellValueFactory(new PropertyValueFactory<>("PrenomEn"));
		NomEn.setCellValueFactory(new PropertyValueFactory<>("NomEn"));
		EmailEn.setCellValueFactory(new PropertyValueFactory<>("EmailEn"));
		NumEn.setCellValueFactory(new PropertyValueFactory<>("NumEn"));
		Domaine.setCellValueFactory(new PropertyValueFactory<>("Diplome"));
		
	

		
		TABLE.setItems(dataTable);
		
		
	}
	
	
	public void stag() {
		TABLE.setVisible(false);
		TABLE3.setVisible(false);
		TABLE4.setVisible(false);
		TABLE2.setVisible(true);
		dataTable2 = FXCollections.observableArrayList();
				
				
				
				try {
					Connection con = (Connection) DBConnection.getConnection();
					java.sql.ResultSet res =  con.createStatement().executeQuery("Select * from Stagiare ");
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
	
	
	public void place() {
		TABLE.setVisible(false);
		TABLE2.setVisible(false);
		TABLE4.setVisible(false);
		TABLE3.setVisible(true);
		dataTable3 = FXCollections.observableArrayList();
				
				
				
				try {
					Connection con = (Connection) DBConnection.getConnection();
					java.sql.ResultSet res =  con.createStatement().executeQuery("Select * from services");
					while (res.next()) {
						dataTable3.add(new ModelPlac(res.getInt("id"), res.getString("Nom_Domaine"), res.getInt("Places_vides"), res.getInt("Encadrants"), res.getInt("places_general")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			
				
			
				
			

					
			    Id.setCellValueFactory(new PropertyValueFactory<>("ID"));
			    Nom_Domaine.setCellValueFactory(new PropertyValueFactory<>("Nom_Domaine"));
			    Places_Generales.setCellValueFactory(new PropertyValueFactory<>("Places_Generales"));
			    Places_Vides.setCellValueFactory(new PropertyValueFactory<>("Places_Vides"));
			    Encadrants.setCellValueFactory(new PropertyValueFactory<>("encadrants"));
					
				
				
				TABLE3.setItems(dataTable3);
	}
	
	
	public void Abst() {
		TABLE.setVisible(false);
		TABLE2.setVisible(false);
		TABLE3.setVisible(false);
		TABLE4.setVisible(true);
		dataTable4 = FXCollections.observableArrayList();
				
				
				
				try {
					Connection con = (Connection) DBConnection.getConnection();
					java.sql.ResultSet res =  con.createStatement().executeQuery("Select * from absentes");
					java.sql.ResultSet res2 = con.createStatement().executeQuery("SELECT PrenST , NomSt FROM stagiare INNER JOIN absentes ON stagiare.id = absentes.id_Stagiaires ");
					while (res.next() && res2.next()) {
						dataTable4.add(new ModelAbsents(res.getInt("id"), res.getString("Date"), res.getString("Status"), res.getInt("id_Stagiaires"), res2.getString("NomSt") , res2.getString("PrenST")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			
				
			
				
			

					
			    idAB.setCellValueFactory(new PropertyValueFactory<>("ID"));
			    DateAB.setCellValueFactory(new PropertyValueFactory<>("Date"));
			   StatusAB.setCellValueFactory(new PropertyValueFactory<>("Status"));
			    Id_STAB.setCellValueFactory(new PropertyValueFactory<>("id_Stagiaire"));
			   NomAB.setCellValueFactory(new PropertyValueFactory<>("Nom"));
			    PrenomAB.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
				
				
				TABLE4.setItems(dataTable4);
	}
	
	
	
}
