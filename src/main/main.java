package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;
import util.clearScreen;

public class main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        clearScreen clearConsole = new clearScreen();
        FileWriter stringWriter  = null;
        FileReader stringReader = null;
        ObjectOutputStream objectWriter = null;
        ObjectInputStream objectReader = null;

        List<financing> financingList = new ArrayList<financing>();

        financingList.add(new land());
        financingList.add(new house());
        financingList.add(new apartment());

        // write stuff on file financingDetails.txt
        try
        {
            stringWriter = new FileWriter("financingDetails.txt");
            stringWriter.write(financingList.get(0).toString() + "\n");
            stringWriter.write(financingList.get(1).toString() + "\n");
            stringWriter.write(financingList.get(2).toString() + "\n");
            stringWriter.close();
            System.out.println("");
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File Not Found.");
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        // read the contents of file financingDetails.txt 
        try
        {
            stringReader = new FileReader("financingDetails.txt");
            int data = stringReader.read();
            while (data != -1)
            {
                System.out.print((char) data);
                data = stringReader.read();
            }
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File Not Found.");
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        // write stuff on file financingList.list
        try
        {
            objectWriter = new ObjectOutputStream(new FileOutputStream("financingList.list"));
            objectWriter.writeObject(financingList.get(0));
            objectWriter.writeObject(financingList.get(1));
            objectWriter.writeObject(financingList.get(2));
            objectWriter.flush();
            objectWriter.close();
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("File Not Found.");
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        // read the contents of file financingList.list
        try
        {
            objectReader = new ObjectInputStream(new FileInputStream("financingList.list"));
            Object object = null;
            while ((object = objectReader.readObject()) != null)
            {
                if (object instanceof financing)
                {
                    System.out.println(((financing)object).toString());
                }
            }
            objectReader.close();
        }
        catch (FileNotFoundException exception)
        {
            clearConsole.cleanConsole();
            System.out.println("File Not Found.");
        }
        catch (ClassNotFoundException exception)
        {
            clearConsole.cleanConsole();
            System.out.print("class not found.");
        }
        catch (EOFException exception)
        {

        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}