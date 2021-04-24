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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputIncomeController 
{
	@FXML
	private TextField field_hourlyWage;
	@FXML
	private TextField field_hoursWorked;
	@FXML
	private Label label_wagesEarned;
	@FXML 
	private Button button_calculateWages;
	@FXML
	private Button button_resetWages;
	@FXML
	private Button button_depositeWagesEarned;
	@FXML
	private TextField field_cashAmount;
	@FXML
	private Button button_depositCashAmountToBalance;
	@FXML
	private Button button_resetCashAmount;
	@FXML
	private Button button_DisplayTotalCashBalanceOnHand;
	

	//the following variables are placeholder for getting the textfield values:
	public static String str_hourlyWage;
	public static String str_hoursWorked;
	
	Income income = new Income();
    
	
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
	
	
	
	/*
	 * when the user finishes typing its hourlyWage and hoursWorked 
	 * and clicks on the Calculate Wages button, 
	 * this method will retrieve the calculated earned wages 
	 * and display the result on the screen.
	 */
	public void calculateWagesEarnedClick()
	{	
		double incomeWages = getCalculatedWagesEarned();
		
		if (incomeWages > 0)
		{
			label_wagesEarned.setText("Wages Earned = " + incomeWages);   
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
	
	
	
	
	/*
	 * when this method is called, it will deposit the calculated earned wages
	 * into the cash balance on hand
	 */
	public void depositWagesClick()
	{
		double incomeWages = getCalculatedWagesEarned();
		
		if (incomeWages > 0)
		{
			income.setWageEarnings(incomeWages);
			income.depositWages();
			Alert alert_sucess = new Alert(Alert.AlertType.INFORMATION);
			alert_sucess.setTitle("Success!");
			alert_sucess.setContentText("You have deposited your earned wages successfully.");
			alert_sucess.showAndWait();	 
		}
		else
		{
            Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
            invalid_alert.setTitle("Invalid Input!");
            invalid_alert.setContentText("Unrecognized cost input. Please type any NUMBER in a valid format (Ex: 20.55; 99.9; 5)");
            invalid_alert.showAndWait();
		}
		
	}
	
	
	
	
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
	
	
	
	
	/*
	 * when this method is called, it will deposit the user's entered cash amount
	 * into the cash balance on hand
	 */
	public void depositCashAmountClick()
	{
		String str_cashAmount = this.field_cashAmount.getText();

		try
		{
            if (str_cashAmount.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
            {
            	income.setDepositAmount(Double.parseDouble(str_cashAmount));
            	income.depositCash();
            	Alert alert_sucess = new Alert(Alert.AlertType.INFORMATION);
    			alert_sucess.setTitle("Success!");
    			alert_sucess.setContentText("You have deposited your cash amount successfully.");
    			alert_sucess.showAndWait();	 
    		}
    		else
    		{
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
	
	
	
	
	/*
	 * when this method is called, it resets the values of hourlyWage and hoursWorked.
	 * also clears away the calculation of Wages Earned.
	 */
	public void resetCashAmountClick()
	{
		this.field_cashAmount.clear();
	}
	
	
	
	
	/*
	 * when this method is called, it will display the total cash money on hand
	 */
	public void displayTotalCashBalanceOnHandClick()
	{
		Alert alert_sucess = new Alert(Alert.AlertType.INFORMATION);
        alert_sucess.setTitle("Total Cash Balance On Hand");
        alert_sucess.setContentText("Cash balance on hand: " + income.getTotalIncomeBalance());
        alert_sucess.showAndWait();
	       
	}
	
	
	
	
	/*
	 * when this method is called, it will calculate and return the wage earnings
	 */
	public double getCalculatedWagesEarned()
	{
		str_hourlyWage 	= this.field_hourlyWage.getText();
	    str_hoursWorked	= this.field_hoursWorked.getText();
		
		 try
		 {
	            if (str_hourlyWage.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})")
	            		&& str_hoursWorked.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
	            {
	            	income.setHourlyWage(Double.parseDouble(str_hourlyWage));
	            	income.setHoursWorked(Double.parseDouble(str_hoursWorked));
	            	income.wageEarnings();
	            	return income.getWageEarnings();
	            }                
		 }
		 
		catch (Exception e)
	    {
			e.getStackTrace();
	    }
		 
	    return 0;
	}
			
}

