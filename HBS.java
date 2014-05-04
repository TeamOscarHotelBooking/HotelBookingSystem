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
                                                                 // a room price of 100
       NU.setRoomDicount(13, 0.7);  // set a discout of 70% on room 13
       System.out.println(NU.Rooms[13].getPrice());     // check the price of room 13 to see the discount
       System.out.println(NU.Rooms[10].getPrice());     // check the price of a random room to compare
        
        
    }
    
}
