package sploit.macrobot.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sploit.macrobot.model.Key;
import sploit.macrobot.model.MacroButton;

public class SetButtonLayoutController implements Initializable{

		
	@FXML
	private TextField firstField;
	
	@FXML
	private TextField secondField;
	
	@FXML
	private TextField lastField;
	
	@FXML
	private ChoiceBox<?> firstChoiceBox;
	
	@FXML
	private ChoiceBox<?> secondChoiceBox;
	
	@FXML
	private ChoiceBox<?> lastChoiceBox;
	
	@FXML
	private Button saveButton;
	
	@FXML
	private Button cancleButton;

	private Stage dialogStage;
	
	private MacroButton macroButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		firstField.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent) ->{
			firstField.setText(KeyEvent.getCode().toString());
		});
		
		secondField.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent) ->{
			secondField.setText(KeyEvent.getCode().toString());
		});
		
		lastField.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent) ->{
			lastField.setText(KeyEvent.getCode().toString());
		});
		
		saveButton.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) ->{
			if(setKeyValue()){
			closeStage();
			}
		});
		
		cancleButton.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) ->{
			closeStage();
		});
	}
	
	void setButton(MacroButton macroButton){
		this.macroButton = macroButton;
	}
	void setDialogStage(Stage stage){
		 this.dialogStage = stage;
	}

	void closeStage(){
		dialogStage.close();
	}
	boolean setKeyValue(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		if(!firstField.getText().equals("") || !secondField.getText().equals("") || !lastField.getText().equals("")){
		macroButton.setKey(firstField.getText(), secondField.getText(), lastField.getText());
		alert.setTitle("저장 완료");
		alert.setContentText(macroButton.getKey() + "를 저장 완료하였습니다!");
		alert.showAndWait();
		return true;
		} else {
			alert.setTitle("저장 실패");
			alert.setContentText("값을 입력해 주세요...");
			alert.showAndWait();
			return false;
		}
	}
		
}
