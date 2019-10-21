package wiki;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class SearchSettings {
	
	List<String> searchLimitOption = new ArrayList<String>(List.of("100","200","300","400","500"));
	List<String> typeSearchOption = new ArrayList<String>(List.of("srsearch","opensearch"));
	List<String> sortSerachOption = new ArrayList<String>(List.of("none","relevance","just_match","random"));
	
	
	public String defaultLimit = "100";
	public String typeoption = "srsearch";
	public String sortoption = "none";
	

}
