package application;


import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.SysexMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SaveFile {
    private static File saveFile;   //assigned within the save methods.
    private static FileChooser fileChooser = new FileChooser();
    private static FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Text File", "*.txt");
    private static User savedUserInfo;

    public static boolean save(User userData){
        try {
        if(saveFile.exists()) {
                PrintWriter writer = new PrintWriter(saveFile);
                //first field: User's name
                //second field: User's budget
                //third field: user's income
                savedUserInfo = userData;
                writer.println(userData.getName()+"|"+userData.getUserBudget()+"|"+userData.getUserIncome()+"|"+userData.getUserExpense()+"|"+userData.getTermLength());
                //close file
                writer.close();
        }
        else{
            PrintWriter writer = new PrintWriter(saveFile);
            writer.println(userData.getName()+"|"+userData.getUserBudget()+"|"+userData.getUserIncome()+"|"+userData.getUserExpense()+"|"+userData.getTermLength());
            //close file
            writer.close();
        }
            return true;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    //For initial boot
    //Will return TRUE if EXISTING FILE is detected.
    //False if File does not exist. Then, we save the data.
    public static boolean save(){
        /*fileChooser.getExtensionFilters().add(extensionFilter);
        saveFile = fileChooser.showSaveDialog(stage);*/
        saveFile = new File("userData.csv");
        try {
            if (saveFile.createNewFile()) {
                Alert save_existsAlert = new Alert(Alert.AlertType.INFORMATION);
                save_existsAlert.setContentText("Saving Data...");
                save_existsAlert.showAndWait();    //waits for user input to press OK to continue
                return false;
            }
        }
        catch(IOException e)
        {
            e.getStackTrace();
        }
        return true;
    }
    public static boolean loadFile(){
        try {
            if (saveFile.exists()) {
                Scanner readFile = new Scanner(saveFile);
                readFile.useDelimiter("|");
                while(readFile.hasNextLine()){
                    savedUserInfo.setName(readFile.next());
                    //new Budget(readFile.next());
                    //savedUserInfo.setUserBudget(readFile.next());

                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return saveFile.exists();
    }
}
