package ui;
import java.util.List;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Automata;
import model.Mealy;
import model.Moore;
import model.Node;

public class GUIController {
	
	@FXML
    private AnchorPane mainAnchorPane;
	
	@FXML
    private BorderPane mainBorderPane;
	
	@FXML
    private Button BAddState;

    @FXML
    private Button BRemoveState;

    @FXML
    private Button BFinishA;
	
	@FXML
	private VBox vboxMoore;
	
	private Character lastStateL;
	
	private boolean mooreSelected;
	
	private Automata automata;
	
	public GUIController() {
		automata = null;
		lastStateL = 'A';
		mooreSelected = false;
	}
	
	private void updateComboBoxes() {
		if (mooreSelected) {
			updateMooreComboBoxes();
			
		}else {
			updateMealyComboBoxes();
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void updateMooreComboBoxes() {
		char selectedOne = ' ';
		char selectedTwo = ' ';
		int output = -1;
		
		for (int i = 1; i < vboxMoore.getChildren().size(); i++) {
			if (((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(1)).getValue() != null) {
				selectedOne = ((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(1)).getValue();
			}
			
			if (((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(2)).getValue() != null) {
				selectedTwo = ((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(2)).getValue();
			}
			
			if (((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(3)).getValue() != null) {
				output = ((ComboBox<Integer>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(3)).getValue();
			}

			((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(1)).getItems().clear();
			((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(2)).getItems().clear();
			
			for (int j = 'A'; j <= lastStateL; j++) {
				((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(1)).getItems().add((char)j);
				((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(2)).getItems().add((char)j);
			}
			
			if (selectedOne != ' ' && selectedOne <= lastStateL) {
				((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(1)).setValue(selectedOne);
			}
			
			if (selectedTwo != ' ' && selectedTwo <= lastStateL) {
				((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(2)).setValue(selectedTwo);
			}
			
			if (output != -1) {
				((ComboBox<Integer>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(3)).setValue(output);
			}
			
			selectedOne = ' ';
			selectedTwo = ' ';
			output = -1;
		}
	}
	
	private void updateMealyComboBoxes() {

	}
	
	@SuppressWarnings("unchecked")
	@FXML
    void mooreAutomataSelected(ActionEvent event) {
		mooreSelected = true;
		BAddState.setDisable(false);
		BRemoveState.setDisable(false);
		BFinishA.setDisable(false);
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/moorePane.fxml"));
			fxmlLoader.setController(this);

			Parent Pane = fxmlLoader.load();

			mainBorderPane.setCenter(Pane);
			
			((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(1)).getChildren().get(1)).setValue('A');
			((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(1)).getChildren().get(2)).setValue('A');
			((ComboBox<Integer>) ((HBox) vboxMoore.getChildren().get(1)).getChildren().get(3)).setValue(1);
			((ComboBox<Integer>) ((HBox) vboxMoore.getChildren().get(1)).getChildren().get(3)).getItems().addAll(1,0);
			

		} catch (IOException ioException) {
			// TODO: handle exception with an alert that displays the content of the error.
		}
		
    }

	@FXML
    void mealyAutomataSelected(ActionEvent event) {

    }
	
	@FXML
	void addState(ActionEvent event) {
		if (mooreSelected) {
			addStateMoore();
			
		}else {
			addStateMealy();
			
		}
		
	}
	
	private void addStateMoore() {
		if (lastStateL < 90) {
			HBox newHBox = new HBox(4);
			
			Label stateLetter = new Label((char) (lastStateL + 1) + "");
			lastStateL ++;
			stateLetter.setStyle("-fx-font: 30 arial;");
			stateLetter.setPrefWidth(35);
			ComboBox<Character> ceroSuccesor = new ComboBox<>();
			ComboBox<Character> oneSuccesor = new ComboBox<>();
			ComboBox<Integer> output = new ComboBox<>();
			ceroSuccesor.setValue(lastStateL);
			oneSuccesor.setValue(lastStateL);
			output.getItems().addAll(1,0);
			output.setValue(1);
			RadioButton acceptance = new RadioButton("Acceptance state");
			
			newHBox.getChildren().addAll(stateLetter,ceroSuccesor,oneSuccesor,output,acceptance);
			
			newHBox.setSpacing(20);
			newHBox.setAlignment(Pos.CENTER);
			vboxMoore.getChildren().add(newHBox);
			
			updateMooreComboBoxes();
		}
	}
	
	private void addStateMealy() {
		
	}
	
	@FXML
	void removeState() {
		if (mooreSelected) {
			removeStateMoore();
			
		}else {
			removeStateMealy();
			
		}
		
	}
	
	private void removeStateMoore() {
		if (vboxMoore.getChildren().size() -1 > 1) {
			vboxMoore.getChildren().remove(vboxMoore.getChildren().size() - 1);
			lastStateL --;
			updateComboBoxes();
		}
	}
	
	private void removeStateMealy() {
		
	}
	
	
	@FXML
	void finishAutomata(ActionEvent event) {
		/*BAddState.setDisable(true);
		BRemoveState.setDisable(true);
		BFinishA.setDisable(true);
		mainBorderPane.setCenter(mainAnchorPane);*/
		if (mooreSelected) {
			automata = new Moore(mooreMachineInfo());
		}else {
			automata = new Mealy(mealyMachineInfo());
		}
		

	}
	
	private List<Node> mooreMachineInfo() {
		List<Node> nodes = new ArrayList<Node>();
		
		char state = 'A';
		List<Node> destinationEmpty = new ArrayList<Node>();
		
		for (int i = 1; i < vboxMoore.getChildren().size() ; i++) {
			Node newNode = new Node(state, destinationEmpty, false);	
			nodes.add(newNode);
			state ++;
			
		}
		
		for (int i = 1; i < vboxMoore.getChildren().size(); i++) {
			
			for (int j = 1; j < ((HBox) vboxMoore.getChildren().get(i)).getChildren().size(); j++) {
				
				switch (j) {
				case 1:
					char ceroSuccesorState = ((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(j)).getValue();

					break;

				case 2:
					char oneSuccesorState = ((ComboBox<Character>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(j)).getValue();

					break;
					
				case 3:
					boolean output = false;
					if (((ComboBox<Integer>) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(j)).getValue() == 1) {
						output = true;
					}
					
					break;
				case 4:
					boolean isAcceptance = ((RadioButton) ((HBox) vboxMoore.getChildren().get(i)).getChildren().get(j)).isSelected();

					break;
					
				}
				
				
			}
			
			
		}
		
		
		return nodes;
	}
	
	
	
	private List<Node> mealyMachineInfo() {
		List<Node> nodes = new ArrayList<Node>();
		
		
		return nodes;
	}
	
}


