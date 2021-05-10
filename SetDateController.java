package application;

import java.io.IOException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SetDateController 
{

	@FXML 
	private Button changeScreenToHomebtn;
	@FXML 
	private Label label_endDate;
	@FXML
	private Button button_resetDate;
	@FXML 
	private DatePicker startDate;
	@FXML 
	private Button button_setDate;
	@FXML 
	private Label lavel_currentBudgetLimit;
	@FXML 
	private Label label_startDate;
	
	
	
	
	
	
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
	
	
	
	
	public void setDateClick()
	{
		
	}
	
	public void resetDateClick()
	{
		
	}
}
