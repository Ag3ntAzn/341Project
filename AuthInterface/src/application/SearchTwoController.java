package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SearchTwoController implements Screen{
	ScreenController screenChanger;
	
	@FXML
	private Text textOne;
	@FXML
	private Text textTwo;
	@FXML
	private TextField textBoxOne;
	@FXML
	private TextField textBoxTwo;
	@FXML
	private Button searchButton;
	
	
	@Override
	public void initializeScreen() {
		// TODO Auto-generated method stub
		//textOne.setText(screenChanger.getTopText());
		//textTwo.setText(screenChanger.getBottomText());
		textOne.setText("Hello");
	}

	@Override
	public void setScreenParent(ScreenController controller) {
		// TODO Auto-generated method stub
		screenChanger = controller;
	}
	@FXML
	private void performSearch(ActionEvent e){
		//TODO implemnt
	}
	@FXML
	private void goBack(ActionEvent e){
		screenChanger.setScreen(Main.WELCOME_SCREEN);
	}
}
