package wiki;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox {
	
	public enum AlertApp{
		EMPTYORBLANK,NOINTERNETCONN,NODATAFOUND,OVERWIRTETAB
	}
	// create a enum for every case and use it in switch 
	// eg 1.empty or blank string 2.No internet connection 3.no data found 4.Do you want to overwrite to this tan
	
	public static void MessageDisplay(String message, AlertApp type) {
		
		Alert alert = new Alert(AlertType.NONE);
		switch (type) {
		case EMPTYORBLANK:
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText(message);
			alert.showAndWait();
			break;
		case NOINTERNETCONN:
			alert.setAlertType(AlertType.ERROR);
			alert.setContentText(message);
			alert.showAndWait();
			break;
		case NODATAFOUND:
			alert.setAlertType(AlertType.INFORMATION);
			alert.setContentText(message);
			alert.showAndWait();
			break;
		case OVERWIRTETAB:
			alert.setAlertType(AlertType.CONFIRMATION);
			alert.setContentText(message);
			alert.showAndWait();
			break;
		default:
			break;
		}		
	}
	
	public static void display(String title,String message) {
		Stage  window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(300);
		window.setHeight(200);
		window.setResizable(false);
		
		Label label1 = new Label();
		label1.setText(message);
		label1.setAlignment(Pos.CENTER);
		
		
		Button closeButton = new Button("Close the window");
		closeButton.setLayoutX(100);
		closeButton.setLayoutY(80);
		closeButton.setOnAction(e->window.close());
		
		AnchorPane layout = new AnchorPane();
		layout.getChildren().addAll(label1,closeButton);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
