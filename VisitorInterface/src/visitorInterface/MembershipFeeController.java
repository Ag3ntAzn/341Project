package visitorInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MembershipFeeController implements Screen {
	
	ScreensController screenChanger;

	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	@FXML
	private void goToMain(ActionEvent e) {
		screenChanger.setScreen(Main.MAIN_SCREEN);
	}
	
	@FXML
	private void submitMemberData(ActionEvent e) {
		
	}
	
	@FXML
	private void getMembershipFee(ActionEvent e) {
		System.out.println("boom");
	}
	
}
