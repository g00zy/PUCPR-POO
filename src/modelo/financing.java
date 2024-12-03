package modelo;

import java.io.Serializable;

public abstract class financing implements Serializable
{
    protected double propertyValue;
    protected int financingDeadline;
    protected double annualInterestRate;

    // get methods for all the atributes
    public double getPropertyValue()
    {
        return this.propertyValue;
    }
    public double getfinancingDeadline()
    {
        return this.financingDeadline;
    }
    public double getAnnualInterestRate()
    {
        return this.annualInterestRate;
    }
    
    public abstract void returnFinancingValues();
    public abstract double calculateMonthlyPayment();
    public abstract double calculateTotalPayment();
}