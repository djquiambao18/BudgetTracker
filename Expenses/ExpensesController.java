package Expenses;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    @FXML private TextField field_cost;
    @FXML private TextField field_name;

    //used for populating the table within the log expenses
    @FXML private final ObservableList<Expenses> expenseList = FXCollections.observableArrayList();
    @FXML private final TableColumn col_Cost = new TableColumn("Amount ($)");
    @FXML private final TableColumn col_itemName = new TableColumn("Item Name");

    //is used in tandem with the expenseList var
    @FXML private TableView<Expenses> table_view;

    // used for populating the choice box with options to choose from
    @FXML private ComboBox category_comboBox;
    @FXML private final ObservableList<String> categoryList = FXCollections
            .observableArrayList("Choose a category for your item", "Groceries",
                    "Merchandise","Restaurants", "Transportation", "Other");

    public void addItemClick()
    {
        String str_cost = field_cost.getText();
        String str_name = field_name.getText();
        String str_category = category_comboBox.getValue().toString();

        try 
        {
            // check if user has chosen a category for their item, if not, throw error window

            if(str_category.equals("Choose a category for your item")) {
                Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
                invalid_alert.setTitle("Invalid Category!");
                invalid_alert.setContentText("Category for this item is required. Please select the appropriate category.");
                invalid_alert.showAndWait();    //waits for user input to press OK to continue
                return;
            }

            //If the string matches the regex that is recognizable decimal digits.
            if (str_cost.matches("\\${0,1}[0-9]+\\.{0,1}([0-9]{0,2})") && !str_name.isEmpty()
                    )
            {
                expenseList.add(new Expenses(str_name, Double.parseDouble(str_cost), str_category));
                field_cost.clear();
                field_name.clear();
                table_view.setItems(expenseList);
            } 
            
            else 
            {
                //If input is invalid, it will show an alert box to the user indicating that the input is not valid!
                Alert invalid_alert = new Alert(Alert.AlertType.ERROR);
                invalid_alert.setTitle("Invalid Input!");
                invalid_alert.setContentText("Unrecognized cost input. Please type any NUMBER in a valid format (Ex: 20.55; 99.9; 5)");
                invalid_alert.showAndWait();    //waits for user input to press OK to continue
            }
        }
        catch (Exception e) 
        {
            e.getStackTrace();
        }
    }

    //this method removes the item from the table when highlighted on
    public void subtractItemClick()
    {
        Expenses selected = table_view.getSelectionModel().getSelectedItem();
        table_view.getItems().remove(selected);
    }


    //this method is called when the home button is clicked
    public void changeScreenToHome(ActionEvent event) throws IOException
    {
        Parent setHomeParent = FXMLLoader.load(getClass().getResource("../home.fxml"));
        Scene setHomeScene = new Scene (setHomeParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setHomeScene);
        window.show();
    }

    //Initializes the expenses controller
    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
        col_Cost.setPrefWidth(172.0D);
        col_Cost.setResizable(false);
        col_Cost.setCellValueFactory(new PropertyValueFactory("itemCost"));

        col_itemName.setPrefWidth(266.0D);
        col_itemName.setResizable(false);
        col_itemName.setCellValueFactory(new PropertyValueFactory("itemName"));

        table_view.getColumns().addAll(col_Cost, col_itemName);
        table_view.setEditable(true);

        category_comboBox.setItems(categoryList);
        category_comboBox.getSelectionModel().selectFirst();
    }
    
}