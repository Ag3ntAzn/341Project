package visitorInterface;

import name.antonsmirnov.javafx.dialog.Dialog;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NewMemberController implements Screen {
	
	ScreensController screenChanger;
	
	@FXML
	private MenuButton habitatList;
	@FXML
	private Text feeDisplay;
	@FXML
	private MenuButton stateList;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confirmPassword;
	
	@Override
	public void initializeScreen() {
		ObservableList<MenuItem> itemList= stateList.getItems();
		for (String state : Main.states){
			MenuItem item = new MenuItem(state);
			item.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					stateList.setText(((MenuItem)e.getSource()).getText());
				}
			});
			itemList.add(item);
		}
	}
	
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
		if (password.getText().isEmpty() || username.getText().isEmpty()) {
			Dialog.showError("Account Creation Error", "Password or user name must not be empty.");
		}
		else if (!password.getText().equals(confirmPassword.getText()))
			Dialog.showError("Account Creation Error", "Password fields must match.");
		else if (feeDisplay.getText().isEmpty())
			Dialog.showError("Account Creation Error", "Please choose a habitat.");
		else {
			//insert member
			Dialog.showInfo("Account Created", "Thank you for purchasing a membership!");
		}
	}
	
	@FXML
	private void getMembershipFee(ActionEvent e) {
		String text = ((MenuButton)e.getSource()).getText();
		habitatList.setText(text);
	}
	
}
