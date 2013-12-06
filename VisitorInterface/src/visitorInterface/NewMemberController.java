package visitorInterface;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
	private TextField firstName;
	@FXML
	private TextField lastName;
	@FXML
	private TextField streetAdd1;
	@FXML
	private TextField streetAdd2;
	@FXML
	private TextField city;
	@FXML
	private MenuButton stateList;
	@FXML
	private TextField zipCode;
	@FXML
	private TextField birthDate;
	@FXML
	private TextField phoneNumber;
	@FXML
	private TextField email;
	@FXML
	private TextField confirmEmail;
	@FXML
	private TextField userName;
	@FXML
	private PasswordField password;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Text errorText;
	
	private LinkedList<TextField> requiredTextFields = new LinkedList<TextField>();
	
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
		
		requiredTextFields.add(firstName);
		requiredTextFields.add(lastName);
		requiredTextFields.add(streetAdd1);
		requiredTextFields.add(city);
		requiredTextFields.add(zipCode);
		requiredTextFields.add(birthDate);
		requiredTextFields.add(phoneNumber);
		requiredTextFields.add(email);
		requiredTextFields.add(confirmEmail);
		requiredTextFields.add(userName);
		requiredTextFields.add(password);
		requiredTextFields.add(confirmPassword);
		
	}
	
	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	public void populateHabitats() {
		ObservableList<MenuItem> habitats = habitatList.getItems();
		DatabaseQueryer.populateMenuButtonWithHabitatNames(habitats);
		for (MenuItem item : habitats){
			item.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					getMembershipFee(e);
				}
			});
		}
	}
	
	@FXML
	private void goToMain(ActionEvent e) {
		screenChanger.setScreen(Main.MAIN_SCREEN);
	}
	
	@FXML
	private void submitMemberData(ActionEvent e) {
		if (!checkRequiredFields()) {
			errorText.setText("All fields are required.");
			return;
		}
		if (feeDisplay.getText().isEmpty()) {
			errorText.setText("Please choose a habitat.");
			return;
		}
		StringBuilder errorMsg = new StringBuilder();
		if (!checkZipCodeAndBirthDate(errorMsg)) {
			errorText.setText(errorMsg.toString());
			return;
		}
		if (!checkUsernameAndPassword(errorMsg)) {
			errorText.setText(errorMsg.toString());
			return;
		}
		if (!checkEmailAndPhoneNum(errorMsg)) {
			errorText.setText(errorMsg.toString());
			return;
		}
		StringBuilder insertMemberStmt = new StringBuilder("INSERT INTO members VALUES (");
		StringBuilder insertLoginStmt = new StringBuilder("INSERT INTO account VALUES (");
		try {
			buildInsertStatements(insertMemberStmt, insertLoginStmt);
			DatabaseQueryer.connectToAndUpdateDatabase(insertMemberStmt.toString());
			DatabaseQueryer.connectToAndUpdateDatabase(insertLoginStmt.toString());
			Dialog.showInfo("Account Created", "Thank you for purchasing a membership!");
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println("Insert FUCKED UP!");
		}
	}

	private void buildInsertStatements(StringBuilder insertMemberStmt, StringBuilder insertLoginStmt) throws SQLException{
		int memberID = generateMemberID();
		insertMemberStmt.append(memberID + ", "
						+ "'" + habitatList.getText() + "', "
						+ "'" + firstName.getText() + "', "
						+ "'" + lastName.getText() + "', "
						+ "'" + streetAdd1.getText() + " "
						+ streetAdd2.getText() + " "
						+ city.getText() + " "
						+ stateList.getText() + " "
						+ zipCode.getText() + "', "
						+ generateDoB() + ", ");
		Date currTime = new Date(System.currentTimeMillis());
		insertMemberStmt.append(currTime.toString() + ", ");
		currTime.setTime(currTime.getTime() + (long)3.15569e10);
		insertMemberStmt.append(currTime.toString() + ", 0, "
						+ "'" + email.getText() + "', "
						+ "'" + phoneNumber.getText() + "')");
		insertLoginStmt.append("'" + userName.getText() + "', "
							+ "'" + password.getText() + "', "
							+ memberID + ")");
	}

	private int generateMemberID() throws SQLException{
		ResultSet maxMemberID = DatabaseQueryer.connectToAndQueryDatabase("SELECT MAX(memberid) as maxMemberID FROM members");
		maxMemberID.first();
		int memberID = maxMemberID.getInt(1) + 1;
		return memberID;
	}

	private String generateDoB() {
		String[] splitDate = birthDate.getText().split("/");
		return splitDate[2] + "-" + splitDate[0] + "-" + splitDate[1];
		
	}

	private boolean checkZipCodeAndBirthDate(StringBuilder errorMsg) {
		boolean noErrors = true;
		if (!zipCode.getText().matches("[0-9]+")) {
			errorMsg.append("Invalid ZipCode\n");
			noErrors = false;
		}
		if (!birthDate.getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
			errorMsg.append("Invalid birthDate. Please follow specified format: mm/dd/yyyy");
			noErrors = false;
		}
		return noErrors;
	}

	private boolean checkRequiredFields() {
		boolean allFilled = true;
		for (TextField field : requiredTextFields) {
			if (field.getText().isEmpty())
				allFilled = false;
		}
		if (stateList.getText().equals("--"))
			allFilled = false;
		return allFilled;
	}
	
	private boolean checkUsernameAndPassword(StringBuilder errorMsg) {
		boolean noErrors = true;
		if (!password.getText().equals(confirmPassword.getText())) {
			errorMsg.append("Password fields must match.\n");
			noErrors = false;
		}
		try {
			ResultSet results = DatabaseQueryer.connectToAndQueryDatabase("SELECT * FROM accounts WHERE username='" + userName.getText() + "'");
			if (results.isBeforeFirst()) {
				errorMsg.append("User Name already taken. \n");
				noErrors = false;
			}
			System.out.println(results.getMetaData().getColumnCount());
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Oh NOES! Username lookup failed!");
		}
		return noErrors;
	}
	
	private boolean checkEmailAndPhoneNum(StringBuilder errorMsg) {
		boolean noErrors = true;
		if (!email.getText().equals(confirmEmail.getText())) {
			errorMsg.append("Emails must match.\n");
			noErrors = false;
		}
		if (!email.getText().matches("[^@]+@[\\w\\-\\.]+\\.[a-z]+")) {
			errorMsg.append("Invalid Email\n");
			noErrors = false;
		}
		if (!phoneNumber.getText().matches("\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}")) {
			errorMsg.append("Invalid PhoneNumber");
			noErrors = false;
		}
		return noErrors;
	}
	
	@FXML
	private void getMembershipFee(ActionEvent e) {
		String name = ((MenuItem)e.getSource()).getText();
		habitatList.setText(name);
		String query = "SELECT membershipfee FROM habitats WHERE name='" + name + "'";
		try {
			ResultSet fee = DatabaseQueryer.connectToAndQueryDatabase(query);
			if (fee.absolute(2)) {
				System.err.println("You done fucked up the query, there shouldn't be two fees for a habitat!");
				return;
			}
			else {
				fee.first();
				feeDisplay.setText(Double.toString(fee.getDouble("membershipfee")));
			}
		}
		catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
			System.err.println("Fucked up reading from the resultset.");
		}
	}
}
