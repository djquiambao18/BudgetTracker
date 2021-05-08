package BudgetTracker.SaveFile;

import BudgetTracker.ExpensesPkg.Expenses;
import BudgetTracker.Income.Income;
import javafx.scene.control.Alert;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveFile {
    private static File expenses_SaveFile = new File("userExpenses.csv");   //assigned within the save methods.
    private static File income_SaveFile = new File("incomeData.csv");
    /*
    * Expenses save data method
    * */
    public static boolean saveExpenses(List<Expenses> expenses) throws IOException {

        if(expenses_SaveFile.exists()){
            File fileOut = new File("userExpenses.csv");
            PrintWriter writer = new PrintWriter(fileOut);
            for (Expenses exp: expenses) {
                writer.print(exp.getItemName() +"," + exp.getItemCost() + "," +exp.getItemCategory() +"\n");
            }
            writer.close();
            return true;
        }
        else{
            File fileOut = new File("userExpenses.csv");
            return fileOut.createNewFile();
        }
    }

    /*
    * Expenses load data method
    * */
    public static ArrayList<Expenses> loadExpenses() throws IOException {
        ArrayList<Expenses> tempArrayList = new ArrayList<>();
        try {
            if(expenses_SaveFile.exists()) {
                Scanner reader = new Scanner(expenses_SaveFile);
                reader.useDelimiter("[,\\n]+");
                while (reader.hasNext()) {
                    Expenses expenses = new Expenses(reader.next(), Double.parseDouble(reader.next()), reader.next());
                    tempArrayList.add(expenses);
                }
            }
            else
            {
                Alert save_existsAlert = new Alert(Alert.AlertType.INFORMATION);
                save_existsAlert.setContentText("No data Found...");
                save_existsAlert.showAndWait();    //waits for user input to press OK to continue
            }
        }
        catch (IOException | NumberFormatException e)
        {
            Alert save_existsAlert = new Alert(Alert.AlertType.INFORMATION);
            save_existsAlert.setContentText("No readable data Found...");
            save_existsAlert.showAndWait();    //waits for user input to press OK to continue
            e.getStackTrace();
        }
        return tempArrayList;
    }

    public static boolean income_save(Income income){
        try {
                PrintWriter writer = new PrintWriter(income_SaveFile.getAbsolutePath());
                writer.println(income.getTotalIncomeBalance() + "," + income.getWageEarnings() +"\n");
                writer.close();
                return true;

        }catch (IOException | NumberFormatException | NullPointerException e)
        {
            e.getStackTrace();
        }
        return false;
    }

    public static Income income_load(){
        Income income = new Income();
        try{

            Scanner reader = new Scanner(income_SaveFile);
            reader.useDelimiter("[,\\n]+");
            while(reader.hasNext()){
                //set income vars
                income.setTotalIncomeBalance(Double.parseDouble(reader.next()));
                income.setWageEarnings(Double.parseDouble(reader.next()));
            }
        }
        catch(IOException | NumberFormatException e)
        {
            e.getStackTrace();
        }
        return income;
    }

    //Checks if file already exists.
    public static boolean fileExists(){
        return expenses_SaveFile.exists() && income_SaveFile.exists();
    }
}
