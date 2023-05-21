package application;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ControllerMain  implements Initializable {

private Stage stage ;
private Scene scene;
private Parent root ;
    @FXML
    private Button AFF;

    @FXML
    private Button Add;

    @FXML
    private Button Delet;

    @FXML
    private Button Super;	

    @FXML
    private Button exit;
 

    @FXML
    void close(MouseEvent event) throws IOException {
    	Stage stage  = (Stage) ((Button)event.getSource()).getScene().getWindow();
    	stage.close();
    	
    	
    }
			
			
			
    private double x=0 ,y=0;
    public void add(ActionEvent event) throws IOException {
    	Parent root  = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
    	stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
    	
    	
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
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);
			
				}
			});
				
    	String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
    }
	
	
    public void DB(ActionEvent event) throws IOException {
    	
    	Parent root  = FXMLLoader.load(getClass().getResource("DataBase.fxml"));
    	stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
		
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
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);
			
				}
			});
				
    	String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
    }
	
    public void Delet(ActionEvent event) throws IOException {
    	Parent root  = FXMLLoader.load(getClass().getResource("DeletStag.fxml"));
    	stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
		
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
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);
			
				}
			});
				
    	String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
    }
    
    public void Supervisor(ActionEvent event) throws IOException {
    	Parent root  = FXMLLoader.load(getClass().getResource("Supervision.fxml"));
    	stage  = (Stage)((Node)event.getSource()).getScene().getWindow();
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	
		
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
					stage.setX(event.getScreenX() - x);
					stage.setY(event.getScreenY() - y);
			
				}
			});
				
    	String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
    }
    
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
