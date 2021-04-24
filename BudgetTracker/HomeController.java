package BudgetTracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import BudgetTracker.SaveFile.SaveFile;
import BudgetTracker.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    //Buttons for future implementations
    private static User userData; //holds user data to be stored or loaded
    @FXML
    private Button button_settings;
    @FXML
    private Button button_logExpenses;
    @FXML
    private Button button_summary;
    @FXML
    private Button button_saveFile;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private Label label_balanceFraction;
    private static File file_InOut;


    private double percent = 0.0;    // test values, can delete
    public double num = 200;        // test value, can delete

    // returns the percent in decimal form to the FXML file in ProgressBar progress
    public double getPercent() {
        return percent;
    }
    @FXML
    public void changeScreenExpenses(ActionEvent event) throws IOException {
        Parent setExpenseParent = FXMLLoader.load(getClass().getResource("Expenses/logExpenses.fxml"));
        Scene setExpenseScene = new Scene(setExpenseParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(setExpenseScene);
        window.show();
    }
    @FXML
    private Button changeScreenInputIncomebtn;
    /* when this method is called, it will change the scene to
     * inputIncome
     */

    public void changeScreenToInputIncome(ActionEvent event) throws IOException
    {
        Parent inputIncomeParent = FXMLLoader.load(getClass().getResource("Income/inputIncome.fxml"));
        Scene inputIncomeScene = new Scene (inputIncomeParent);


        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(inputIncomeScene);
        window.show();
    }

    @FXML
    private Button changeScreenSetBudgetbtn;
    /* when this method is called, it will change the scene to
     * setBudget
     */
	public void changeScreenToSetBudget(ActionEvent event) throws IOException
	{
		Parent setBudgetParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Budget/setBudget.fxml")));
		Scene setBudgetScene = new Scene (setBudgetParent);


		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

		window.setScene(setBudgetScene);
		window.show();
	}
    public void setButton_saveFile(){
	    SaveFile.save(userData);
    }

    public static void setUserData(Object o){

    }

    // used to split a string fraction (ie. 2/3) into a decimal value ** CAN DELETE IF NOT USED
    //Will be used for future progress bar
    public String[] splitFraction() {
        String[] splitFract = {};
        double dbl = -0.999;

        if (label_balanceFraction.getText().contains("/")) {
            splitFract = label_balanceFraction.getText().split("/");
            return splitFract;
        }
        return splitFract;
    }

    // change progress bar color to light green
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setStyle("-fx-accent: #88eaaa;");

        label_balanceFraction.setText(num + "/1500");  // test value, can delete
        if(SaveFile.save()){

        }

        //FOLLOWING CODE will be used for future implementations
        // bind the fraction label to the progress bar percentage
        // my attempt here failed bc the label gets affected by the progress bar
        // .setProgress(num) (num ranges from 0.0-1.0) where 1.0 is 100%
        /*
        StringProperty stringProperty = label_balanceFraction.textProperty();
        DoubleProperty doubleProperty = progressBar.progressProperty();
        NumberStringConverter converter = new NumberStringConverter();
        Bindings.bindBidirectional(stringProperty, doubleProperty, converter);
         */
    }

    //
    // used for just testing the progress bar animation. click on the summary button to launch method
    public void click(ActionEvent actionEvent) {
        //percent += 0.05;    // increase progress bar by 5%
        //this.progressBar.setProgress(percent);
        //label_balanceFraction.setText((num += 10) +"/1500");

        //System.out.println(label_balanceFraction);
        //System.out.println("progress bar percent" + progressBar.progressProperty().getValue());
    }

}
/*
import javafx.stage.Stage;

public class HomeController 
{

	@FXML 
	private Button changeScreenSetBudgetbtn;
	/* when this method is called, it will change the scene to
	 * setBudget
	 *
	public void changeScreenToSetBudget(ActionEvent event) throws IOException
	{
		Parent setBudgetParent = FXMLLoader.load(getClass().getResource("setBudget.fxml"));
		Scene setBudgetScene = new Scene (setBudgetParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(setBudgetScene);
		window.show();
	}

	@FXML 
	private Button changeScreenInputIncomebtn;
	/* when this method is called, it will change the scene to
	 * inputIncome
	 *
	public void changeScreenToInputIncome(ActionEvent event) throws IOException
	{
		Parent inputIncomeParent = FXMLLoader.load(getClass().getResource("inputIncome.fxml"));
		Scene inputIncomeScene = new Scene (inputIncomeParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(inputIncomeScene);
		window.show();
	}
	
	
	@FXML 
	private Button changeScreenLogExpensesbtn;
	/* when this method is called, it will change the scene to
	 * logExpense
	 *
	public void changeScreenToLogExpenses(ActionEvent event) throws IOException
	{
		Parent logExpensesParent = FXMLLoader.load(getClass().getResource("logExpenses.fxml"));
		Scene logExpensesScene = new Scene (logExpensesParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(logExpensesScene);
		window.show();
	}
}*/
