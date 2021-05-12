package BudgetTracker.Budget;

import BudgetTracker.ExpensesPkg.Expenses;

public class Budget
{
    private double remainingBudget;
    private static double budgetAmount;
    private final double budgetLimit = budgetAmount * 0.1;
    private double budgetPct;
    private static final double totalExpenses = Expenses.getTotalExpenses();

    //Budget constructor starts here
    public Budget(double amount)
    {
        budgetAmount = amount;
    }

    public Budget() {}

    // getRemainingBudget method
    public double getRemainingBudget()
    {
        remainingBudget =  budgetAmount - totalExpenses;
        return remainingBudget;
    }

    //addMoney method
    public void addMoney(double money)

    {
        budgetAmount += money;
    }

    
    public void setBudget(double amount)
    {
        budgetAmount = amount;
    }

    public double getBudget()
    {
        return budgetAmount;
    }
    public double getBudgetPct() 
    {
        return remainingBudget / (budgetLimit);
    }

}