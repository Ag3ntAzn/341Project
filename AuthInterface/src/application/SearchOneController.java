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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SearchOneController implements Screen{
	ScreenController screenChanger;
	
	@FXML
	private TextField textEntry;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private Text fieldName;
 
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
	public void setScreenParent(ScreenController controller) {
		screenChanger = controller;
		
	}

	@Override
	public void initializeScreen() {
		// TODO: change to include appropriate scene title
		//fieldName.setText("habitat:"); 
		
	}
	
	@FXML
	private void performSearch(ActionEvent e) throws SQLException{
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
		
		
		
		String searchKey = textEntry.getText();
		query = placeholder + searchKey +"')";
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
		for(ObservableList<String> list : somefields)
			list.clear();
		screenChanger.setScreen(Main.WELCOME_SCREEN);
	}
	
	public void setParameter(String s1){
		fieldName.setText(s1);
		switch(s1){
		case "SSN: ": tableToQuery = "employees";
					  fieldToQuery = "ssn";
					  placeholder = "(select * from " + tableToQuery + " where " +fieldToQuery+ " = '";
					  break;
		case "Habitat Name: ":
					  tableToQuery = "penkeepers left join pens on penkeepers.penid = pens.penid";
					  fieldToQuery = "habitatname";
					  placeholder =  "(select * from habitats H where H.name = '";
					  /*
					   * select habitatname from habitatmanagers left join employees on employees.ssn = habitatmanagers.ssn 
					   * where employees.firstname='bob' and employees.lastname='freeman';
					   */
					  break;
		case "Pen Number: ":
				      placeholder = "(select habitatname from pens where pens.penid = '";
					  break;
		case "Habitat Name:":
				      tableToQuery = "penkeepers left join pens on penkeepers.penid = pens.penid";
			          fieldToQuery = "habitatname";
			          placeholder =  "select * from employees E where E.ssn in (select ssn from " + tableToQuery + " where " +fieldToQuery+ " = '";
			          /*
			           * select habitatname from habitatmanagers left join employees on employees.ssn = habitatmanagers.ssn 
			           * 	where employees.firstname='bob' and employees.lastname='freeman';
			           */
			          break;
		}	
	}
}

