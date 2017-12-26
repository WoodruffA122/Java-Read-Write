/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wedding1;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
/**
 *
 * @author arw5550
 */
public class Wedding1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<String> bgNames = new ArrayList<String>();
        ArrayList<String> names = new ArrayList<String>();

        bgNames = getBrideGroomName();
        names = getAllNames();
        
        double sf = getSquareFootage();
        int atten = getAttendance();
        double sfpt = getAttendeesPerSqft(sf,atten);
        
        outputInfo(bgNames, names, sf,atten,sfpt); //Calls file output method and passes needed parameters
        readFile(); //reads the file; no parameters needed
    }
    
    public static ArrayList<String> getBrideGroomName()
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> bgList = new ArrayList<String>();
        
        System.out.println("Please enter the name of the bride.");
        String bride = scan.nextLine();
        bgList.add(bride);
        
        System.out.println("Please enter the nme of the groom.");
        String groom = scan.nextLine();
        bgList.add(groom);
        
        return bgList;
    }
    
    public static int getAttendance()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the total number of attendees in the wedding.");
        int attendance = scan.nextInt();
        
        return attendance;
    }
    
    public static double getSquareFootage()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Please enter the square footage of the location.");
        double sqft = scan.nextDouble();
        
        return sqft;
    }
    
    public static ArrayList<String> getAllNames()
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> namesList = new ArrayList<String>();
        
        System.out.println("Please enter the names of all the guests attending."
                + "\nEnter \'STOP\' when all the names have been entered.");
        String names = scan.nextLine();
        while(!names.equalsIgnoreCase("STOP"))
        {
            namesList.add(names);
            names = scan.nextLine();
        }
        return namesList;
    }
    
    public static double getAttendeesPerSqft(double sqft, int atten)
    {
       double sfpa = sqft/atten;
       sfpa = Math.round(sfpa*10.0)/10.0;
       System.out.println("There is approximately " +sfpa+" square feet per attendee.");
       
       return sfpa;
    }
    
    public static void outputInfo(ArrayList<String> bgNames, ArrayList<String> names, double sf, int atten, double sfpt)
    {
        try// Method creates a new file every time and imputs all the information. This is the correct format! Lines 99 - 138
        {
            PrintWriter write = new PrintWriter(new File ("src/Wedding.txt"));
            for(int i=0; i<bgNames.size();i++)
            {
                if(i==0)
                {
                    write.print("Bride: ");
                }
                else
                {
                    write.print("Groom: ");
                }
                write.println(bgNames.get(i));
            }
            
            write.println("\nAttendees: ");
            for(int j=0;j<names.size();j++)
            {
                write.println(names.get(j));
            }
            
            write.println("\nSquare footage of venue: ");
            write.println(sf);
            
            write.println("\nNumber of attendees: ");
            write.println(atten);
            
            write.println("\nSquare footage of venue per attendee: ");
            write.println(sfpt);
            
            write.close();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
    }
    
    public static void readFile()
    {
        try// Method reads the file. This is the correct format! Lines 140 - 157
        {
            File inputfile = new File("src/Wedding.txt");
            Scanner input = new Scanner(inputfile);
            
            while(input.hasNextLine())
            {
                String line = input.nextLine();
                System.out.println(line);
            }
        }
        catch(IOException f)
        {
            f.getMessage();
        }
    }

}
