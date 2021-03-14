package ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUIController {
	@FXML
	private VBox vbox;

	@FXML
	private HBox hboxA;
	
	private Character lastStateL;
	
	public GUIController() {
		lastStateL = 'A';
	}

	@FXML
	void addState(ActionEvent event) {
		
		if (lastStateL < 90) {
			HBox newHBox = new HBox(4);
			
			Label stateLetter = new Label((char) (lastStateL + 1) + "");
			lastStateL = (char) (lastStateL + 1);
			stateLetter.setStyle("-fx-font: 30 arial;");
			ComboBox<Character> ceroSuccesor = new ComboBox<>();
			ComboBox<Character> oneSuccesor = new ComboBox<>();
			RadioButton acceptance = new RadioButton("Acceptance state");
			
			newHBox.getChildren().addAll(stateLetter,ceroSuccesor,oneSuccesor,acceptance);
			
			newHBox.setSpacing(hboxA.getSpacing());
			newHBox.setAlignment(Pos.CENTER);
			vbox.getChildren().add(newHBox);
		}
		
		
	}
	
	@FXML
	void removeState() {
		if (vbox.getChildren().size() -1 > 1) {
			vbox.getChildren().remove(vbox.getChildren().size() - 1);
		}
		
	}

	
}


