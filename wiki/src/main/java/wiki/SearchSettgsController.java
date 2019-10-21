package wiki;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SearchSettgsController implements Initializable {
	
	SearchSettings settgs = new SearchSettings();

	@FXML
	public ComboBox<String> searchlimit;
	
	@FXML
	public ComboBox<String> typeSearch;
	
	@FXML
	public ComboBox<String> sortSerach;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		ObservableList<String> srlimit = FXCollections.observableList(settgs.searchLimitOption);

		searchlimit.setItems(srlimit);
		searchlimit.setValue(settgs.defaultLimit);
		
		ObservableList<String> srtype = FXCollections.observableList(settgs.typeSearchOption);
		
		typeSearch.setItems(srtype);
		typeSearch.setValue(settgs.typeoption);
		
		ObservableList<String> srsort = FXCollections.observableList(settgs.sortSerachOption);
		
		sortSerach.setItems(srsort);
		sortSerach.setValue(settgs.sortoption);
		
	}
	
	
}
