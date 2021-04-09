package BudgetTracker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML Button changeScreenExpensesbtn;
    public void changeScreenExpensesbtn(ActionEvent event) throws IOException
    {
        Parent setBudgetParent = FXMLLoader.load(getClass().getResource("logExpenses.fxml"));
        Scene setBudgetScene = new Scene (setBudgetParent);


        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setBudgetScene);
        window.show();
    }

}
