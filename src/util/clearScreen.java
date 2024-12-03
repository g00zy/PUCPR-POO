package util;

import java.io.IOException;
import java.io.Serializable;

public class clearScreen implements Serializable
{
    private final String operatinglSystem = System.getProperty("os.name");
    public void cleanConsole() throws IOException, InterruptedException
    {   // clear the screen so the user can read the information more easly
        
        if (operatinglSystem.contains("Windows"))  // for windows OS
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else // for unix based OS
        {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }
}