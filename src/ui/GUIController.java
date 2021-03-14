package ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIController {
	@FXML
	private VBox vbox;
	
	private Character lastStateL;
	
	public GUIController() {
		lastStateL = 'A';
	}
	
	
	private void updateComboBoxes() {
		for (int i = 1; i < vbox.getChildren().size(); i++) {
			for (int j = 'A'; j <= lastStateL; j++) {
				((ComboBox<Character>) ((HBox) vbox.getChildren().get(i)).getChildren().get(1)).getItems().add((char)j);
				((ComboBox<Character>) ((HBox) vbox.getChildren().get(i)).getChildren().get(2)).getItems().add((char)j);
			}
		}
		
	}
	
	@FXML
	void addState(ActionEvent event) {
		
		if (lastStateL < 90) {
			HBox newHBox = new HBox(4);
			
			Label stateLetter = new Label((char) (lastStateL + 1) + "");
			lastStateL ++;
			stateLetter.setStyle("-fx-font: 30 arial;");
			stateLetter.setPrefWidth(35);
			ComboBox<Character> ceroSuccesor = new ComboBox<>();
			ComboBox<Character> oneSuccesor = new ComboBox<>();
			RadioButton acceptance = new RadioButton("Acceptance state");
			
			newHBox.getChildren().addAll(stateLetter,ceroSuccesor,oneSuccesor,acceptance);
			
			newHBox.setSpacing(40);
			newHBox.setAlignment(Pos.CENTER);
			vbox.getChildren().add(newHBox);
			
			updateComboBoxes();
		}
		
		
	}
	
	@FXML
	void removeState() {
		if (vbox.getChildren().size() -1 > 1) {
			vbox.getChildren().remove(vbox.getChildren().size() - 1);
			lastStateL --;
		}
		
	}

	
}


