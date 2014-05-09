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
    
}
