/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HBS;

/**
 *
 * @author Team Oscar
 */
import java.io.*;
import java.text.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HBS {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
		
		Hotel h1 = new Hotel("h1", 10, 20, 30, 100, 200, 300, 3, "Chicago");
		Hotel h2 = new Hotel("h2", 10, 20, 30, 100, 200, 300, 3, "Chicago");
		Hotel h3 = new Hotel("h3", 10, 20, 30, 100, 200, 300, 3, "Evanston");
		Hotel h4 = new Hotel("h4", 10, 20, 30, 100, 200, 300, 3, "Evanston");
		Location loc1 = new Location("Chicago");
		Location loc2 = new Location("Evanston");
		loc1.AddHoteltoDataBase(h1);
		loc1.AddHoteltoDataBase(h2);
		loc2.AddHoteltoDataBase(h3);
		loc2.AddHoteltoDataBase(h4);
		ArrayList<Location> database = new ArrayList<Location>();
		database.add(loc1);
		database.add(loc2);
		Reservation res = new Reservation(database);
		//res.Search("Chicago", );
		
		DatePair dp1 = new DatePair(LocalDate.of(2015, Month.MAY, 6), LocalDate.of(2015, Month.MAY, 25));
		res.Search("Chicago", dp1);
                res.ChooseRooms(dp1);
                System.out.print(h2.getRoom(1, 1).search(dp1));
		/*System.out.println("Are you a new customer?");
       Scanner keyboard = new Scanner(System.in);
       if(keyboard.nextLine()=="Yes"){
           System.out.println("Please enter your name:");
           keyboard = new Scanner(System.in);
           String Nustudent = keyboard.nextLine();
           Customer customer = new Customer(Nustudent);
       }
       else()
       */		
    }
    
    /**
     * Method to write the Data Base to a file
     * @param FileName
     * @param DataBase 
     * @author Naif Almakhdhub
     */
    public static  void writeDataBase(String FileName, ArrayList<Location> DataBase){
        
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(DataBase);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Method to read the Data Base of from the file
     * @param FileName
     * @return Data Base
     * @author Naif Almakhdhub
     */
    public static ArrayList<Location> readDataBase(String FileName){
         ArrayList<Location> DataBase =null;
        try {
            ObjectInputStream input = new ObjectInputStream (new FileInputStream(FileName));
            DataBase = (ArrayList<Location>) input.readObject();
            input.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DataBase;
    }
	
}
