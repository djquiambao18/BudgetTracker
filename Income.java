package application;

public class Income 
{
	private double hourlyWage;
	private double hoursWorked;
	private double wageEarnings;
	private double depositCashAmount;
	private double totalCashBalance = 0;
	
	public Income(double hourlyWage, double hoursWorked)
	{
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
	}
	
	
	public Income(double hourlyWage, double hoursWorked, double depositCashAmount)
	{
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
		this.depositCashAmount = depositCashAmount;
	}
	
	
	public void setHourlyWage(double hourlyWage)
	{
		if(hourlyWage < 0.0)
		{
			throw new IllegalArgumentException("Hourly wage cannot be less than 0");
		}
		this.hourlyWage = hourlyWage;
	}
	
	
	public void setHoursWorked(double hoursWorked)
	{
		if(hoursWorked < 0.0)
		{
			throw new IllegalArgumentException("Hours worked cannot be less than 0");
		}
		this.hoursWorked = hoursWorked;
	}
	
	
	public void wageEarnings()
	{
		wageEarnings = hourlyWage * hoursWorked;
	}
	
	
	public double getWageEarnings()
	{
		return wageEarnings;
	}
	
	
	public void depositWages()
	{
		totalCashBalance = totalCashBalance + wageEarnings; 
	}
	
	
	public void setDepositAmount(double depositCashAmount)
	{
		if(depositCashAmount < 0.0)
		{
			throw new IllegalArgumentException("Cash amount cannot be less than 0");
		}
		this.depositCashAmount = depositCashAmount;
	}
	
	
	//TODO we still need to find a way to subtract totalExpenses from totalCashBalance
	public void depositCash()
	{
		totalCashBalance = totalCashBalance + depositCashAmount;
	}
	

	public double getTotalIncomeBalance()
	{
		return totalCashBalance;
	}
	
}
