package util;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class userInterface
{
    public double userPropertyValue() throws IOException, InterruptedException
    {
        clearScreen clearConsole = new clearScreen();
        double value = 0;
        boolean flag = false;
        while (!flag)
        {
            Scanner scanner = new Scanner(System.in);
            try 
            {
                clearConsole.cleanConsole();
                System.out.println("Qual o valor do seu imóvel? ");
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0)
                {
                    clearConsole.cleanConsole();
                    System.out.println("Valor do imóvel inválido. Use apenas números positivos.");
                    Thread.sleep(1700);
                }
                else if (value == 0)
                {
                    clearConsole.cleanConsole();
                    System.out.println("O valor do imóvel deve ser maior do que zero.");
                    Thread.sleep(1700);
                }
                if (value > 0)
                {
                    clearConsole.cleanConsole();
                    System.out.println("O valor do imóvel foi registrado.");
                    flag = true;
                    Thread.sleep(1000);
                }
            }
            catch (InputMismatchException exception) // catch an exception if the user inputs anything besides double
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Use apenas números.");
                flag = false;
                Thread.sleep(1700);
            }
            catch (NumberFormatException exception) // when the first exception occurs the parseDouble function will try to format the faulty string anyway, so this catch fixes that
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Use apenas números.");
                flag = false;
                Thread.sleep(1700);
            }
        }
        return value;
    }
    
    public int userFinancingDeadline() throws IOException, InterruptedException
        {
            clearScreen clearConsole = new clearScreen();
            int value = 0;
            boolean flag = false;
            while (!flag)
            {
                Scanner scanner = new Scanner(System.in);
                try
                {
                    clearConsole.cleanConsole();
                    System.out.println("Qual o prazo do seu financiamento em anos? ");
                    value = Integer.parseInt(scanner.nextLine());
                    if (value < 0)
                    {
                        clearConsole.cleanConsole();
                        System.out.println("Prazo inválido. Use apenas números positivos.");
                        Thread.sleep(1700);
                    }
                    else if (value == 0)
                    {
                        clearConsole.cleanConsole();
                        System.out.println("O prazo do financiamento deve ser maior do que zero.");
                        Thread.sleep(1700);
                    }
                    else if (value > 35)
                    {
                        clearConsole.cleanConsole();
                        System.out.println("O prazo máximo de financiamento é de 35 anos.");
                        Thread.sleep(1700);
                    }
                    if (value > 0 && value <= 35)
                    {
                        clearConsole.cleanConsole();
                        System.out.println("Prazo de financiamento registrado.");
                        flag = true;
                        Thread.sleep(1000);
                    }
                }
                catch (InputMismatchException inputMismatchException) // catch an exception if the user inputs anything besides an int
                {
                    clearConsole.cleanConsole();
                    System.out.println("Valor inválido. Use apenas números inteiros.");
                    Thread.sleep(1700);
                }
                catch (NumberFormatException mumberFormatException) // when the first exception occurs the parseInt function will try to format the faulty string anyway, so this catch fixes that 
                {
                    clearConsole.cleanConsole();
                    System.out.println("Valor inválido. Use apenas números inteiros.");
                    Thread.sleep(1700);
                }
            }
            return value;
        }
    
    public double userAnnualInterest() throws IOException, InterruptedException
    {
        clearScreen clearConsole = new clearScreen();
        double value = 0;
        boolean flag = false;
        while(!flag)
        {
            try
            {
                clearConsole.cleanConsole();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Qual a taxa de júros anual? ");
                value = Double.parseDouble(scanner.nextLine());
                if (value < 0)
                {
                    clearConsole.cleanConsole();
                    System.out.println("Taxa de júros inválida. Use apenas números positivos.");
                    Thread.sleep(1700);
                }
                else if (value == 0)
                {
                    clearConsole.cleanConsole();
                    System.out.println("A taxa de júros anual deve ser maior do que zero.");
                    Thread.sleep(1700);
                }
                else if (value > 12)
                {
                    clearConsole.cleanConsole();
                    System.out.println("A taxa de júros anual máxima é de 12%.");
                    Thread.sleep(1700);
                }
                if (value > 0 && value <= 12)
                {
                    clearConsole.cleanConsole();
                    System.out.println("Taxa de júros anual registrada.");
                    flag = true;
                    Thread.sleep(1000);
                }
            }
            catch (InputMismatchException exception)
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Use apenas números."); // catch an exception if the user inputs anything besides double
                Thread.sleep(1700);
            }
            catch (NumberFormatException exception)
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Use apenas números."); // when the first exception occurs the parseDouble function will try to format the faulty string anyway, so this catch fixes that
                Thread.sleep(1700);
            }
        }
        clearConsole.cleanConsole();
        return value / 100;
    }
}