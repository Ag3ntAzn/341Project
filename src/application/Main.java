package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;


public class Main extends Application {
	
	public static final String WELCOME_SCREEN = "welcomeScreen";
	
	public static final String SCREEN_ONE = "searchOne";
	public static final String SCREEN_TWO = "searchTwo";
	@Override
	public void start(Stage primaryStage) {
		try {
			ScreenController sc = new ScreenController();
			sc.loadScreen(WELCOME_SCREEN);
			
			sc.loadScreen(SCREEN_ONE);
			sc.loadScreen(SCREEN_TWO);
			sc.setScreen(WELCOME_SCREEN);
			
			Group root = new Group();
			root.getChildren().addAll(sc);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			/* included code
			 * 
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
