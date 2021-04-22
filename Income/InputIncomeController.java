package Income;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputIncomeController 
{

	@FXML
	/* when this method is called, it will change the scene to
	 * home
	 */
	public void changeScreenToHome(ActionEvent event) throws IOException
	{
		Parent setHomeParent = FXMLLoader.load(getClass().getResource("../home.fxml"));
		Scene setHomeScene = new Scene (setHomeParent);
		
		
		//This line gets the Stage information
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(setHomeScene);
		window.show();
	}
	
	@FXML
	private TextField field_hourlyWage;
	@FXML
	private TextField field_hoursWorked;
	@FXML
	private Label label_wagesEarned;
	@FXML 
	private Button button_calculateWages;
	/*
	 * when the user finishes typing its hourlyWage and hoursWorked and clicks on the Calculate Wages button, 
	 * this method will calculate the wages earned and display the result. 
	 */
	public void calculateWagesEarnedClick()
	{
		String str_hourlyWage 	= this.field_hourlyWage.getText();
		String str_hoursWorked	= this.field_hoursWorked.getText();
		
		 try 
	        {
	            if (str_hourlyWage.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
	            		//&& str_hourlyWage.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
	            {
	            	Income wages = new Income(Double.parseDouble(str_hourlyWage), Double.parseDouble(str_hoursWorked));
	            	wages.wageEarnings();
	     		 	label_wagesEarned.setText("Wages Earned = " + (wages.getWageEarnings()));
	            }
	            
	            else
	            {
	            	System.out.println("Invalid input!");
	            	
	            }
	        } 
	        
	        catch (Exception e)
	        {
	            e.getStackTrace();
	        }
		 
	}
	
	
	@FXML
	private Button button_resetWages;
	/*
	 * when this method is called, it resets the values of hourlyWage and hoursWorked.
	 * also clears away the calculation of Wages Earned.
	 */
	public void resetWagesCalculationClick()
	{
		this.field_hourlyWage.clear();
        this.field_hoursWorked.clear();
        this.label_wagesEarned.setText("Wages Earned = ");
	}
	
	
	//TODO finish this method
	@FXML
	private Button button_depositeWagesEarned;
	public void depositWagesClick()
	{
		
	}
	
	
	
}
