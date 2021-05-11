package BudgetTracker;

import java.io.File;
import java.io.IOException;

import BudgetTracker.Budget.SetBudgetController;
import BudgetTracker.ExpensesPkg.Expenses;
import BudgetTracker.SaveFile.SaveFile;
import BudgetTracker.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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


    private double percent = 0.0;   // percent for progress bar

    @FXML
    public void changeScreenExpenses(ActionEvent event) throws IOException {
        Parent setExpenseParent = FXMLLoader.load(getClass().getResource("ExpensesPkg/logExpenses.fxml"));
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

	@FXML
    /* when this method is called, it will change the scene to
     * Summary
     */
	public void changeScreenToSummary(ActionEvent event) throws IOException
    {
        Parent setSummaryParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Summary/summary.fxml")));
        Scene setSummaryScene = new Scene(setSummaryParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setSummaryScene);
        window.show();
    }
    public void setButton_saveFile(){
	    SaveFile.save(userData);
    }

    public static void setUserData(Object o){

    }

    // change progress bar color to light green
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progressBar.setStyle("-fx-accent: #88eaaa;");
        progressBar.setProgress(0);

        // get the budget limit and total expenses. divide to get the percent of
        // available balance left and update thee progress bar
        Double budgetLimit = SetBudgetController.budget.getBudgetLimit();
        Double totalExpenses = Expenses.getTotalAllExpenses();

        // if limit and total expenses are not 0, or percent <= 1, set the progress bar and text
        if(budgetLimit != 0 && totalExpenses != 0
                || (totalExpenses / budgetLimit) <= 1 ) {

            percent = totalExpenses / budgetLimit;

            progressBar.setProgress(percent);
            label_balanceFraction.setText("$" + totalExpenses + " / " + budgetLimit);
        }

        // warn user when their expenses are nearing 90%
        if(percent >= 0.9) {
            Alert alert_success = new Alert(Alert.AlertType.INFORMATION);
            alert_success.setTitle("Limit Warning");
            alert_success.setContentText("WARNING: Your expenses are nearing the budget limit.");
            alert_success.showAndWait();
        }

        if(SaveFile.save()){

        }
    }
}
