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
		speciesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		animalFields.add((ObservableList<String>) animalSpecies.getItems());
		animalFields.add((ObservableList<String>) animalNames.getItems());
		animalFields.add((ObservableList<String>) animalDOB.getItems());
		animalFields.add((ObservableList<String>) animalGender.getItems());
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
					populateSpecies(e);
				}
			});
		}
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void populateSpecies(ActionEvent actionEvt) {
		ObservableList<String> speciesNames = (ObservableList<String>) speciesList.getItems();
		if (!speciesNames.isEmpty())
			speciesNames.clear();
		String habitatName = ((MenuItem)actionEvt.getSource()).getText();
		habitatList.setText(habitatName);
		try {
			String query = "SELECT DISTINCT species FROM pens left join livesin on pens.penid = livesin.penid WHERE habitatname='" + habitatName + "'";
			ResultSet speciesInHab = DatabaseQueryer.connectToAndQueryDatabase(query);
			while (speciesInHab.next())
				speciesNames.add(speciesInHab.getString("species"));
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("You have fucked up now");
		}
	}
	
	@SuppressWarnings("unchecked")
	@FXML
	private void searchForAnimals(ActionEvent e) {
		ObservableList<String> selected = (ObservableList<String>) speciesList.getSelectionModel().getSelectedItems();
		
		if (selected.isEmpty()) {
			errorMsg.setVisible(true);
			return;
		}
		else if (errorMsg.isVisible())
			errorMsg.setVisible(false);
		
		for (ObservableList<String> list : animalFields)
			if (!list.isEmpty())
				list.clear();
		queryForAnimalsAndDisplay(selected);
	}
	
	private void queryForAnimalsAndDisplay(ObservableList<String> selected) {
		//build where clause
		StringBuilder whereClause = new StringBuilder();
		for (String species : selected)
			whereClause.append("species='" + species + "' OR ");
		whereClause.delete(whereClause.length() - 4, whereClause.length());

		try {
		String query = "SELECT * FROM animals WHERE " + whereClause.toString();
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
