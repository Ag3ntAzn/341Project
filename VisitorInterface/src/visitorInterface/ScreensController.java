package visitorInterface;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

public class ScreensController extends StackPane {
	
	private HashMap<String, Node> screens = new HashMap<>();
	private HashMap<String, Screen> controllers = new HashMap<> ();
	
	public void addScreen(String name, Node screen) {
		screens.put(name, screen);
	}
	public void addController(String name, Screen controller) {
		controllers.put(name, controller);
	}
	public void loadScreen(String name) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));
		Parent screenToLoad = (Parent) loader.load();
		Screen screenController = ((Screen) loader.getController());
		screenController.setScreenParent(this);
		screenController.initializeScreen();
		addScreen(name, screenToLoad);
		addController(name, screenController);
	}
	
	public boolean setScreen(final String name) {
		if (screens.get(name) != null) { //screen is loaded
			//check if a screen is already loaded
			if (!getChildren().isEmpty()) {
				getChildren().remove(0); //remove current screen
				getChildren().add(0, screens.get(name)); //add new screen
			}
			//otherwise just show screen
			else
				getChildren().add(screens.get(name));
			return true;
		}
		else {
			System.out.println("Screen not loaded");
			return false;
		}
	}
	
	public Screen getController(final String name) {
		return controllers.get(name);
	}
}
