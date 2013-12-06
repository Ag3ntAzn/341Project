package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;

public class WelcomeScreenController implements Screen{
	ScreenController changedScreen;
	
	@FXML
	private MenuButton employeeDropDown;
	@FXML
	private MenuButton habitatDropDown;
	@Override
	public void initializeScreen() {
		
		
	}

	@Override
	public void setScreenParent(ScreenController controller) {
		changedScreen = controller;
	}
	
	@FXML
	private void employeeNameClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_TWO);
	}
	@FXML
	private void employeeSSNClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML 
	private void employeeHabitatClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML
	private void habitatManagerClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_TWO);
	}
	@FXML 
	private void habitatNameClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML
	private void habitatPenClick(ActionEvent e){
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
}
