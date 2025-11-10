package application;
	
import application.util.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		StageManager.initialize(stage);
//		StageManager.show("UI/Insert");
//		StageManager.show("UI/Read");
		StageManager.show("UI/Update");
//		StageManager.show("Main");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
