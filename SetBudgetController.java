package application;

import java.io.IOException;
import java.time.LocalDate;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SetBudgetController 
{
	@FXML 
	private Button changeScreenToHomebtn;
	@FXML
	public DatePicker startDate;
	@FXML
	private TextField field_setBudgetLimit;
	@FXML
	private Button button_setBudgetLimit;
	@FXML
	private TextField field_increaseBudgetLimit;
	@FXML
	private Button button_addAmount;
	@FXML
	private TextField field_decreaseBudgetLimit;
	@FXML
	private Button button_decreaseAmount;
	@FXML 
	private Button button_viewBudgetLimit;
	@FXML
	private Button button_resetBudgetLimit;
	@FXML 
	private Button button_clearSetBudgetFeilds;
	
	
	public static String str_setBudgetLimit;
	public static String str_increaseBudgetLimit;
	public static String str_decreaseBudgetLimit;

	public static Budget budget = new Budget(); 

	
	
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
	 * when this method is called, 
	 * it picks a date
	 */
	public void datepicker_Start()
	{
		LocalDate startValue = startDate.getValue();

		System.out.println(startValue.getDayOfMonth() + " " + startValue.getMonth() + " " + startValue.getYear());
		//User.setUserData();
		//User.userData.setTermLength();
	}
	
	
	
	public void setBudgetLimitClick()
	{
		
		str_setBudgetLimit = this.field_setBudgetLimit.getText();
		
		budget.setBudget(Double.parseDouble(str_setBudgetLimit));
		
		try
		{
			if (str_setBudgetLimit.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
			{
				Alert alert_success = new Alert(Alert.AlertType.INFORMATION);
				alert_success.setTitle("Success!");
				alert_success.setContentText("You have set your budget successfully.");
				alert_success.showAndWait();
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
	
	
	
	public void addAmountClick()
	{
		str_increaseBudgetLimit = this.field_increaseBudgetLimit.getText();
		
		budget.increaseBudgetLimit(Double.parseDouble(str_increaseBudgetLimit));
		
		try
		{
			if (str_setBudgetLimit.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
			{
				Alert alert_success = new Alert(Alert.AlertType.INFORMATION);
				alert_success.setTitle("Success!");
				alert_success.setContentText("You have increased your budget limit successfully.");
				alert_success.showAndWait();
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
	
	
	
	//TODO: we need to check if the decreaseBudgetLimit is less than the current budget set so it doesn't 
	//become a negative value
	public void decreaseAmountClick()
	{
		str_decreaseBudgetLimit = this.field_decreaseBudgetLimit.getText();
		
		budget.decreaseBudgetLimit(Double.parseDouble(str_decreaseBudgetLimit));
		
		try
		{
			if (str_setBudgetLimit.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})"))
			{
				Alert alert_success = new Alert(Alert.AlertType.INFORMATION);
				alert_success.setTitle("Success!");
				alert_success.setContentText("You have decreased your budget limit successfully.");
				alert_success.showAndWait();
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
	
	
	
	public void viewBudgetLimitClick()
	{
		Alert alert_display = new Alert(Alert.AlertType.INFORMATION);
		alert_display.setTitle("Current Budget Limit");
		alert_display.setContentText("Your current budget limit is: " + "$" + budget.getBudgetLimit());
		alert_display.showAndWait();
	}
	
	
	
	public void resetBudgetLimitClick()
	{
		budget.setBudget(0);
		Alert alert_display = new Alert(Alert.AlertType.INFORMATION);
		alert_display.setTitle("Reset Budget Limit");
		alert_display.setContentText("You have reset your Budget Limit to" + "$" + budget.getBudgetLimit());
		alert_display.showAndWait();
	}
	 
	
	
	
	public void clearSetBudgetLimitClick()
	{
		this.field_setBudgetLimit.clear();
		this.field_increaseBudgetLimit.clear();
		this.field_decreaseBudgetLimit.clear();
	}
	
}
