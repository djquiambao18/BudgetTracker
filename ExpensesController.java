package application;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ExpensesController implements Initializable {
    @FXML
    private Button button_addItem;
    @FXML
    private Button button_subItem;
    @FXML
    private TextField field_cost;
    @FXML
    private TextField field_name;
    @FXML
    private final ObservableList<Expenses> expenseList = FXCollections.observableArrayList();
    @FXML
    private final TableColumn col_Cost = new TableColumn("Amount ($)");
    @FXML
    private final TableColumn col_itemName = new TableColumn("Item Name");
    @FXML
    private TableView<Expenses> table_view;
    @FXML 
    private Button changeScreenToHomebtn;

    public ExpensesController() 
    {
    	
    }

    
    public void addItemClick() 
    {
        String str_cost = this.field_cost.getText();
        String str_name = this.field_name.getText();

        try 
        {
            if (str_cost.matches("\\$?[0-9]+\\.{0,1}([0-9]{0,2})") && !str_name.isEmpty()) 
            {
                this.expenseList.add(new Expenses(str_name, Double.parseDouble(str_cost)));
                this.field_cost.clear();
                this.field_name.clear();
                this.table_view.setItems(this.expenseList);
            } 
            
            else 
            {
                System.out.println("Invalid input!");
            }
        } 
        
        catch (Exception e) 
        {
            e.getStackTrace();
        }

    }

    public void subtractItemClick()
    {
        Expenses selected = table_view.getSelectionModel().getSelectedItem();
        table_view.getItems().remove(selected);
    }

   
    public void changeScreenToHome(ActionEvent event) throws IOException
    {

        Parent setHomeParent = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene setHomeScene = new Scene (setHomeParent);


        //This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(setHomeScene);
        window.show();

    }

    public void initialize(URL url, ResourceBundle resourceBundle) 
    {
        this.col_Cost.setPrefWidth(172.0D);
        this.col_Cost.setResizable(false);
        this.col_Cost.setCellValueFactory(new PropertyValueFactory("itemCost"));
        this.col_itemName.setPrefWidth(266.0D);
        this.col_itemName.setResizable(false);
        this.col_itemName.setCellValueFactory(new PropertyValueFactory("itemName"));
        this.table_view.getColumns().addAll(new TableColumn[]{this.col_Cost, this.col_itemName});
        this.table_view.setEditable(true);
    }
    
}