package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
public class Main extends Application {
	private double x=0 ,y=0;
@Override
	public void start(Stage primaryStage) {
		try {
			
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("nn.fxml"));
			Scene scene = new Scene(root);
			
			primaryStage.initStyle(StageStyle.DECORATED.UNDECORATED);
			primaryStage.setScene(scene);
			
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
						primaryStage.setX(event.getScreenX() - x);
						primaryStage.setY(event.getScreenY() - y);
				
					}
				});
				
			primaryStage.show();
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
//AddUser.fxml