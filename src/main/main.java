package main;

import java.io.IOException;
import java.util.*;
import modelo.*;
import util.fileManagement;

public class main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        fileManagement fileManagement = new fileManagement();
        List<financing> financingList = new ArrayList<>();

        financingList.add(new land());
        financingList.add(new house());
        financingList.add(new apartment());

        // it's possible to use the method fileWriter() with indexes of lists and whole lists if you want to write something without having to repeat the method or use a for loop here
        // the first paramether is the name of the file to be written, the seccond is what's going to be written. It accepts an Objetc to a single write operation or it accepts a List for a continuous write operation.
        // the third paramether is a boolean to check if the user wants to save the contents of the file (if it already exists) and then write into it, or if the user wants to erase any previous file to write a new one.
        fileManagement.fileWriter("financingDetails.txt", financingList, false); 
        fileManagement.fileReader("financingDetails.txt");
        
        System.out.println("");

        fileManagement.objectWriter("financingList.list", financingList.get(0));
        fileManagement.objectReader("financingList.list");
    }
}