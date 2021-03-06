package visitorInterface;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Main extends Application {
	
	public static final String MAIN_SCREEN = "MainPage";
	public static final String ANIMAL_SCREEN = "Animal";
	public static final String MEMBERS_LOGIN_SCREEN = "MemberLogin";
	public static final String NEW_MEMBER_SCREEN = "NewMember";
	public static final String EXISTING_MEMBER_SCREEN = "ExistingMember";
	public static final String[] states = {"AL", "AK", "AZ", "AR" ,"CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "ME", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
	@Override
	public void start(Stage primaryStage) {
		try {
			ScreensController screensController = new ScreensController();
			screensController.loadScreen(Main.MAIN_SCREEN);
			screensController.loadScreen(Main.ANIMAL_SCREEN);
			screensController.loadScreen(Main.MEMBERS_LOGIN_SCREEN);
			screensController.loadScreen(Main.NEW_MEMBER_SCREEN);
			screensController.loadScreen(Main.EXISTING_MEMBER_SCREEN);
			screensController.setScreen(Main.MAIN_SCREEN);
			
			Group root = new Group();
			root.getChildren().addAll(screensController);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
