package main;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.financing;

public class main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        List<financing> financingList = new ArrayList<financing>();
        
        financingList.add(new financing());
        financingList.add(new financing());
        financingList.add(new financing());
        financingList.add(new financing());
        
        double financingTotalPropertyValue = financingList.get(0).getPropertyValue() + // variable to calculate the property price of all financings
        financingList.get(1).getPropertyValue() +
        financingList.get(2).getPropertyValue() +
        financingList.get(3).getPropertyValue();

        double financingTotalValue = financingList.get(0).calculateTotalPayment() + // variable to calculate the total price of all financings
        financingList.get(0).calculateTotalPayment() +
        financingList.get(0).calculateTotalPayment() +
        financingList.get(0).calculateTotalPayment();

        for (int index = 0; index <4; index++)
        {
            System.out.printf("Financiamento %d - Valor do imóvel: R$ %,.2f - Valor do financiamento: R$ %,.2f.%n",
            index + 1, financingList.get(index).getPropertyValue(), financingList.get(index).calculateTotalPayment());
        }

        System.out.printf("%nTotal de todos os imóveis: R$ %,.2f - Total de todos os financiamentos: R$ %,.2f.%n",
        financingTotalPropertyValue, financingTotalValue);
    }
}