package sploit.macrobot.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import sploit.macrobot.Main;

public class MainLayoutController implements Initializable {
	@FXML
	private Tab buttonTab;
	
	private Stage primaryStage;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//setButtonLayout();
	
	}
	
	public void setPrimaryStage(Stage primaryStage){
		this.primaryStage = primaryStage;
	}

	private void setButtonLayout() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/ButtonLayout.fxml"));
			Parent buttonLayout = loader.load();

			ButtonLayoutController controller = new ButtonLayoutController();
			controller = loader.getController();
			controller.setPrimaryStage(primaryStage);
			buttonTab.setContent(buttonLayout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
