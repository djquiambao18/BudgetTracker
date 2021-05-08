package BudgetTracker.Budget;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import BudgetTracker.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class SetBudgetController 
{
	@FXML 
	private Button changeScreenToHomebtn;
	@FXML
	private static DatePicker startDate;
	@FXML
	private static DatePicker endDate;
	@FXML
	private static LocalDate term;

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
	public void datepicker_Start(){
		//Period termLength = Period.between(startDate.getValue(), endDate.getValue());
		//User.setTermLength(termLength);
		System.out.println(User.getTermLength().toString());

		//User.setUserData();
		//User.userData.setTermLength();
	}
	@FXML
	public void datepicker_End(){

	}


	
}
