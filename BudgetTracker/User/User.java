package BudgetTracker.User;

import BudgetTracker.Budget.Budget;
import BudgetTracker.ExpensesPkg.Expenses;
import BudgetTracker.Income.Income;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User {

    private static String name; //Username
    private static Income userIncome; //holds user's income
    private static ArrayList<Expenses> userExpense; //user's expenses
    private static Budget userBudget; //user's Budget
    private static Period termLength; //for how long the user intends to use the budget tracker with
                            //the set variables for income, expenses, budget, etc.
    public User(Period term, String userName){termLength = term; name = userName;}
    public User(Period term, String userName, Income income, ArrayList<Expenses> expenses, Budget budget)
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

    public static List<Expenses> getUserExpense() {
        userExpense = Expenses.getExpensesTable();
        return userExpense;
    }

    public static void setUserExpense(ArrayList<Expenses> expenses) {
        userExpense = Expenses.getExpensesTable();
    }

    public Budget getUserBudget() {
        return userBudget;
    }

    public void setUserBudget(Budget budget) {
        userBudget = budget;
    }

    public static Period getTermLength() {
        return termLength;
    }

    public static void setTermLength(Period term) {
        termLength = term;
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
