package BudgetTracker.User;

import BudgetTracker.Budget.Budget;
import BudgetTracker.ExpensesPkg.Expenses;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static String name; //Username
    private static ArrayList<Expenses> userExpense; //user's expenses
    private static Budget userBudget; //user's Budget
    private static LocalDate termLength; //for how long the user intends to use the budget tracker with
                            //the set variables for income, expenses, budget, etc.
    public User(LocalDate term, String userName){termLength = term; name = userName;}
    public User(LocalDate term, String userName, ArrayList<Expenses> expenses, Budget budget)
    {
        termLength = term;
        name = userName;
        userExpense = expenses;
        userBudget = budget;
    }
    public User(){}
    public String getName(){return name;}

    public static void setName(String userName){
        name = userName;
    }


    public static List<Expenses> getUserExpense() {
        userExpense = Expenses.getExpensesTable();
        return userExpense;
    }

    //Overloaded methods
    public static void setUserExpense(ArrayList<Expenses> expenses) {
        userExpense = expenses;
    }
    public static void setUserExpense() {
        userExpense = Expenses.getExpensesTable();
    }

    public static Budget getUserBudget() {
        return userBudget;
    }

    public static void setUserBudget(Budget budget) {
        userBudget = budget;
    }

    public static LocalDate getTermLength() {
        return termLength;
    }

    public static void setTermLength(LocalDate term) {
        termLength = term;
    }

    @Override
    public String toString() {
        return  "name='" + getName() + '\'' +
                ", userExpense=" + getUserExpense() +
                ", userBudget=" + getUserBudget() +
                ", termLength=" + getTermLength();
    }
}
