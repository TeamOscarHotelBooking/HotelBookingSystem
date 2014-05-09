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
    
    
    protected Room[][] Rooms;
    protected int floors;
    protected String HotelName;
    protected int NumberofRooms;
    protected int RoomsPerFloor;
    
    /**
     * Hotel Constructor 
     * @param HotelName
     * @param NumberofRooms
     * @param floors
     * @param type
     * @param price 
     */
    public Hotel(String HotelName, int NumberofRooms, int floors, RoomType type, double price)
    {
        
        this.HotelName = HotelName;
        this.RoomsPerFloor = NumberofRooms / floors;
        this.NumberofRooms = NumberofRooms;
        this.floors = floors;
        
        this.Rooms = new Room[this.floors][this.RoomsPerFloor];
        
        for (int i = 0; i < floors; i++)
        {
            for (int j = 0; j < RoomsPerFloor; j++)
            {
                //Rooms[i][j] = new Room(j, type, price);
            }
        }
        
        
        
    }
    
    /**
     * Sets a discount for all the rooms in the hotels
     * @param Discount 
     */
    public void setRoomDicount(Double Discount){
       
       for (int i = 0 ; i<this.floors;i++){
           for (int j = 0; j < this.RoomsPerFloor; j++)
            {
                this.Rooms[i][j].DiscountPrice(Discount);
            }
          
       }
    }
    
    /**
     * A method to set a discount for a specific room in the hotel using the room number 
     * @param RoomNumber
     * @param Dicount 
     */
    
    public void setRoomDicount(int FloorNumber, int RoomNumber,Double Discount){
       this.Rooms[FloorNumber-1][RoomNumber-1].DiscountPrice(Discount);     // -1 because of zero indexing
    }
    
    /**
     * A method to set a discount for all rooms within a hotel of a specific type
     * @param type
     * @param Discount 
     */
    public void setRoomDicount( RoomType type, Double Discount){
        for (int i = 0 ; i<this.floors;i++){
            for (int j = 0 ; j<this.RoomsPerFloor; j++){
                if (this.Rooms[i][j].type == type){
                    this.Rooms[i][j].DiscountPrice(Discount);
                }
            }
        }
    }
    
    
    /**
     * A method to set a discount on a range of rooms within in specific floors
     * where the user specify the type of rooms to set a discount on
     * @param type
     * @param SartingFloorRange
     * @param EndingFloorRange
     * @param StartingRoomRange
     * @param EndingRoomRange
     * @param Discount 
     */
    
    public void setRoomDiscount(RoomType type, int SartingFloorRange, int EndingFloorRange, int StartingRoomRange,
            int EndingRoomRange, double Discount){
        
        for (int i=SartingFloorRange ; i<=EndingFloorRange;i++){
            for (int j=StartingRoomRange ; j<=EndingRoomRange;j++){
                if (this.Rooms[i-1][j-1].type == type){
                    this.Rooms[i-1][j-1].DiscountPrice(Discount);
                }
            }
        }
    }
    
}
