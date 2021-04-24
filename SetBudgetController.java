package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetBudgetController 
{
	@FXML 
	private Button changeScreenToHomebtn;

	/* when this method is called, it will change the scene to
	 * home
	 */
	public void changeScreenToHome(ActionEvent event) throws IOException
	{
		Parent setHomeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
		Scene setHomeScene = new Scene (setHomeParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(setHomeScene);
		window.show();
	}
	
	@FXML
	private TextField field_setBudgetLimit;
	private Button button_setBudgetLimit;
	/*
	 * when the user finishes typing the setBudget amount and clicks on the "Set Budget Limit" button, 
	 * this method will set the budget limit. 
	 */
	public void setBudgetLimitClick()
	{
		String str_setBudgetLimit = this.field_setBudgetLimit.getText();
		
		try 
        {
			if(str_setBudgetLimit.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
            {
            	Budget budgetLimit = new Budget(Double.parseDouble(str_setBudgetLimit));
            	Alert alert_sucess = new Alert(Alert.AlertType.INFORMATION);
                alert_sucess.setTitle("Success!");
                alert_sucess.setContentText("You have set your budget limit successfully.");
                alert_sucess.showAndWait();
                
                this.field_setBudgetLimit.clear();
            }
			
			else 
            {
                //If input is invalid, it will show an alert box to the user indicating that the input is not valid!
                Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
                invalid_alert.setTitle("Invalid Input!");
                invalid_alert.setContentText("Unrecognized cost input. Please type any NUMBER in a valid format (Ex: 20.55; 99.9; 5)");
                invalid_alert.showAndWait();
            }
        }
		
		catch (Exception e)
        {
            e.getStackTrace();
        }
	}
	
	
	
}

	
