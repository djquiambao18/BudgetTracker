package application;

public class Budget 
{
    private double remainingBudget;
    private double budgetLimit;
    private double budgetPct;
    private double totalExpenses;

     
    public Budget(double budgetLimit) 
    {
       this.budgetLimit = budgetLimit;
    }

    public void setBudget(double amount)
    {
        this.budgetLimit = amount;
    }
    
    public double getBudgetLimit()
    {
    	return budgetLimit;
    }
    
    public double getRemainingBudget()
    {
        remainingBudget =  budgetLimit - totalExpenses;
        return remainingBudget;
    }

    public void increaseBudgetLimit(double amount)
    {
       this.budgetLimit = this.budgetLimit + amount;
    }
    
    public void decreaseBudgetLimit(double amount)
    {
    	this.budgetLimit = this.budgetLimit - amount;
    }

    public double getBudgetPct() 
    {
        this.budgetPct = remainingBudget / (budgetLimit);
        return budgetPct;
    }

}