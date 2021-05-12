package BudgetTracker.SetDate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import BudgetTracker.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
	private static LocalDate termLength;

	@FXML
	private Label label_endDate2;
	@FXML 
	private Button button_setDate;
	@FXML
	private Label label_currentBudgetLimit;
	@FXML 
	private Label label_startDate;

	/* when this method is called, it will change the scene to
	 * home
	 */
	@FXML
	public void changeScreenToHome(ActionEvent event) throws IOException
	{

		Parent setHomeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../home.fxml")));
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

		termLength = startValue.plusMonths(1);

		User.setTermLength(termLength);
		label_startDate.setText(startValue.toString());
		label_endDate.setText(termLength.toString());
		label_endDate2.setText(termLength.toString());
	}

	public void setDateClick()
	{
		if(startDate.getValue() == null) {
			Alert information = new Alert(Alert.AlertType.INFORMATION);
			information.setTitle("Term Length");
			information.setContentText("Your budget term is empty! Please enter a valid date using the calendar");
			information.showAndWait();    //waits for user input to press OK to continue
			return;
		}
		Alert information = new Alert(Alert.AlertType.INFORMATION);
		information.setTitle("Term Length");
		information.setContentText("Your budget term begins on "+startDate.getValue() + " and ends on " + termLength);
		information.showAndWait();    //waits for user input to press OK to continue
	}
	
	public void resetDateClick()
	{
		if(startDate.getValue() == null) {
			Alert information = new Alert(Alert.AlertType.INFORMATION);
			information.setTitle("Term Length");
			information.setContentText("Your budget term is empty! Please enter a valid date using the calendar");
			information.showAndWait();    //waits for user input to press OK to continue
			return;
		}
		Alert information = new Alert(Alert.AlertType.INFORMATION);
		information.setTitle("Term Length");
		information.setContentText("Your budget term begin has been reset. Pick a new date");
		information.showAndWait();    //waits for user input to press OK to continue

	}
}
