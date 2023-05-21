package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ControllerSupervis implements Initializable {
	private ObservableList<ModelStag> dataTable2;
	
	@FXML
    private ImageView close;

    @FXML
    public Button exit;
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
	    private RadioButton Absent;
	    @FXML
	    private RadioButton present;
	    @FXML
	    public Button ExitEnca;
	    @FXML
	    private Button Actul;
	    @FXML
	    private Button Fin;
	   
	    @FXML
	    private Button Set;
	    
	    
	    
static String key;
static String encad;
	   final  FileChooser fc = new FileChooser();
	    
	    public Stage stage1 ;
	    public Scene scene1;
	    public Parent root ;
	    public double x=0 ,y=0;
	    public void closeEnc(MouseEvent event) {
	    	Stage stage  = (Stage) ((Button)event.getSource()).getScene().getWindow();
 	    	stage.close();
	    }
	    public void close(MouseEvent event) throws IOException {
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
	    
	    
	    /*
	     public void Choose(MouseEvent event) {
			
	    	 fc.setTitle("Rapport De stage");
	    	 fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files","*.docx","*.doc","*.docm"));
	    	 File file = fc.showOpenDialog(null);
	    	 if (file != null) {
	    		 System.out.println(file.getAbsolutePath() + "\n");
	    	 }else {
	    		 System.out.println("invalid file");
	    	 }
	    	 
	    	 
	    	 
		}
	     
	     */
	    static String Stat="";
	     public void Statu(MouseEvent event) {
				
	 	    if(Absent.isSelected()) {
	 	    	Stat =Absent.getText();
	 	    }else if (present.isSelected()) {
	 	    	Stat = present.getText();
	 	    }
	 	    	 
	 	    	 
	 	    	 
	 		}
	     static int i=0;
    	 
	     public void selec() {
			 i =	TABLE2.getSelectionModel().getSelectedItem().getID();
		 

		}
	    
	     
	     public void Addstatur(MouseEvent event) throws SQLException, ClassNotFoundException {
	    	 if (key.equals("Encadrant")) {
	    		 
		    	 String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    	 
		    	 
		    	 if(i==0 || Stat.equals("")) {
		    		
		    	 }else {
		    		

			    	 
			    	 Connection conn;
						
					 PreparedStatement ps;
						
								Class.forName("com.mysql.cj.jdbc.Driver");
								conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/pfe","root","");
								 ps = conn.prepareStatement("insert into absentes(Date,Status,id_Stagiaires) values(?,?,?);");
								 Statement  statement = conn.createStatement();
								 ResultSet resultset = null;
						ps.setString(1,  date);
						ps.setString(2, Stat);	
						
							ps.setInt(3, i);
						
							
						
						
						
						
						
						
						int x1 = ps.executeUpdate();
						if(x1>0) {
							
						}else {
							
						
						
						}	
						
		    	 }
	    	 }
	    	
	    	 
	    	 
	    	 
	    	 
	    	 
	     }
	    
	  
	    
	    
	     
	     
	    public void  Finir(MouseEvent event) {
	    	TABLE2.setVisible(true);
			dataTable2 = FXCollections.observableArrayList();
					
			String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	    	
	    	//System.out.println(date);
					
					try {
						Connection con = (Connection) DBConnection.getConnection();
						ResultSet res =  con.createStatement().executeQuery("select * from stagiare where Date_Fin = '"+date+"'");
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
	    
	    public void Actualiser(MouseEvent event){
	    	
	    	if(key.equals("Encadrant")) {
	    		TABLE2.setVisible(true);
				dataTable2 = FXCollections.observableArrayList();
						
				String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    	
		    	//System.out.println(date);
						
						try {
							Connection con = (Connection) DBConnection.getConnection();
							ResultSet res =  con.createStatement().executeQuery("select * from stagiare where Encadrant = '"+encad+"'  ");
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
	    	}else {
	    		
	    		TABLE2.setVisible(true);
				dataTable2 = FXCollections.observableArrayList();
						
				String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    	
		    	//System.out.println(date);
						
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
	    
	     
	     
	     
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			
			
			if(key.equals("Encadrant")) {
				ExitEnca.setVisible(true);
				exit.setVisible(false);
				Absent.setVisible(true);
				present.setVisible(true);
				Set.setVisible(true);
				
				TABLE2.setVisible(true);
				dataTable2 = FXCollections.observableArrayList();
						
				String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    	
		    	//System.out.println(date);
						
						try {
							Connection con = (Connection) DBConnection.getConnection();
							ResultSet res =  con.createStatement().executeQuery("select * from stagiare where Encadrant = '"+encad+"'   ");
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
				
			}else {
				ExitEnca.setVisible(false);
				exit.setVisible(true);
				Absent.setVisible(false);
				present.setVisible(false);
				Set.setVisible(false);
				
				
				TABLE2.setVisible(true);
				dataTable2 = FXCollections.observableArrayList();
						
				String date= new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		    	
		    	//System.out.println(date);
						
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

}
