package BudgetTracker.ExpensesPkg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Expenses
{
	private String itemName;
    private double itemCost;
    private String itemCategory;
    private double monthlyExpense;
    private static double rentExpense;
    private static double utilitiesExpense;
    private double subscriptionExpense;
    private double withdrawalAmount;
    private static ArrayList<Expenses> expensesTable;
    //Following variables: To hold the data from Log Expenses feature.
    //They will also help with displaying on the Summary pages properly
    private static double totalGrocery;
    private static double totalMerchandise;
    private static double totalRestaurants;
    private static double totalTransportation;
    private static double totalOthers;

    Expenses() 
    {}

    Expenses(double rent, double utilities, double subscriptionExpense)
    {
        rentExpense = rent;
        utilitiesExpense = utilities;
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
        return this.itemName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public double getItemCost() 
    {
        return this.itemCost;
    }

    public void setItemCost(double itemCost)
    {
        this.itemCost = itemCost;
    }

    public String getItemCategory() { return itemCategory; }

    public void setItemCategory(String itemCategory) { this.itemCategory = itemCategory; }

    public double getMonthlyExpense()
    {
        return this.monthlyExpense;
    }

    public void setMonthlyExpense(double monthlyExpense) 
    {
        this.monthlyExpense = monthlyExpense;
    }

    public static double getRentExpense()
    {
        return rentExpense;
    }

    public static void setRentExpense()
    {
        double rent = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Rent"))
            {
                rent += exp.getItemCost();
            }
        }
        rentExpense = rent;
    }

    public static double getUtilitiesExpense()
    {
        return utilitiesExpense;
    }

    public static void setUtilitiesExpense()
    {
        double utilities = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Utilities"))
            {
                utilities += exp.getItemCost();
            }
        }
        utilitiesExpense = utilities;
    }
    public static double getTotalUtil_Rent(){
        return (utilitiesExpense + rentExpense);
    }

    public double getSubscriptionExpense() 
    {
        return this.subscriptionExpense;
    }

    public void setSubscriptionExpense(double subscriptionExpense) 
    {
        this.subscriptionExpense = subscriptionExpense;
    }

    public double getWithdrawalAmount() 
    {
        return this.withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) 
    {
        this.withdrawalAmount = withdrawalAmount;
    }

    public static ArrayList<Expenses> getExpensesTable(){
        return expensesTable;
    }

    //--- Getters and Setters for the SUMMARY Pages Totals in each category
    //Sets the total grocery expense for use with Summary.
    public static void setTotalGrocery(){
        double groceryTotal = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Groceries"))
            {
                groceryTotal += exp.getItemCost();
            }
        }
        totalGrocery = groceryTotal;
    }

    public static double getTotalGrocery(){
        return totalGrocery;
    }

    public static void setTotalMerchandise(){
        double merchandiseTotal = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Merchandise"))
            {
                merchandiseTotal += exp.getItemCost();
            }
        }
        totalMerchandise = merchandiseTotal;
    }
    public static double getTotalMerchandise() {
        return totalMerchandise;
    }

    public static void setTotalRestaurants(){
        double restaurant = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Restaurants"))
            {
                restaurant += exp.getItemCost();
            }
        }
        totalRestaurants = restaurant;
    }


    public static double getTotalRestaurants() {
        return totalRestaurants;
    }

    public static void setTotalTransportation(){
        double transport = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Restaurants"))
            {
                transport += exp.getItemCost();
            }
        }
        totalTransportation = transport;
    }

    public static double getTotalTransportation() {
        return totalTransportation;
    }

    public static void setTotalOthers(){
        double others = 0.0;
        for (Expenses exp : expensesTable) {
            if(exp.getItemCategory().equals("Restaurants"))
            {
                others += exp.getItemCost();
            }
        }
        totalOthers = others;
    }

    public static double getTotalOthers() {
        return totalOthers;
    }

    public static void setExpensesTable(ArrayList<Expenses> expenses){
        expensesTable = expenses;
    }
}
