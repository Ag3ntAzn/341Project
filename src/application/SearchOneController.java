package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SearchOneController implements Screen{
	ScreenController screenChanger;
	
	@FXML
	private TextField textEntry;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private Text fieldName;
	
	@Override
	public void setScreenParent(ScreenController controller) {
		screenChanger = controller;
	}

	@Override
	public void initializeScreen() {
		// TODO: change to include appropriate scene title
		//fieldName.setText("habitat:"); 
		
	}
	
	@FXML
	private void performSearch(ActionEvent e){
		//TODO: get query results 
	}
	
	@FXML
	private void goBack(ActionEvent e){
		screenChanger.setScreen(Main.WELCOME_SCREEN);
	}
}
