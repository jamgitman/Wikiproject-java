package wiki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("wikimain.fxml"));
			Scene scene = new Scene(root, 800, 500);
			stage.setScene(scene);
			stage.setTitle("JWiki");
			stage.setResizable(false);
			stage.show();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
    public static void main( String[] args )
    {
    	launch(args);
       // System.out.println( "Hello World!" );
        
    }

	
}
