package visitorInterface;

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
	private ListView<?> animalList;
	@FXML
	private Text errorMsg;

	@Override
	public void initializeScreen() {
		ObservableList<MenuItem> habitats = habitatList.getItems();
		MenuItem hab1 = new MenuItem("Hab 1");
		hab1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				populateSpecies(e);
			}
		});
		habitats.add(hab1);
		MenuItem hab2 = new MenuItem("Hab 2");
		hab2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				populateSpecies(e);
			}
		});
		habitats.add(hab2);
	}
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
		String text = ((MenuItem)e.getSource()).getText();
		habitatList.setText(text);
		switch (text) {
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
