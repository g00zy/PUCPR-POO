package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import util.*;

public class house extends financing implements Serializable
{
    private double houseAreaSize;
    private double landAreaSize;
    private userInterface user = new userInterface();

    public house() throws IOException, InterruptedException
    {
        user.aditionalParameters("casa");
        this.propertyValue = user.userPropertyValue();
        this.financingDeadline = user.userFinancingDeadline();
        this.annualInterestRate = user.userAnnualInterest();
        this.houseAreaSize = user.getHouseAreaSize();
        this.landAreaSize = user.getLandAreaSize();
    }

    public String toString()
    {
        DecimalFormat doubleFormating = new DecimalFormat("#,##0.00");
        StringBuilder string = new StringBuilder();
        string.append("Valor da Propriedade: R$ " + String.valueOf(doubleFormating.format(this.propertyValue)) + " | ");
        string.append("Valor do Financiamento: R$ " + String.valueOf(doubleFormating.format(this.calculateTotalPayment())) + " | ");
        string.append("Valor da Parcela: R$ " + String.valueOf(doubleFormating.format(this.calculateMonthlyPayment())) + " | ");
        string.append("Júros Anual: " + String.valueOf(this.annualInterestRate * 100) + "% | ");
        string.append("Tempo de Financiamento: " + String.valueOf(this.financingDeadline) + " Anos | ");
        string.append("Área Construída: " + String.valueOf(doubleFormating.format(this.landAreaSize)) + " mm² | ");
        string.append("Área Construída: " + String.valueOf(doubleFormating.format(this.houseAreaSize)) + " mm² | ");
        return string.toString();
    }

    private void interestIsBiggerThanInitialTax(double MonthlyInterestValue, double initialTaxValue) throws interestIsBiggerThanInitialTaxException
    {
        if (initialTaxValue > MonthlyInterestValue)
        {
            throw new interestIsBiggerThanInitialTaxException("Interest value is less than the initial tax value of 80.");
        }
    } 
    
    public double calculateMonthlyPayment()
    {
        double initialTaxValue = 80;
        double monthlyTax = ((this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualInterestRate / 12)) + initialTaxValue) - this.propertyValue;
        try
        {
            interestIsBiggerThanInitialTax(monthlyTax, initialTaxValue);
        }
        catch (interestIsBiggerThanInitialTaxException exception)
        {
            initialTaxValue = monthlyTax;
        }
        return (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualInterestRate / 12)) + initialTaxValue;
    }
    
    public double calculateTotalPayment()
    {
        return calculateMonthlyPayment() * this.financingDeadline * 12;
    }

    public void returnFinancingValues() // returns to the user all the financing information provided.
    {
        System.out.printf("%n=== Dados do Imóvel === %n%nTamanho da casa: %.2f m² %nTamanho do Terreno: %.2f m² %nValor: R$ %.2f %nPrazo do Financiamento: %d %nTaxa de Júros Anual: %.2f%%", 
        this.houseAreaSize, this.landAreaSize, this.propertyValue, this.financingDeadline, this.annualInterestRate * 100);
    }
}
