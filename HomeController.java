package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController 
{

	
	@FXML 
	private Button changeScreenSetBudgetbtn;
	/* when this method is called, it will change the scene to
	 * setBudget
	 */
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
	 */
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
	 */
	public void changeScreenToLogExpenses(ActionEvent event) throws IOException
	{
		Parent logExpensesParent = FXMLLoader.load(getClass().getResource("logExpenses.fxml"));
		Scene logExpensesScene = new Scene (logExpensesParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(logExpensesScene);
		window.show();
	}
}
