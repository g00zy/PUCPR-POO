package util;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import modelo.financing;

public class fileManagement 
{
    private clearScreen clearConsole = new clearScreen();
    private FileWriter fileWriter  = null;
    private FileReader fileReader = null;
    private ObjectOutputStream objectWriter = null;
    private ObjectInputStream objectReader = null;

    public void fileWriter(String fileName, Object fileToWritte, boolean append) // write stuff on file once
    {
        try
        {
            if (append)
            {
                fileWriter = new FileWriter(fileName, true);
                fileWriter.write(fileToWritte.toString() + "\n");
                fileWriter.close();
            }
            else
            {
                fileWriter = new FileWriter(fileName);
                fileWriter.write(fileToWritte.toString() + "\n");
                fileWriter.close();
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
    }

    public void fileWriter(String fileName, List fileToWritte, boolean append) // write list on file
    {
        try
        {
            if (!append)
            {
                try
                {
                    Path pathOfFileToDelete = Paths.get(fileName);
                    Files.delete(pathOfFileToDelete);
                }
                catch (NoSuchFileException exception)
                {

                }
                fileWriter = new FileWriter(fileName, true);
                for (int index = 0; index < fileToWritte.size(); index++)
                {
                    fileWriter.write(fileToWritte.get(index).toString() + "\n");
                }
                fileWriter.close();
            }
            else
            {
                fileWriter = new FileWriter(fileName, true);
                for (int index = 0; index < fileToWritte.size(); index++)
                {
                    fileWriter.write(fileToWritte.get(index).toString() + "\n");
                }
                fileWriter.close();
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
    }

    public void fileReader(Object fileToRead) // read the contents of file 
    {
        try
        {
            fileReader = new FileReader(fileToRead.toString());
            int data = fileReader.read();
            while (data != -1)
            {
                System.out.print((char) data);
                data = fileReader.read();
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
    }

    public void objectWriter(String fileName, Object objectToWritte) // write objects on file
    {
        try
        {
            objectWriter = new ObjectOutputStream(new FileOutputStream(fileName));
            objectWriter.writeObject(objectToWritte);
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
    }

    public void objectReader(String objectToRead) throws IOException, InterruptedException // read the contents of file
    {
        try
        {
            objectReader = new ObjectInputStream(new FileInputStream(objectToRead));
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
