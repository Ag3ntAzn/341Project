package visitorInterface;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class MemberLoginController implements Screen {
	
	ScreensController screenChanger;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button loginButton;

	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
		ChangeListener<String> listener = new ChangeListener<String>() {
			@Override
			public void changed(final ObservableValue<? extends String> observable, final String oldValue, final String newValue) {
				if (username.getText() != null && password.getText() != null && !username.getText().isEmpty() && !password.getText().isEmpty())
					loginButton.setDisable(false);
				else
					loginButton.setDisable(true);
			}
		};
		username.textProperty().addListener(listener);
		password.textProperty().addListener(listener);
	}
	
	@FXML
	private void goToMain(ActionEvent e) {
		username.clear();
		password.clear();
		screenChanger.setScreen(Main.MAIN_SCREEN);
	}
	
	@FXML
	private void submitLogin(ActionEvent e) {
		if (!loginButton.isDisabled())
			System.out.println("login");
	}
}
