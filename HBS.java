/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

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
		ArrayList<Reservation> reservationDatabase= new ArrayList<Reservation>();
		database.add(loc1);
		database.add(loc2);
		
                //Reservation res = new Reservation(database);
                System.out.println("Enter your name");
                Scanner keyboard = new Scanner(System.in);
                String userName = keyboard.nextLine();
                Customer cus = new Customer(userName);
                cus.setpassword("000");
                        
                String quit = "";
                while(!(quit.equals("quit"))) {
                    System.out.println("Choose Chicago or Evanston");
                    String userLoc = keyboard.nextLine();
                    DatePair dp1 = new DatePair(LocalDate.of(2015, Month.MAY, 6), LocalDate.of(2015, Month.MAY, 25));
                    cus.reserve(database, 11, userLoc, dp1);
                    cus.showreservation();
                    System.out.println("Do you want to cancel a reservation?");
                    String cancelRes = keyboard.nextLine();
                    if(cancelRes.equals("yes")) {
                        System.out.println("Enter the id number of the reservation you want to cancel or type 'no'");
                    
                        int identification = keyboard.nextInt();
                        cus.cancel(identification);
                    }
                    System.out.println("Enter 'quit' to quit");
                    quit = keyboard.nextLine();
                }
		//res.Search("Chicago", );

		/*DatePair dp1 = new DatePair(LocalDate.of(2015, Month.MAY, 6), LocalDate.of(2015, Month.MAY, 25));
		res.Search("Chicago", dp1);
                res.ChooseRooms(dp1);
                System.out.print(h2.getRoom(1, 1).search(dp1)+"\n");
                Customer c1 = new Customer("Nu");
                c1.setpassword("0000000");
                System.out.println("Enter your password:");
                Scanner keyboard = new Scanner(System.in);
                if (keyboard.nextLine().equals(c1.getpassword())){
                    c1.reserve(database, 0000001, "Chicago", dp1);
                    reservationDatabase.add(c1.getMostRecentReservation());
                }
                c1.showreservation();
                c1.cancel(0000001);
                c1.showreservation();	*/	
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
