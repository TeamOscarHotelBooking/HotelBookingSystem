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
       GregorianCalendar g1=new GregorianCalendar();    // creat a new calendar
       Date d2 = new Date(114,4,8);                     // creat the start booking date
       g1.setTime(d2);
       Room room1 = new Room();
       int nights=5;                                // how many nights does the customer want to book.
       room1.bookroom(g1, nights);                  // check bookroom method can change the state.
       System.out.println(room1.isEmpty(g1, nights));   // check IsEmpty method can return false means is not availble
       System.out.println(room1.getState()); 
        
    }
    
}
