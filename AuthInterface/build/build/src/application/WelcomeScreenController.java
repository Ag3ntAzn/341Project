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
		SearchTwoController toChange = (SearchTwoController) (changedScreen.getController(Main.SCREEN_TWO));
		toChange.setScreenParameters("First Name: ", "Last Name: ");
		changedScreen.setScreen(Main.SCREEN_TWO);
	}
	@FXML
	private void employeeSSNClick(ActionEvent e){
		SearchOneController controller1 = (SearchOneController)(changedScreen.getController(Main.SCREEN_ONE));
		controller1.setParameter("SSN: ");
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML 
	private void employeeHabitatClick(ActionEvent e){
		SearchOneController controller1 = (SearchOneController)(changedScreen.getController(Main.SCREEN_ONE));
		controller1.setParameter("Habitat Name:");
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML
	private void habitatManagerClick(ActionEvent e){
		SearchTwoController toChange = (SearchTwoController) (changedScreen.getController(Main.SCREEN_TWO));
		toChange.setScreenParameters("Manager First Name: ", "Manager Last Name: ");
		changedScreen.setScreen(Main.SCREEN_TWO);
	}
	@FXML 
	private void habitatNameClick(ActionEvent e){
		SearchOneController controller1 = (SearchOneController)(changedScreen.getController(Main.SCREEN_ONE));
		controller1.setParameter("Habitat Name: ");
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
	@FXML
	private void habitatPenClick(ActionEvent e){
		SearchOneController controller1 = (SearchOneController)(changedScreen.getController(Main.SCREEN_ONE));
		controller1.setParameter("Pen Number: ");
		changedScreen.setScreen(Main.SCREEN_ONE);
	}
}
