package BudgetTracker.ExpensesPkg;

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
    private ObservableList<Expenses> expenseList = FXCollections.observableArrayList();
    @FXML
    private final TableColumn col_Cost = new TableColumn("Amount ($)");
    @FXML
    private final TableColumn col_itemName = new TableColumn("Item Name");
    @FXML
    private final TableColumn col_category = new TableColumn("Category");
    @FXML   //is used in tandem with the expenseList var
    private TableView<Expenses> table_view;
    @FXML private ComboBox category_comboBox;
    @FXML private final ObservableList<String> categoryList = FXCollections
            .observableArrayList("Choose a category for your item", "Groceries", "Rent", "Utilities",
                    "Merchandise","Restaurants", "Transportation", "Other");
    //private File tempData;
    private ArrayList<Expenses> dataList;
    //counter for expense list to increment each addition to the list
    private static int counter = 0;

    public void addItemClick() {
        String str_cost = this.field_cost.getText();
        String str_name = this.field_name.getText();
        String str_category = category_comboBox.getValue().toString();

        try {
            //If the string matches the regex that is recognizable decimal digits.
            if (str_cost.matches("\\${0,1}[0-9]+\\.{0,1}([0-9]{0,2})")
                    && !str_name.isEmpty()
                    && !str_category.equals("Choose a category for your item")){

                this.expenseList.add(new Expenses(str_name, Double.parseDouble(str_cost), str_category));
                this.field_cost.clear();
                this.field_name.clear();
                this.table_view.setItems(this.expenseList);
                dataList.add(expenseList.get(counter++));
                Expenses.setExpensesTable(dataList);
                //System.out.println(Expenses.getExpensesTable().get(counter-1));

            }

            else {
                //If input is invalid, it will show an alert box to the user indicating that the input is not valid!

                Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
                invalid_alert.setTitle("Invalid Input!");

                if (!str_cost.matches("\\${0,1}[0-9]+\\.{0,1}([0-9]{0,2})")){
                    invalid_alert.setContentText("Unrecognized input. Please type any NUMBER in a valid format (Ex: 20.55; 99.9; 5)");
                }
                else if (str_category.equals("Choose a category for your item")) {
                    invalid_alert.setContentText("Please select a VALID category for your item.");
                }
                else
                    invalid_alert.setContentText("Error. Please try again...");
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
        //Updates the Expenses Table List using the User class static method set User Expense, and passing in the local dataList variable
        if(dataList != null && Expenses.getExpensesTable() != null) {
            User.setUserExpense();
            Expenses.setTotalGrocery();
            Expenses.setTotalMerchandise();
            Expenses.setRentExpense();
            Expenses.setUtilitiesExpense();
            Expenses.setTotalRestaurants();
            Expenses.setTotalTransportation();
            Expenses.setTotalOthers();
            SaveFile.saveExpenses(Expenses.getExpensesTable());
        }


        //SaveFile.save(userData);
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
        this.col_Cost.setPrefWidth(105.0D);
        this.col_Cost.setResizable(false);
        this.col_Cost.setCellValueFactory(new PropertyValueFactory("itemCost"));
        this.col_itemName.setPrefWidth(250.0D);
        this.col_itemName.setResizable(false);
        this.col_itemName.setCellValueFactory(new PropertyValueFactory("itemName"));
        this.col_category.setPrefWidth(118.0D);
        this.col_category.setResizable(false);
        this.col_category.setCellValueFactory(new PropertyValueFactory("itemCategory"));

        this.table_view.getColumns().addAll(col_Cost, col_itemName,col_category);
        this.table_view.setEditable(true);
        category_comboBox.setItems(categoryList);
        category_comboBox.getSelectionModel().selectFirst();

        //Properly displays the changes even after changing scenes...
        if(Expenses.getExpensesTable() != null){
            this.dataList = Expenses.getExpensesTable();
            expenseList = FXCollections.observableArrayList(this.dataList);
            this.table_view.setItems(this.expenseList);
        }
        else{
            this.dataList = new ArrayList<>();
        }

    }
    
}