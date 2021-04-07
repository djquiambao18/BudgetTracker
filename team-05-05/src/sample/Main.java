package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    //private boolean add;
	 


	@Override
    public void start(Stage primaryStage) throws Exception{
        Button settingBtn = new Button("Setting");
       
        Button logExpensesBtn = new Button("Log Expenses");
        Button summaryBtn = new Button("Summary");
        Button saveFileBtn = new Button("Save File");
        Label budgetTrackerLbl = new Label("Budget Tracker");
        settingBtn.setStyle("-fx-font-size:20");
        summaryBtn.setStyle("-fx-font-size:20");
        saveFileBtn.setStyle("-fx-font-size:20");
        logExpensesBtn.setStyle("-fx-font-size:20");
       
       
      
        HBox myHbox = new HBox();
        myHbox.setSpacing(300);
        myHbox.setPadding(new Insets(20,20,20,20));
        myHbox.getChildren().add(settingBtn);
        myHbox.getChildren().add(budgetTrackerLbl);
        budgetTrackerLbl.setFont(Font.font ("Segoe UI", 30));
      //budgetTrackerLbl.setBackground(new BackgroundFill(Color.LIGHTGREEN,CornerRadii.EMPTY, Insets.EMPTY));
        
        Rectangle rectangleGreen = new Rectangle();
        rectangleGreen.setX(100.0f);
        rectangleGreen.setY(100.0f);
        rectangleGreen.setWidth(550.0f);
        rectangleGreen.setHeight(20.0f);
        Rectangle rectangleWhite = new Rectangle();
        rectangleWhite.setX(100.0f);
        rectangleWhite.setY(100.0f);
        rectangleWhite.setWidth(50.0f);
        rectangleWhite.setHeight(20.0f);
        
       
        //rectangle.setBackground(new BackgroundFill(Color.GREEN,CornerRadii.EMPTY, Insets.EMPTY));
      //  Group rectangleGroup = new Group(rectangle);
       
        VBox recVbox = new VBox();
        recVbox.getChildren().add(rectangleGreen);
        recVbox.getChildren().add(rectangleWhite);
        rectangleWhite.setFill(Color.WHITE);
        recVbox.setPadding(new Insets(50,30,50,30));
        rectangleGreen.setFill(Color.GREEN);
        rectangleGreen.setStroke(Color.GRAY);
        
        
        
        
        
        VBox myVbox = new VBox();
        myVbox.setSpacing(50);
        myVbox.setPadding(new Insets(30,350,200,380));
        
        myVbox.getChildren().add(logExpensesBtn);
        myVbox.getChildren().add(summaryBtn);
        myVbox.getChildren().add(saveFileBtn);

       
         VBox root = new VBox();
         root.getChildren().addAll(myHbox, recVbox,myVbox);
        
        

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
