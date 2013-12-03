package visitorInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainPageController implements Screen {
	
	ScreensController screenChanger;
	
	@Override
	public void initializeScreen() {
		
	}
	
	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	@FXML
	private void goToAnimalLocationScreen(ActionEvent e) {
		screenChanger.setScreen(Main.ANIMAL_SCREEN);
	}
	
	@FXML
	private void goToMembersLoginScreen(ActionEvent e) {
		screenChanger.setScreen(Main.MEMBERS_LOGIN_SCREEN);
	}
	
	@FXML
	private void goToMembershipFeeScreen(ActionEvent e) {
		screenChanger.setScreen(Main.MEMBERSHIP_FEE_SCREEN);
	}
}
