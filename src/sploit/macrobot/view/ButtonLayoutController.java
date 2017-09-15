package sploit.macrobot.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import jssc.SerialPortException;
import jssc.SerialPortList;
import sploit.macrobot.BinaryFile;
import sploit.macrobot.Main;
import sploit.macrobot.Serial;
import sploit.macrobot.model.Key;
import sploit.macrobot.model.MacroButton;

public class ButtonLayoutController implements Initializable {
	
	@FXML
	private Button btn0;
	
	@FXML
	private Button btn1;
	
	@FXML
	private Button btn2;
	
	@FXML
	private Button btn3;
	
	@FXML
	private Button btn4;
	
	@FXML
	private Button btn5;
	
	@FXML
	private Button btnOpen;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnUpload;

	@FXML
	private Label btn0Label;
	
	@FXML
	private Label btn1Label;
	
	@FXML
	private Label btn2Label;
	
	@FXML
	private Label btn3Label;
	
	@FXML
	private Label btn4Label;

	@FXML
	private Label btn5Label;
	
	//@FXML
	//private Button btn0;
		private Stage primaryStage;
	
		
		MacroButton button[] = new MacroButton[6];
		void setLabel(){
			 btn0Label.setText(button[0].getKey());
			  btn1Label.setText(button[1].getKey());
			  btn2Label.setText(button[2].getKey());
			  btn3Label.setText(button[3].getKey());
			  btn4Label.setText(button[4].getKey());
			  btn5Label.setText(button[5].getKey());
		}
	//private MouseEventHandlerBtnN btnNHandler = new MouseEventHandlerBtnN();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 0; i < 6; i++){
			button[i] = new MacroButton();
		}
		 
		setLabel();
		  
			btn0.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[0]);
				  btn0Label.setText(button[0].getKey());
			});
			btn1.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[1]);
				  btn1Label.setText(button[1].getKey());
			});
			btn2.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[2]);
				  btn2Label.setText(button[2].getKey());
			});
			btn3.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[3]);
				  btn3Label.setText(button[3].getKey());
			});
			btn4.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[4]);
				  btn4Label.setText(button[4].getKey());
			});
			btn5.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) -> {
				  showSetButtonDialog(button[5]);
				  btn5Label.setText(button[5].getKey());
			});
			
			btnOpen.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) ->{
				 try {
					setButtonValue();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 setLabel();
			});
			btnSave.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) ->{
				
			});
			btnUpload.addEventFilter(MouseEvent.MOUSE_CLICKED, (MouseEvent) ->{
				try {
					uploadButtonKey();
				} catch (SerialPortException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
	}
	 void setButtonValue() throws IOException {
		 FileChooser fileChooser = new FileChooser();
		 FileInputStream inFile = new FileInputStream(fileChooser.showOpenDialog(null));
		 BinaryFile binaryFile = new BinaryFile(inFile);
		 for(int i = 0; i < 6; i++){
			 binaryFile.setButton(button[i]);
		 }
		 
	}
	
	 void uploadButtonKey() throws SerialPortException{
		 String btnKey[] = new String[6];
		 StringBuffer sendKeyBuffer[]= new StringBuffer[6];
		 for(int i = 0; i < 6; i++){
			 int k = 0;
			 sendKeyBuffer[i] = new StringBuffer();
			 btnKey[i] = button[i].getKey();
			 
			 for(int j = 0; j < 3; j++){
				 StringBuffer buffer = new StringBuffer();
				 while(true){
					 if(k == btnKey[i].length()){
						 break;
					 }else if(btnKey[i].charAt(k) == '/'){
						 if(buffer.length() == 0){
							 buffer.append('!');
						 }
						 k++;
						 break;
					 }
					 buffer.append(btnKey[i].charAt(k));
					 k++;
				 }
				 switch(buffer.toString()){
				 case "CONTROL" :
					 sendKeyBuffer[i].append('c');
					 break;
				 case "ALT" :
					 sendKeyBuffer[i].append('a');
					 break;
				 case "SHIFT" :
					 sendKeyBuffer[i].append('s');
					 break;
				 case "DELETE" :
					 sendKeyBuffer[i].append('d');
					 break;
				 case "SPACE" :
					 sendKeyBuffer[i].append('r');
					 break;
				 case "TAB" :
					 sendKeyBuffer[i].append('t');
					 break;
				 case "CAPS" :
					 sendKeyBuffer[i].append('p');
					 break;
				 case "PRINTSCREEN" :
					 sendKeyBuffer[i].append('i');
					 break;
				 case "HOME" :
					 sendKeyBuffer[i].append('h');
					 break;
				 case "ESC" :
					 sendKeyBuffer[i].append('k');
					 break;
				 case "PAGE_UP" :
					 sendKeyBuffer[i].append('u');
					 break;
				 case "PAGE_DOWN" :
					 sendKeyBuffer[i].append('n');
					 break;
				 case "END" :
					 sendKeyBuffer[i].append('e');
					 break;
				 case "WINDOWS" :
					 sendKeyBuffer[i].append('w');
					 break;
				 case "SLASH" :
					 sendKeyBuffer[i].append((char)47);
					 break;
				 case "PERIOD" :
					 sendKeyBuffer[i].append((char)46);
					 break;
				 case "COMMA" :
					 sendKeyBuffer[i].append((char)44);
					 break;
				 case "QUOTE" :
					 sendKeyBuffer[i].append((char)39);
					 break;
				 case "SEMICOLON" :
					 sendKeyBuffer[i].append((char)59);
					 break;
				 case "OPEN_BRACKET" :
					 sendKeyBuffer[i].append((char)91);
					 break;
				 case "CLOSE_BRACKET" :
					 sendKeyBuffer[i].append((char)93);
					 break;
				 case "BACK_SLASH" :
					 sendKeyBuffer[i].append((char)92);
					 break;
				 case "BACK_SPACE" :
					 sendKeyBuffer[i].append('b');
					 break;
				 case "EQUALS" :
					 sendKeyBuffer[i].append((char)61);
					 break;
				 case "MINUS" :
					 sendKeyBuffer[i].append((char)45);
					 break;
				 case "F1" :
					 sendKeyBuffer[i].append((char)34);
					 break;
				 case "F2" :
					 sendKeyBuffer[i].append((char)35);
					 break;
				 case "F3" :
					 sendKeyBuffer[i].append((char)36);
					 break;
				 case "F4" :
					 sendKeyBuffer[i].append((char)37);
					 break;
				 case "F5" :
					 sendKeyBuffer[i].append((char)38);
					 break;
				 case "F6" :
					 sendKeyBuffer[i].append((char)39);
					 break;
				 case "F7" :
					 sendKeyBuffer[i].append((char)40);
					 break;
				 case "F8" :
					 sendKeyBuffer[i].append((char)41);
					 break;
				 case "F9" :
					 sendKeyBuffer[i].append((char)42);
					 break;
				 case "F10" :
					 sendKeyBuffer[i].append((char)43);
					 break;
				 case "F11" :
					 sendKeyBuffer[i].append((char)94);
					 break;
				 case "F12" :
					 sendKeyBuffer[i].append((char)95);
					 break;
				 case "DIGIT2" :
					 sendKeyBuffer[i].append('2');
					 break;
				 case "DIGIT3" :
					 sendKeyBuffer[i].append('3');
					 break;
				 case "DIGIT4" :
					 sendKeyBuffer[i].append('4');
					 break;
				 case "DIGIT5" :
					 sendKeyBuffer[i].append('5');
					 break;
				 case "DIGIT6" :
					 sendKeyBuffer[i].append('6');
					 break;
				 case "DIGIT7" :
					 sendKeyBuffer[i].append('7');
					 break;
				 case "DIGIT8" :
					 sendKeyBuffer[i].append('8');
					 break;
				 case "DIGIT9" :
					 sendKeyBuffer[i].append('9');
					 break;
				 case "DIGIT0" :
					 sendKeyBuffer[i].append('0');
					 break;
				 case "BACK_QUOTE" :
					 sendKeyBuffer[i].append((char)96);
					 break;
				 default :
					 sendKeyBuffer[i].append(buffer.toString());
				 }
			 }
		 }

		 String sendKey = "#";
		 for(int i = 0; i < 6; i++){
			 sendKey += sendKeyBuffer[i].toString();
		 }
		 sendKey += "*";
		 String[] portNames = SerialPortList.getPortNames();
		 Serial[] availablePort = new Serial[portNames.length];
		 int[] returnValue = new int[3];
		 int arduinoPort;
		 for(int i = 0; i < 3; i++){
			 availablePort[i] = new Serial(portNames[i]);
			 returnValue[i] = availablePort[i].readByte();
			 if(returnValue[i] == '#') arduinoPort = i;
		 }
		 
		 
		 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("업로드 완료");
			alert.setHeaderText(null);
			alert.setContentText("업로드를 완료하였습니다!");
			alert.showAndWait();
		
			
	 }
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}
	
	public void showSetButtonDialog(MacroButton macroButton){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/SetButtonLayout.fxml"));
			AnchorPane page = (AnchorPane)loader.load();
			SetButtonLayoutController controller = loader.getController();
			Stage setButtonStage = new Stage();
			Scene scene = new Scene(page);
			setButtonStage.setTitle("버튼설정");
			setButtonStage.initModality(Modality.WINDOW_MODAL);
			setButtonStage.initOwner(primaryStage);
			setButtonStage.setScene(scene);
			controller.setButton(macroButton);
			controller.setDialogStage(setButtonStage);
			setButtonStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
