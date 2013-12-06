package application;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
	
	@FXML
	private ListView<?> lv1;
	@FXML
	private ListView<?> lv2;
	@FXML
	private ListView<?> lv3;
	@FXML
	private ListView<?> lv4;
	@FXML
	private ListView<?> lv5;
	@FXML
	private ListView<?> lv6;
	@FXML
	private ListView<?> lv7;
	@FXML
	private ListView<?> lv8;
	@FXML
	private ListView<?> lv9;
	@FXML
	private ListView<?> lv10;
	@FXML
	private ListView<?> lv11;
	private List<ObservableList<String>> somefields = new LinkedList<ObservableList<String>>();
	private String tableToQuery;
	private String fieldToQuery;
	private String query;
	private String placeholder;
	
	
	@Override
	public void initializeScreen() {
		// TODO Auto-generated method stub
		//textOne.setText(screenChanger.getTopText());
		//textTwo.setText(screenChanger.getBottomText());
		//textOne.setText("Hello");
	}
	
	@Override
	public void setScreenParent(ScreenController controller) {
		// TODO Auto-generated method stub
		screenChanger = controller;
	}
	@FXML
	private void performSearch(ActionEvent e) throws SQLException{
		String firstName = textBoxOne.getText();
		String lastName = textBoxTwo.getText();
		
		ObservableList<String> one = (ObservableList<String>) lv1.getItems();
		if (!one.isEmpty())
			one.clear();
		ObservableList<String> two = (ObservableList<String>) lv2.getItems();
		if (!two.isEmpty())
			two.clear();
		ObservableList<String> three = (ObservableList<String>) lv3.getItems();
		if (!three.isEmpty())
			three.clear();
		ObservableList<String> four = (ObservableList<String>) lv4.getItems();
		if (!four.isEmpty())
			four.clear();
		ObservableList<String> five = (ObservableList<String>) lv5.getItems();
		if (!five.isEmpty())
			five.clear();
		ObservableList<String> six = (ObservableList<String>) lv6.getItems();
		if (!six.isEmpty())
			six.clear();
		ObservableList<String> seven = (ObservableList<String>) lv7.getItems();
		if (!seven.isEmpty())
			seven.clear();
		ObservableList<String> eight = (ObservableList<String>) lv8.getItems();
		if (!eight.isEmpty())
			eight.clear();
		ObservableList<String> nine = (ObservableList<String>) lv9.getItems();
		if (!nine.isEmpty())
			nine.clear();
		ObservableList<String> ten = (ObservableList<String>) lv10.getItems();
		if (!ten.isEmpty())
			ten.clear();
		ObservableList<String> eleven = (ObservableList<String>) lv11.getItems();
		if (!eleven.isEmpty())
			eleven.clear();
		somefields.add(one);
		somefields.add(two);
		somefields.add(three);
		somefields.add(four);
		somefields.add(five);
		somefields.add(six);
		somefields.add(seven);
		somefields.add(eight);
		somefields.add(nine);
		somefields.add(ten);
		somefields.add(eleven);
		
		//String searchKey = textEntry.getText();
		if(tableToQuery == "employees"){
			if(firstName.equalsIgnoreCase(""))
				query = placeholder+ "lastName = '" + lastName + "')";
			else if(lastName.equalsIgnoreCase(""))
				query = placeholder + "firstName = '" +firstName + "')";
			else{
				query = placeholder +"firstName = '" + firstName+ "' AND lastName = '" +lastName+ "')";
			}
		}
		else if(tableToQuery == "habitatmanagers"){
			if(firstName.equalsIgnoreCase(""))
				query = placeholder+ "lastName = '" + lastName + "'";
			else if(lastName.equalsIgnoreCase(""))
				query = placeholder + "firstName = '" +firstName + "'";
			else{
				query = placeholder +"firstName = '" + firstName+ "' AND lastName = '" +lastName+ "'";
			}
		}
		System.out.println(query);
		ResultSet results = DataBaseQuery.connectToAndQueryDatabase(query);
		ResultSetMetaData meta = results.getMetaData();
		int columns = meta.getColumnCount();
	
		
		if (results == null) {
			return;
		}
		try {
			while (results.next()) {
				for(int i = 1; i<=columns;i++){
					somefields.get(i-1).add(results.getString(i));
				}
				
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.err.println("Error reading from result set");
		}
		
		
	}
	@FXML
	private void goBack(ActionEvent e){
		for(ObservableList<String> list : somefields){
			list.clear();
		}
		textBoxOne.clear();
		textBoxTwo.clear();
		screenChanger.setScreen(Main.WELCOME_SCREEN);
	}

	public void setScreenParameters(String string, String string2) {
		textOne.setText(string);
		textTwo.setText(string2);
		
		switch(string){
		case "Manager First Name: ": tableToQuery = "habitatmanagers";
								     fieldToQuery = "";
								     placeholder = "select habitatname from habitatmanagers left join employees E on "
								     		+ "E.ssn = habitatmanagers.ssn where E.";
								     
								     break;
								     
		case "First Name: ": tableToQuery = "employees";
							 //fieldToQuery = "firstname";
							 placeholder = "(select * from " + tableToQuery + " where ";
							 break;
		}
		
	}
}
