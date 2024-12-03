package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import util.userInterface;

public class land extends financing implements Serializable
{
    private String typeOfLand;
    private userInterface user = new userInterface();
    
    public land() throws IOException, InterruptedException 
    {
        user.aditionalParameters("terreno");
        this.propertyValue = user.userPropertyValue();
        this.financingDeadline = user.userFinancingDeadline();
        this.annualInterestRate = user.userAnnualInterest();
        typeOfLand = user.getTypeOfLand();
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
        string.append("Tipo de Terreno: " + typeOfLand + " | ");
        return string.toString();
    }
    public double calculateMonthlyPayment()
    {
        double financing = (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualInterestRate / 12));
        return financing * 1.02;
    }

    public double calculateTotalPayment()
    {
        return calculateMonthlyPayment() * this.financingDeadline * 12;
    }

    public void returnFinancingValues() // returns to the user all the financing information provided.
    {
        System.out.printf("%n=== Dados do Imóvel === %n%nTipo de Terreno: %s %nValor: R$ %.2f %nPrazo do Financiamento: %d %nTaxa de Júros Anual: %.2f%%", 
        this.typeOfLand ,this.propertyValue, this.financingDeadline, this.annualInterestRate * 100);
    }
}
