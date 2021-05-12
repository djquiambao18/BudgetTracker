package BudgetTracker.Budget;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetBudgetController implements Initializable
{
	@FXML
	private TextField field_budgetAmt;
	@FXML
	private TextField field_increaseBudget;
	@FXML
	private TextField field_decreaseBudget;
	@FXML
	private Label dateLabel;

	private final Budget budgetData = new Budget();
	/* when this method is called, it will change the scene to
	 * home
	 */
	public void changeScreenToHome(ActionEvent event) throws IOException
	{
			if(SaveFile.setBudget_save(budgetData) && budgetData.getBudget() > 0)
			{
				Alert information = new Alert(Alert.AlertType.INFORMATION);
				information.setTitle("Budget Amount");
				information.setContentText("Your budget amount is: $" + budgetData.getBudget());
				information.showAndWait();    //waits for user input to press OK to continue
			}
			Parent setHomeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../home.fxml")));
			Scene setHomeScene = new Scene(setHomeParent);

			//This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(setHomeScene);
			window.show();
	}

	@FXML
	public void button_setBudgetAmt(){
		//System.out.println(User.getTermLength().toString());
		try {
			if(!field_budgetAmt.getText().isEmpty()) {
				double budgetAmount = Double.parseDouble(field_budgetAmt.getText());
				if (budgetAmount > 0) {
					budgetData.setBudget(budgetAmount);
					User.setUserBudget(budgetData);
					//Notify user with dialog box
					Alert information = new Alert(Alert.AlertType.INFORMATION);
					information.setTitle("Budget Amount");
					information.setContentText("Your budget amount is now set to: $" + budgetAmount);
					information.showAndWait();
				} else {
					Alert information = new Alert(Alert.AlertType.ERROR);
					information.setTitle("Budget Amount");
					information.setContentText("Your budget amount must be greater than zero!");
					information.showAndWait();    //waits for user input to press OK to continue
				}
			}
			else
			{
				Alert information = new Alert(Alert.AlertType.ERROR);
				information.setTitle("Budget Amount");
				information.setContentText("Please enter an amount!");
				information.showAndWait();
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
		}

	}
	@FXML
	public void button_addAmount(){
		try {
			if(!field_increaseBudget.getText().isEmpty()){
			double increaseAmount = Double.parseDouble(field_increaseBudget.getText());
			budgetData.setBudget(budgetData.getBudget() + increaseAmount);
			}
		}
			catch(Exception e){
			e.getStackTrace();
		}
	}
	@FXML
	public void button_minusAmount(){
		try {
			if (!field_decreaseBudget.getText().isEmpty()) {
				double decreaseAmount = Double.parseDouble(field_decreaseBudget.getText());
				budgetData.setBudget(budgetData.getBudget() + decreaseAmount);
			}
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}

	@FXML
	public void button_viewBudgetAmount(){
		try {
			Alert information = new Alert(Alert.AlertType.INFORMATION);
			information.setTitle("Budget Amount");
			if (budgetData.getBudget() > 0)
				information.setContentText("Your current budget amount is: $" + budgetData.getBudget());
			else
				information.setContentText("Your budget amount must be greater than zero!");

			information.showAndWait();    //waits for user input to press OK to continue
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}

	@FXML
	public void button_resetAmount(){
		try {
			Alert information = new Alert(Alert.AlertType.INFORMATION);
			information.setTitle("Budget Amount");
			if (budgetData.getBudget() > 0) {
				information.setContentText("Resetting budget amount...");
				budgetData.setBudget(0.0);
			} else
				information.setContentText("Your budget amount is zero!");
			information.showAndWait();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		try {
			Alert information = new Alert(Alert.AlertType.INFORMATION);
			information.setTitle("Budget Amount");
			if(budgetData.getBudget() > 0)
				information.setContentText("Your current budget amount is: $" + budgetData.getBudget());
			else
				information.setContentText("Your budget amount must be greater than zero!");

			if(User.getTermLength() != null) {
				dateLabel.setText("For " + User.getTermLength().minusMonths(1) + " to " + User.getTermLength());
			}

		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}
}
