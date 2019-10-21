package wiki;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.Properties;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.AutoCompletionBinding.AutoCompletionEvent;
import org.controlsfx.control.textfield.TextFields;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wiki.AlertBox.AlertApp;

public class MainController implements Initializable {
	
	@FXML
	public TextField txtsearch;
	
	@FXML
	public ComboBox<String> txtcombox;
	
	public String searchinput;
	public String processedString;
	
	
	
	
	@FXML
	public void search(KeyEvent event) {
		
		if (event.getCode().equals(KeyCode.ENTER)) {
			//System.out.println(txtcombox.getEditor().getText());
			
			searchinput = txtcombox.getEditor().getText();
			  
			
			if (searchinput.length() == 0 || searchinput.isBlank()) {
				//AlertBox.display("Error", "Please dont input blank or just whitespace");
				AlertBox.MessageDisplay("Please dont input blank or just whitespace", AlertApp.EMPTYORBLANK);

			}
			else {
				
			 processedString = searchinput.replaceAll("\\s", "%20");
				
			 System.out.println(processedString);
			
			final SearchQuery searchQuery = new SearchQuery(processedString);	
			
			//Start Thread
			Thread thread = new Thread(searchQuery.task);
			thread.start();
			//add event handler on task 
			searchQuery.task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {
			
			public void handle(WorkerStateEvent tEvent) {
				
				ObservableList<String> data = FXCollections.observableList(searchQuery.getSearchedResponseList());
				txtcombox.getItems().clear();
				
				if (searchQuery.checkconn) {
					if (data.size() !=0) {
						txtcombox.setItems(data);
						txtcombox.show();
						
					}
					else {
						AlertBox.MessageDisplay("No search found on wikipedia", AlertApp.NODATAFOUND);
					}
				}
				

				
			 }
		});
			//searchQuery.getSearchedResponseList().clear();
			//System.out.println("Hi" + searchQuery.getSearchedResponseList());
		}
		
		}
	}


	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		PageDetails pageDetails = new PageDetails();
		pageDetails.loadPageDetails();
	}
	
	@FXML
	public void comboxAction(ActionEvent event) {
		System.out.println(txtcombox.getValue());
		
	}
	
	
	@FXML
	public void AboutMe() {
		AlertBox.display("About JamWikiViewer", "Part of JamSoft@.\n This software is open source and have fun!");
	}
	
	@FXML
	public void SearchSettings() {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("searchsettings.fxml"));
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setScene(new Scene(root));
			window.setResizable(false);
			window.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
