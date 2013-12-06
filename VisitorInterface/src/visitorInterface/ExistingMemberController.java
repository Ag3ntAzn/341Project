package visitorInterface;

import java.sql.ResultSet;
import java.sql.SQLException;

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

public class ExistingMemberController implements Screen{
	
	ScreensController screenChanger;
	
	@FXML
	private Text titleText;
	@FXML
	private TextField address1;
	@FXML
	private TextField address2;
	@FXML
	private TextField city;
	@FXML
	private MenuButton stateList;
	@FXML
	private TextField zipCode;
	@FXML
	private TextField birthDate;
	@FXML
	private PasswordField oldPassword;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField confirmPassword;
	
	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	@Override
	public void initializeScreen() {
		ObservableList<MenuItem> itemList= stateList.getItems();
		for (String state : Main.states) {
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
	
	@FXML
	private void updateMemberInformation(ActionEvent e) {
		//TODO: update new member information
		Dialog.showInfo("Information Updated", "Membership information successfully updated.");
	}
	
	@FXML
	private void changePassword(ActionEvent e) {
		if (oldPassword.getText().isEmpty() || newPassword.getText().isEmpty())
			Dialog.showError("Password change error", "Password Fields must not be empty");
		else if (oldPassword.getText().equals(newPassword.getText()))
			Dialog.showError("Password change error", "New password must be different from old password");
		else if (!newPassword.getText().equals(confirmPassword.getText()))
			Dialog.showError("Pasword change error", "Confirmation must match new password");
		else {
			//change password in database
			Dialog.showInfo("Password updated", "Password successfully upadated.");
		}
	}
	
	@FXML
	private void cancelMembership(ActionEvent e) {
		Dialog.buildConfirmation("Cancel Membership", "Are you sure you want to cancel your membership?")
			.addYesButton(new EventHandler<ActionEvent> () {
				@Override
				public void handle(ActionEvent e) {
					//cancel membership
				}
			})
			.addNoButton(new EventHandler<ActionEvent> () {
				@Override
				public void handle(ActionEvent e) {
					//do nothing
				}
			}).build().show();
	}
	
	@FXML
	private void logOut(ActionEvent e) {
		screenChanger.setScreen(Main.MEMBERS_LOGIN_SCREEN);
	}

	public void initializeScreen(int memberID) {
		try {
			ResultSet member = DatabaseQueryer.connectToAndQueryDatabase("SELECT * FROM members WHERE memberid=" + memberID);
			if (!member.isBeforeFirst()) 
				System.err.println("Error, member not found");
			else {
				titleText.setText("Welcome " + member.getString("lastname") + ", " + member.getString("firstname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error looking up member.");
		}
		
		
	}
}
