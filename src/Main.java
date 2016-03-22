import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static void main(String[] args) throws IOException{
		launch(args);
	}	 

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader();
		Pane mainPane = (Pane) fxmlLoader.load(Main.class.getResource("gui.fxml").openStream());
		GUIElements controller = fxmlLoader.getController();
		controller.populate();
		stage.setScene(new Scene(mainPane));
		mainPane.getStylesheets().add("style/style.css");
		stage.show();
	}
}

