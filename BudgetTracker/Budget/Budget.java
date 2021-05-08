package BudgetTracker.Budget;

public class Budget 
{
    private double remainingBudget;
    private double budgetLimit;
    private double budgetAmount;
    private double budgetPct;
    private double totalExpenses;


    //Budget constructor starts here
    public Budget(double budgetAmount, double budgetLimit) 
    {
        budgetAmount= this.budgetLimit;
        budgetLimit = this.budgetLimit;
    }

    //Budget ends starts here
    public Budget(String fromFileRead){
        fromFileRead.split(",");
        Double.parseDouble(fromFileRead);
    }

    // getRemainigBudget method
    public double getRemainingBudget()
    {
        remainingBudget =  budgetLimit - totalExpenses;
        return remainingBudget;
    }

    //addMoney method
    public void addMoney(double money)

    {
       budgetLimit = budgetLimit + money;
    }

    
    public void setBudget(double amount)
    {
        this.budgetLimit = amount;
    }
    
    
    public double getBudgetPct() 
    {
        return remainingBudget / (budgetLimit);
    }

}