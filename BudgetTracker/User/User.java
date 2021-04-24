package BudgetTracker.User;

import BudgetTracker.Budget.Budget;
import BudgetTracker.Expenses.Expenses;
import BudgetTracker.Income.Income;

import java.util.ArrayList;
import java.util.Date;

public class User {

    private static String name; //Username
    private static Income userIncome; //holds user's income
    private static ArrayList<Expenses> userExpense; //user's expenses
    private static Budget userBudget; //user's Budget
    private static Date termLength; //for how long the user intends to use the budget tracker with
                            //the set variables for income, expenses, budget, etc.
    private static User userData;
    public User(Date term, String userName){termLength = term; name = userName;}
    public User(Date term, String userName, Income income, ArrayList<Expenses> expenses, Budget budget)
    {
        termLength = term;
        name = userName;
        userIncome = income;
        userExpense = expenses;
        userBudget = budget;
    }
    public User(){}
    public String getName(){return name;}

    public void setName(String userName){
        name = userName;
    }

    public static Income getUserIncome() {
        return userIncome;
    }

    public static void setUserIncome(Income income) {
        userIncome = income;
    }

    public static ArrayList<Expenses> getUserExpense() {
        userExpense = Expenses.getExpensesTable();
        return userExpense;
    }

    public static void setUserExpense(ArrayList<Expenses> expenses) {
        userExpense = Expenses.getExpensesTable();
    }

    public Budget getUserBudget() {
        return userBudget;
    }

    public void setUserBudget(Budget userBudget) {
        this.userBudget = userBudget;
    }

    public Date getTermLength() {
        return termLength;
    }

    public void setTermLength(Date termLength) {
        this.termLength = termLength;
    }

    public static void setUserData(){
        userData.setUserIncome(this.userIncome);

    }
    public static User getUserData(){

    }
    @Override
    public String toString() {
        return  "name='" + getName() + '\'' +
                ", userIncome=" + getUserIncome() +
                ", userExpense=" + getUserExpense() +
                ", userBudget=" + getUserBudget() +
                ", termLength=" + getTermLength();
    }
}
