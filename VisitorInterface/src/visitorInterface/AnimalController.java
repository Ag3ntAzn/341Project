package visitorInterface;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.text.Text;

public class AnimalController implements Screen {
	
	ScreensController screenChanger;
	
	@FXML
	private ListView<?> speciesList;
	@FXML
	private ListView<?> animalList;
	@FXML
	private Text errorMsg;

	@Override
	public void setScreenParent(ScreensController controller) {
		screenChanger = controller;
	}
	
	@FXML
	private void populateSpecies(ActionEvent e) {
		speciesList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		ObservableList<String> content = (ObservableList<String>) speciesList.getItems();
		if (!content.isEmpty())
			content.clear();
			//content.remove(0, content.size());
		switch (((MenuItem)e.getSource()).getText()) {
		case "Hab 1":
			content.addAll("Lion", "Wolf", "Tiger");
			break;
		case "Hab 2":
			content.addAll("Snake", "Lizard", "Alligator");
			break;
		}
		
	}
	
	@FXML
	private void searchForAnimals(ActionEvent e) {
		ObservableList<String> selected = (ObservableList<String>) speciesList.getSelectionModel().getSelectedItems();
		ObservableList<String> animals = (ObservableList<String>) animalList.getItems();
		if (!animals.isEmpty())
			animals.clear();
		if (selected.contains("Lion")) {
			animals.addAll("Lion 1\tMale\tA3", "Lion 2\tFemale\tA3");
		}
		if (selected.contains("Wolf"))
			animals.addAll("Wolf1\tMale\tA2", "Wolf2\tFemale\tA2");
		if (selected.contains("Snake"))
			animals.add("Snake1\tMale\tB1");
		if (selected.contains("Lizard"))
			animals.add("Lizard1\tMale\tB2");
	}
	
	@FXML
	private void goToMainPage(ActionEvent e) {
		screenChanger.setScreen(Main.MAIN_SCREEN);
	}
}
