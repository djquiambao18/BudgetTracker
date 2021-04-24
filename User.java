package application;

import java.util.Date;

public class User 
{
	private String name;
	private Income objInc;
	private Expenses objExp;
	private Budget objBudget;
	private Date termLength;
	
	public User(Date termLength, String name)
	{
		this.termLength = termLength;
		this.name = name;
	}
	
	public User(Date termLength, String name, Income objInc, Expenses objExp, Budget objBudget)
	{
		this.termLength = termLength;
		this.name = name;	
		this.objInc = objInc;
		this.objExp = objExp;
		this.objBudget = objBudget;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Income getIncome() 
	{
		return objInc;
	}
	
	public Expenses getExpenses()
	{
		return objExp;
	}
	
	public Budget getBudget()
	{
		return objBudget;
	}
	
	public Date getTermLength()
	{
		return termLength;
	}
	
	public void setIncome(Income objInc)
	{
		this.objInc = objInc;
	}
	
	public void setExpenses(Expenses objExp)
	{
		this.objExp = objExp;
	}
	
	public void setBudget(Budget objBudget)
	{
		this.objBudget = objBudget;
	}
	
}
