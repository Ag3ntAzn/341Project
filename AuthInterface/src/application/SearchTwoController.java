package application;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView.EditEvent;
import javafx.scene.control.cell.TextFieldListCell;
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
	private String[] types;
	private String oldValue;
	private ResultSet result2;
	
	@Override
	public void initializeScreen() {
		((ListView<String>) lv1).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv2).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv3).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv4).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv5).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv6).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv7).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv8).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv9).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv10).setCellFactory(TextFieldListCell.forListView());
		((ListView<String>) lv11).setCellFactory(TextFieldListCell.forListView());
		
		((ListView<String>)lv1).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv1");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		((ListView<String>)lv1).setOnEditStart(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				getOldValue(event, "lv1");
			}
		});
		

		((ListView<String>)lv2).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event,"lv2");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv3).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv3");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv4).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv4");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv5).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv5");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv6).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv6");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv7).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv7");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv8).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv8");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv9).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event,"lv9");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv10).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv10");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		((ListView<String>)lv11).setOnEditCommit(new EventHandler<EditEvent<String>>(){ 
			@Override
			public void handle(EditEvent<String> event){
				try {
					editClicked(event, "lv11");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	@Override
	public void setScreenParent(ScreenController controller) {
		
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
		result2 = DataBaseQuery.connectToAndQueryDatabase(query);
		ResultSetMetaData meta = results.getMetaData();
		int columns = meta.getColumnCount();
		types = new String [columns];
		for(int i = 0; i< columns; i++){
			types[i] = meta.getColumnName(i+1);
		}

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
	private void editClicked(EditEvent<String> event, String s) throws SQLException{
		String updateQuery;
		if(tableToQuery.equals("habitatmanagers") ){
			updateQuery = "UPDATE habitatmanagers E SET ";
		}
		else{
			updateQuery = "UPDATE employees E SET ";
		}
		String attributeName="";
		int index=0;
		switch(s){
		case "lv1": attributeName = types[0];
		index = 1;
					break;
		case "lv2": attributeName = types[1];
		index = 2;			
		break;
		case "lv3": attributeName = types[2];
		index = 3;
		break;
		case "lv4": attributeName = types[3];
		index = 4;		
		break;
		case "lv5": attributeName = types[4];
		index = 5;		
		break;
		case "lv6": attributeName = types[5];
		index = 6;			
		break;
		case "lv7": attributeName = types[6];
		index = 7;
		break;
		case "lv8": attributeName = types[7];
		index = 8;		
		break;
		case "lv9": attributeName = types[8];
		index = 9;		
		break;
		case "lv10": attributeName = types[9];
		index = 10;		
		break;
		case "lv11": attributeName = types[10];
		index = 11;			
		break;
		}
		int index2 = event.getIndex();
		
		result2 = DataBaseQuery.connectToAndQueryDatabase(query);
		for(int i = 0; i<=index2; i++){
			result2.next();
		}
		//System.out.println(index);
		String value = result2.getString(index);
		//System.out.println(value);
		event.getSource().getItems().set(index2, event.getNewValue());
		

		
		updateQuery += "E."+attributeName + " = '" +event.getNewValue() + "' WHERE E."+attributeName+ " = '" +value + "'";
		System.out.println(updateQuery);
	
		
		DataBaseQuery.connectToAndUpdateDatabase(updateQuery);
		//result2 = DataBaseQuery.connectToAndUpdateDatabase(updateQuery);
/*	
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

*/		
	}
	
	private void getOldValue(EditEvent<String> event, String s){
		oldValue = event.getNewValue();
	}
}
