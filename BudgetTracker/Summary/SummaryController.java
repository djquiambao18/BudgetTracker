package BudgetTracker.Summary;

import BudgetTracker.ExpensesPkg.Expenses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SummaryController implements Initializable {
    @FXML private PieChart pieChart;
    @FXML private Button changeScreenHomeBtn;
    @FXML private Button changeScreenSummaryBtn;
    private static int counter = 0;
    double tempValue = 16.6;
    @FXML
    ObservableList<PieChart.Data> pieChart_data =
            FXCollections.observableArrayList(
                    new PieChart.Data("Groceries", Expenses.getExpensesTable().get(0).getItemCost()),
                    new PieChart.Data("Rent and Utilities", tempValue),
                    new PieChart.Data("Restaurants", tempValue),
                    new PieChart.Data("Merchandise", tempValue),
                    new PieChart.Data("Transportation", tempValue),
                    new PieChart.Data("Other", tempValue)
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pieChart.setData(pieChart_data);
        if(Expenses.getExpensesTable().get(0) != null)
        System.out.println(Expenses.getExpensesTable().get(counter));

    }

    // when this method is called, it will change the scene to home page
    public void changeScreenToHome(ActionEvent event) throws IOException
    {
        Parent setHomeParent = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Scene setHomeScene = new Scene (setHomeParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setHomeScene);
        window.show();
    }
}