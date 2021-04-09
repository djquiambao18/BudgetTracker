//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BudgetTracker;

import java.net.URL;
import java.util.Objects;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main_expenses extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("logExpenses.fxml")));
        primaryStage.setTitle("Budget Tracker");
        primaryStage.setScene(new Scene(root, 900.0D, 600.0D));
        Font font = Font.loadFont("A:\\Dev Tools\\Fonts\\Monaco.ttf", 20.0D);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
