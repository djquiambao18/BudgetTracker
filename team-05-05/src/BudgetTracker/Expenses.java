//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package BudgetTracker;

public class Expenses {
    private String itemName;
    private double itemCost;
    private double monthlyExpense;
    private double rentExpense;
    private double utilitiesExpense;
    private double subscriptionExpense;
    private double withdrawalAmount;

    Expenses() {
    }

    Expenses(double rent, double utilities, double subscriptionExpense) {
        this.rentExpense = rent;
        this.utilitiesExpense = utilities;
        this.subscriptionExpense = subscriptionExpense;
    }

    Expenses(String itemName, double itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return this.itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getMonthlyExpense() {
        return this.monthlyExpense;
    }

    public void setMonthlyExpense(double monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }

    public double getRentExpense() {
        return this.rentExpense;
    }

    public void setRentExpense(double rentExpense) {
        this.rentExpense = rentExpense;
    }

    public double getUtilitiesExpense() {
        return this.utilitiesExpense;
    }

    public void setUtilitiesExpense(double utilitiesExpense) {
        this.utilitiesExpense = utilitiesExpense;
    }

    public double getSubscriptionExpense() {
        return this.subscriptionExpense;
    }

    public void setSubscriptionExpense(double subscriptionExpense) {
        this.subscriptionExpense = subscriptionExpense;
    }

    public double getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }
}
