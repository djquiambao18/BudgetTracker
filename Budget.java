package application;

public class Budget 
{
    private double remainingBudget;
    private double budgetLimit;
    private double budgetPct;
    private double totalExpenses;

    public Budget()
    {
    	
    }
    
    public Budget(double budgetLimit) 
    {
    	this.budgetLimit = budgetLimit;
    }
   

    public Budget(String fromFileRead){
        fromFileRead.split(",");
        Double.parseDouble(fromFileRead);
    }

    
    public double getRemainingBudget()
    {
        remainingBudget =  budgetLimit - totalExpenses;
        return remainingBudget;
    }

    
    public void increaseBudgetLimit(double amount)

    {
       budgetLimit = budgetLimit + amount;
    }
    
    
    public void decreaseBudgetLimit(double amount)

    {
       budgetLimit = budgetLimit - amount;
    }

    
    public void setBudget(double amount)
    {
        this.budgetLimit = amount;
    }
    
    
    public double getBudgetLimit()
    {
    	return budgetLimit;
    }
    
    
    public double getBudgetPct() 
    {
        this.budgetPct = remainingBudget / budgetLimit;
        return budgetPct;
    }

}