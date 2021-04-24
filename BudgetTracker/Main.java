
package BudgetTracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
			primaryStage.setTitle("Budget Tracker");
			primaryStage.setScene(new Scene(root, 900, 600));
			primaryStage.setResizable(false);
			primaryStage.show();

		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}