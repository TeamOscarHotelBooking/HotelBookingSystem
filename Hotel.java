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
public class Hotel {
    
    protected Room[] Rooms;
    protected int floors;
    protected String HotelName;
    protected int NumberofRooms;
    
    /**
     * Hotel Constructor 
     * @param HotelName
     * @param NumberofRooms
     * @param floors
     * @param type
     * @param price 
     */
    public Hotel(String HotelName, int NumberofRooms, int floors, RoomType type, double price){
        
        this.Rooms = new Room[NumberofRooms];
        for (int i = 0 ; i<NumberofRooms;i++){  // Temporary loop to intialze the rooms using the deault Room Constructor
            this.Rooms[i] = new Room();
        }
        this.NumberofRooms = NumberofRooms;
        this.HotelName = HotelName;
        this.floors = floors;
        
        
    }
    
    /**
     * A method to set a discount for a specific room in the hotel 
     * @param RoomNumber
     * @param Dicount 
     */
    
    public void setRoomDicount(int RoomNumber,Double Dicount){
       this.Rooms[RoomNumber].DiscountPrice(Dicount);
    }
    
}
