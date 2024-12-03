package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;
import util.userInterface;

public class apartment extends financing implements Serializable
{
    private int numberOfGarages;
    private int apartmentNumber;
    private int apartmentFloor;
    private userInterface user = new userInterface();

    public apartment() throws IOException, InterruptedException 
    {
        user.aditionalParameters("apartamento");
        this.propertyValue = user.userPropertyValue();
        this.financingDeadline = user.userFinancingDeadline();
        this.annualInterestRate = user.userAnnualInterest();
        numberOfGarages = user.getNumberOfGarages();
        apartmentNumber = user.getApartmentNumber();
        apartmentFloor = user.getApartmentFloor();
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
        string.append("Andar do Apartamento: " + String.valueOf(this.apartmentFloor) + " | ");
        string.append("Número do Apartamento: " + String.valueOf(this.apartmentNumber) + " | ");
        string.append("Quantidade de Garagens: " + String.valueOf(this.numberOfGarages) + " | ");
        return string.toString();
    }

    public double calculateMonthlyPayment()
    {
        double monthlyTax = getAnnualInterestRate() / 12;
        double monthlyFinancingDeadline = getfinancingDeadline() * 12;
        return (propertyValue * (Math.pow((1 + monthlyTax), monthlyFinancingDeadline))) / (Math.pow((1 + monthlyTax), monthlyFinancingDeadline) - 1) / monthlyFinancingDeadline;
    }
    
    public double calculateTotalPayment()
    {
        return calculateMonthlyPayment() * this.financingDeadline * 12;
    }

    public void returnFinancingValues() // returns to the user all the financing information provided.
    {
        System.out.printf("%n=== Dados do Imóvel === %n%nNúmero de Garagens: %d %nNúmero do Apartamento: %d %nAndar do Apartamento: %d %nValor: R$ %.2f %nPrazo do Financiamento: %d %nTaxa de Júros Anual: %.2f%%", 
        this.numberOfGarages, this.apartmentNumber, this.apartmentFloor, this.propertyValue, this.financingDeadline, this.annualInterestRate * 100);
    }
}
