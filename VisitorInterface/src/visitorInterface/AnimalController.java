package visitorInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;

public class AnimalController implements Screen {
	
	ScreensController screenChanger;
	
	@FXML
	private MenuButton habitatList;
	@FXML
	private ListView<?> speciesList;
	@FXML
	private ListView<?> animalSpecies;
	@FXML
	private ListView<?> animalNames;
	@FXML
	private ListView<?> animalDOB;
	@FXML
	private ListView<?> animalGender;
	@FXML
	private Text errorMsg;
	
	private List<ObservableList<String>> animalFields = new LinkedList<ObservableList<String>>();

	@SuppressWarnings("unchecked")
	@Override
	public void initializeScreen() {
		ObservableList<MenuItem> habitats = habitatList.getItems();
		try {
			String query = "SELECT name FROM habitats";
			ResultSet habitatNames = DatabaseQueryer.connectToAndQueryDatabase(query);
			if (habitatNames == null) {
				return;
			}
			while (habitatNames.next()) {
				MenuItem item = new MenuItem(habitatNames.getString(1));
				item.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						populateSpecies(e);
					}
				});
				habitats.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error reading from result set");
		}

		animalFields.add((ObservableList<String>) animalSpecies.getItems());
		animalFields.add((ObservableList<String>) animalNames.getItems());
		animalFields.add((ObservableList<String>) animalDOB.getItems());
		animalFields.add((ObservableList<String>) animalGender.getItems());
	}
	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void populateSpecies(ActionEvent e) {
		speciesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> speciesNames = (ObservableList<String>) speciesList.getItems();
		if (!speciesNames.isEmpty())
			speciesNames.clear();
		String text = ((MenuItem)e.getSource()).getText();
		habitatList.setText(text);
		String query = "";
		
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void searchForAnimals(ActionEvent e) {
		ObservableList<String> selected = (ObservableList<String>) speciesList.getSelectionModel().getSelectedItems();
		
		for (ObservableList<String> list : animalFields)
			if (!list.isEmpty())
				list.clear();
		//build where clause
		StringBuilder whereClause = new StringBuilder();
		for (String species : selected)
			whereClause.append("A.species=" + species + " OR ");
		whereClause.delete(whereClause.length() - 4, whereClause.length());

		try {
		String query = "SELECT * FROM Animals A WHERE " + whereClause.toString();
			ResultSet animalList = DatabaseQueryer.connectToAndQueryDatabase(query);
			if (animalList == null) {
				return;
			}
			while (animalList.next()) {
				animalFields.get(0).add(animalList.getString("species"));
				animalFields.get(1).add(animalList.getString("name"));
				animalFields.get(2).add(animalList.getDate("DOB").toString());
				animalFields.get(3).add(animalList.getString("gender"));
			}
		}
		catch (SQLException e2) {
			e2.printStackTrace();
			System.err.println("You done fucked up");
		}
	}
	
	@FXML
	private void goToMainPage(ActionEvent e) {
		screenChanger.setScreen(Main.MAIN_SCREEN);
	}
}
