package util;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class userInterface implements Serializable
{
    private clearScreen clearConsole = new clearScreen();
    private double houseAreaSize;
    private double landAreaSize;
    private int numberOfGarages;
    private int apartmentNumber;
    private int apartmentFloor;
    private String typeOfLand;

    public double getHouseAreaSize()
    {
        return this.houseAreaSize;
    }
    public double getLandAreaSize()
    {
        return this.landAreaSize;
    }
    public int getNumberOfGarages()
    {
        return this.numberOfGarages;
    }
    public int getApartmentNumber()
    {
        return this.apartmentNumber;
    }
    public int getApartmentFloor()
    {
        return this.apartmentFloor;
    }
    public String getTypeOfLand()
    {
        return this.typeOfLand;
    }

    public void aditionalParameters(String type) throws IOException, InterruptedException
    {   
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;

        while (!flag)
        {

            if (type.equalsIgnoreCase("casa"))
            {  
                try
                {
                    clearConsole.cleanConsole();
                    System.out.println("Qual o tamanho da área construída em metros quadrados? ");
                    this.houseAreaSize = Double.parseDouble(scanner.nextLine());
                    clearConsole.cleanConsole();
                    System.out.println("Qual o tamanho do terreno em metros quadrados? ");
                    this.landAreaSize = Double.parseDouble(scanner.nextLine());
                    flag = true;
                }
                catch (InputMismatchException | NumberFormatException exception) // catch an exception if the user inputs anything besides the right type
                {                                                                // when the first exception occurs the parse function will try to format the faulty string anyway, so this catch fixes that
                    clearConsole.cleanConsole();
                    System.out.println("Valor inválido.");
                    flag = false;
                    Thread.sleep(1700);
                }
            }
    
            if (type.equalsIgnoreCase("apartamento"))
            {
                try
                {
                    clearConsole.cleanConsole();
                    System.out.println("Quantas garagens tem o apartamento? ");
                    this.numberOfGarages = Integer.parseInt(scanner.nextLine());
                    clearConsole.cleanConsole();
                    System.out.println("Qual o número do apartamento? ");
                    this.apartmentNumber = Integer.parseInt(scanner.nextLine());
                    clearConsole.cleanConsole();
                    System.out.println("Qual o andar do apartamento? ");
                    this.apartmentFloor = Integer.parseInt(scanner.nextLine());
                    flag = true;
                }
                catch (InputMismatchException | NumberFormatException exception) // catch an exception if the user inputs anything besides the right type
                {                                                                // when the first exception occurs the parse function will try to format the faulty string anyway, so this catch fixes that
                    clearConsole.cleanConsole();
                    System.out.println("Valor inválido.");
                    flag = false;
                    Thread.sleep(1700);
                }
            }

            if (type.equalsIgnoreCase("terreno"))
            {
                try
                {
                    clearConsole.cleanConsole();
                    System.out.println("Qual o tipo do terreno (Residencial ou Comercial)? ");
                    this.typeOfLand = scanner.nextLine();
                    flag = true;
                }
                catch (InputMismatchException | NumberFormatException exception) 
                {
                    clearConsole.cleanConsole();
                    System.out.println("Valor inválido.");
                    flag = false;
                    Thread.sleep(1700);
                }
            }
        }
    }

    public boolean checkValue(double value) throws valueIsLessThanZeroException, ValueIsEqualToZeroException
    {   
        boolean flag;
        if (value < 0)
        {
            flag = false;
            throw new valueIsLessThanZeroException();
        }
        else if (value == 0)
        {
            flag = false;
            throw new ValueIsEqualToZeroException();
        }
        else
        {
            flag = true;
        }
        return flag;
    }

    public double userPropertyValue() throws IOException, InterruptedException
    {
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
                flag = checkValue(value);
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
            catch (valueIsLessThanZeroException | ValueIsEqualToZeroException exception)
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Utilize números maiores do que zero.");
                flag = false;
                Thread.sleep(1700);
            }
        }
        return value;
    }
    
    public int userFinancingDeadline() throws IOException, InterruptedException
        {
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
                    flag = checkValue(value);
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
                catch (valueIsLessThanZeroException | ValueIsEqualToZeroException exception)
                {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Utilize números maiores do que zero.");
                flag = false;
                Thread.sleep(1700);
                }
            }
            return value;
        }
    
    public double userAnnualInterest() throws IOException, InterruptedException
    {
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
                flag = checkValue(value);
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
            catch (valueIsLessThanZeroException | ValueIsEqualToZeroException exception)
            {
                clearConsole.cleanConsole();
                System.out.println("Valor inválido. Utilize números maiores do que zero.");
                flag = false;
                Thread.sleep(1700);
            }
        }
        clearConsole.cleanConsole();
        return value / 100;
    }
}