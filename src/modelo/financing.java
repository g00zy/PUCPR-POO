package modelo;
import java.io.IOException;
import util.userInterface;
public class financing 

{
    private double propertyValue; // P
    private int financingDeadline; // t
    private double annualInterestRate; // r

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

    public void returnFinancingValues() // returns to the user all the financing information the user provided.
    {
        System.out.printf("%n=== Dados do Imóvel === %n%nValor: R$ %.2f %nPrazo do Financiamento: %d %nTaxa de Júros Anual: %.2f%%", 
        this.propertyValue, this.financingDeadline, this.annualInterestRate * 100);
    }
    
    public financing() throws IOException, InterruptedException
    {
        userInterface user = new userInterface();
        this.propertyValue = user.userPropertyValue();
        this.financingDeadline = user.userFinancingDeadline();
        this.annualInterestRate = user.userAnnualInterest();
    }
    
    public double calculateMonthlyPayment()
    {
        // Pagamento mensal = (valor do imóvel / (prazo do financiamento em anos * 12)) * (1 + (taxa anual / 12))
        return (this.propertyValue / (this.financingDeadline * 12)) * (1 + (this.annualInterestRate / 12));
    }
    
    public double calculateTotalPayment()
    {
        // Total do pagamento = pagamento mensal * prazo do financiamento em anos * 12
        return calculateMonthlyPayment() * this.financingDeadline * 12;
    }
}