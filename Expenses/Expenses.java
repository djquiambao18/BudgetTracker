package Expenses;

public class Expenses 
{
	private String itemName;
    private double itemCost;
    private String itemCategory;
    private double monthlyExpense;
    private double rentExpense;
    private double utilitiesExpense;
    private double subscriptionExpense;
    private double withdrawalAmount;

    Expenses() 
    {
    	
    }

    Expenses(double rent, double utilities, double subscriptionExpense)
    {
        this.rentExpense = rent;
        this.utilitiesExpense = utilities;
        this.subscriptionExpense = subscriptionExpense;
    }

    Expenses(String itemName, double itemCost, String itemCategory)
    {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemCategory = itemCategory;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public double getItemCost()
    {
        return itemCost;
    }

    public void setItemCost(double itemCost)
    {
        this.itemCost = itemCost;
    }

    public String getItemCategory() { return itemCategory; }

    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }

    public double getMonthlyExpense() 
    {
        return monthlyExpense;
    }

    public void setMonthlyExpense(double monthlyExpense) 
    {
        this.monthlyExpense = monthlyExpense;
    }

    public double getRentExpense() 
    {
        return rentExpense;
    }

    public void setRentExpense(double rentExpense) 
    {
        this.rentExpense = rentExpense;
    }

    public double getUtilitiesExpense() 
    {
        return utilitiesExpense;
    }

    public void setUtilitiesExpense(double utilitiesExpense) 
    {
        this.utilitiesExpense = utilitiesExpense;
    }

    public double getSubscriptionExpense() 
    {
        return subscriptionExpense;
    }

    public void setSubscriptionExpense(double subscriptionExpense) 
    {
        this.subscriptionExpense = subscriptionExpense;
    }

    public double getWithdrawalAmount() 
    {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) 
    {
        this.withdrawalAmount = withdrawalAmount;
    }
}
