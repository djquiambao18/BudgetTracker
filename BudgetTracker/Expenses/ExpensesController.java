package BudgetTracker.Expenses;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import BudgetTracker.SaveFile.SaveFile;
import BudgetTracker.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ExpensesController implements Initializable {

    //TextFields var will hold data from the logExpenses.fxml
    @FXML
    private TextField field_cost;
    @FXML
    private TextField field_name;
    @FXML //used for populating the table within the log expenses
    private final ObservableList<Expenses> expenseList = FXCollections.observableArrayList();
    @FXML
    private final TableColumn col_Cost = new TableColumn("Amount ($)");
    @FXML
    private final TableColumn col_itemName = new TableColumn("Item Name");
    @FXML   //is used in tandem with the expenseList var
    private TableView<Expenses> table_view;
    private File tempData;
    private ArrayList<Expenses> dataList;
    private static int counter = 0;

    public void addItemClick() {
        String str_cost = this.field_cost.getText();
        String str_name = this.field_name.getText();

        try {
            //If the string matches the regex that is recognizable decimal digits.
            if (str_cost.matches("\\${0,1}[0-9]+\\.{0,1}([0-9]{0,2})") && !str_name.isEmpty()) {
                this.expenseList.add(new Expenses(str_name, Double.parseDouble(str_cost)));
                this.field_cost.clear();
                this.field_name.clear();
                this.table_view.setItems(this.expenseList);
                dataList.add(expenseList.get(counter++));
                Expenses.setExpensesTable(dataList);

                }
             else {
                //If input is invalid, it will show an alert box to the user indicating that the input is not valid!
                Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
                invalid_alert.setTitle("Invalid Input!");
                invalid_alert.setContentText("Unrecognized cost input. Please type any NUMBER in a valid format (Ex: 20.55; 99.9; 5)");
                invalid_alert.showAndWait();    //waits for user input to press OK to continue
            }
        }
        
        catch(Exception e)
            {
                e.getStackTrace();
            }
    }

    //this method removes the item from the table when highlighted on
    public void subtractItemClick()
    {
        Expenses selected = table_view.getSelectionModel().getSelectedItem();
        try {
            if(dataList.remove(selected)){
                counter--;
            }
            table_view.getItems().remove(selected);
            Expenses.setExpensesTable(dataList);
            for (int i = 0; i < Expenses.getExpensesTable().size(); i++){
                System.out.println(Expenses.getExpensesTable().get(i));
            }
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }

    //this method is called when the home button is clicked
    public void changeScreenToHome(ActionEvent event) throws IOException
    {
        User userData = new User();
        User.setUserExpense(dataList);
        SaveFile.save(userData);
        Parent setHomeParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../home.fxml")));
        Scene setHomeScene = new Scene (setHomeParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setHomeScene);
        window.show();
    }


    //Initializes the expenses controller
    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
        this.col_Cost.setPrefWidth(172.0D);
        this.col_Cost.setResizable(false);
        this.col_Cost.setCellValueFactory(new PropertyValueFactory("itemCost"));
        this.col_itemName.setPrefWidth(266.0D);
        this.col_itemName.setResizable(false);
        this.col_itemName.setCellValueFactory(new PropertyValueFactory("itemName"));

        this.table_view.getColumns().addAll(col_Cost, col_itemName);
        this.table_view.setEditable(true);
        this.dataList = new ArrayList<>();


    }
    
}