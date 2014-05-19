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
import java.util.GregorianCalendar;
import java.util.Calendar;

public class HBS {

    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) {
     
       Location[] arrayOfLocations = new Location[10]; 
       ArrayList<Customer> customerList = new ArrayList<Customer>;
       
       Hotel NU = new Hotel( "NU", 30, 3, RoomType.SINGLE, 100); // this will set a hotel "NU" with 30 rooms, 3 floors and
       Hotel Hilton = new Hotel( "Hilton", 30, 3, RoomType.SINGLE, 100);
                                                                 // a room price of 100
       NU.setRoomDicount(1,10, 0.7);  // set a discout of 70% on room 10 of floor 1
       System.out.println(NU.Rooms[0][9].getPrice());     // check the price of room 13 to see the discount
       System.out.println(NU.Rooms[0][8].getPrice());     // check the price of a random room to compare
       System.out.println(NU.Rooms[0][7].getType());
       
       
       Location Chicago = new Location("Chicago");
       Chicago.AddHoteltoDataBase(NU);
       Chicago.AddHoteltoDataBase(Hilton);
       
       Hotel test = Chicago.SearchForHotel(Hilton);
       System.out.println(test.HotelName);
        
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
