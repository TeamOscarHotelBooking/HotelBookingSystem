/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Team Oscar
 */
public class Hotel implements Serializable
{
    
    protected Room[][] Rooms;
    protected int floors;
    protected String HotelName;
    protected int NumberofRooms;
    protected int numSinglesperFloor;
    protected int numDoublesperFloor;
    protected int numSuitesperFloor;
    protected int NumberofRoomsSingle;
    protected int NumberofRoomsDouble;
    protected int NumberofRoomsSuites;
    protected double singlePrice;
    protected double doublePrice;
    protected double suitePrice;
    protected String location;
    protected int RoomsperFloor;
    
    /**
     * Hotel Constructor 
     * @param HotelName
     * @param NumberofRoomsSingle
     * @param NumberofRoomsDouble
     * @param NumberofRoomsSuites
     * @param NumberofRooms
     * @param doublePrice
     * @param suitePrice
     * @param singlePrice
     * @param location
     * @param floors
     * @param type
     * @param price 
     */
    
    public Hotel(String HotelName, int numSinglesperFloor, int numDoublesperFloor, int numSuitesperFloor, double singlePrice, double doublePrice, 
            double suitePrice, int floors, String location)
    {
        this.HotelName = HotelName;
        this.numSinglesperFloor = numSinglesperFloor;
        this.numDoublesperFloor = numDoublesperFloor;
        this.numSuitesperFloor = numSuitesperFloor;
        this.NumberofRoomsSingle = numSinglesperFloor * floors;
        this.NumberofRoomsDouble = numDoublesperFloor * floors;
        this.NumberofRoomsSuites = numSuitesperFloor * floors;
        this.singlePrice = singlePrice;
        this.doublePrice = doublePrice;
        this.suitePrice = suitePrice;
        this.floors = floors;
        this.location = location;
        this.RoomsperFloor = numSinglesperFloor + numDoublesperFloor + numSuitesperFloor;
        
        this.Rooms = new Room[floors][RoomsperFloor];
        
        
        for (int i = 1; i <= floors; i++)
        {
            for (int j = 1; j <= RoomsperFloor; j++)
            {
                if (j <= numSinglesperFloor)
                {
                   Rooms[i-1][j-1] = new Room(j, RoomType.SINGLE, singlePrice);
                }    
                else if (j > numSinglesperFloor && j <= (numSinglesperFloor + numDoublesperFloor))
                {
                    Rooms[i-1][j-1] = new Room(j, RoomType.DOUBLE, doublePrice);
                }
                else
                {
                    Rooms[i-1][j-1] = new Room(j, RoomType.JUNIORSUITE, suitePrice);
                }
                
            }
        }
        
        
    }
    
    public Hotel(String HotelName, int NumberofRooms, int floors, RoomType type, double price, String location)
    {
        
        this.HotelName = HotelName;
        int roomsPerFloor = NumberofRooms / floors;
        this.NumberofRooms = NumberofRooms;
        this.floors = floors;
        this.location = location;
        
        this.Rooms = new Room[floors][roomsPerFloor];
        
        for (int i = 1; i <= floors; i++)
        {
            for (int j = 1; j <= roomsPerFloor; j++)
            {
                Rooms[i-1][j-1] = new Room(j, type, price);
            }
        }
        
        
        
    }
    
    public Hotel(String HotelName, int NumberofRooms, int floors, String location)
    {
        System.out.println("Please input how many of the rooms you would like to be singles...");
        Scanner single = new Scanner(System.in);
        int numSingles = single.nextInt();
        
        System.out.println("Please input how many of the rooms you would like to be doubles...");
        Scanner doubles = new Scanner(System.in);
        int numDoubles = doubles.nextInt();
        
        int numJRSuites = NumberofRooms - numSingles - numDoubles;
        
        System.out.println("Please input the price of your singles...");
        Scanner price1 = new Scanner(System.in);
        int singlePrice = price1.nextInt();
        
        System.out.println("Please input the price of your doubles...");
        Scanner price2 = new Scanner(System.in);
        int doublePrice = price2.nextInt();
        
        System.out.println("Please input the price of your Junior Suites");
        Scanner price3 = new Scanner(System.in);
        int JRSuitePrice = price3.nextInt();
        
        this.HotelName = HotelName;
        this.NumberofRooms = NumberofRooms;
        this.floors = floors;
        int RoomsperFloor = (int) NumberofRooms / floors;
        this.location = location;
        
        this.Rooms = new Room[floors][RoomsperFloor];
        
        int roomCount = 0;
        
        for (int i = 1; i <= floors; i++)
        {
            for (int j = 1; j <= RoomsperFloor; j++)
            {
                if (roomCount < numSingles)
                {
                   Rooms[i-1][j-1] = new Room(j, RoomType.SINGLE, singlePrice);
                }    
                else if (roomCount >= numSingles && roomCount < (numSingles + numDoubles))
                {
                    Rooms[i-1][j-1] = new Room(j, RoomType.DOUBLE, doublePrice);
                }
                else
                {
                    Rooms[i-1][j-1] = new Room(j, RoomType.JUNIORSUITE, JRSuitePrice);
                }
                roomCount++;
            }
        }
    
    }
    
    public String getHotelName()
    {
        return this.HotelName;
    }
   
    
    public Room[][] getRooms()
    {
        return this.Rooms;
    }
 
    public Room getRoom(int floor, int roomNum)
    {
        return this.Rooms[floor-1][roomNum - 1];
    }
    
    public Room[] getFreeRooms(DatePair dp)
    {
        Room[] returnRoom = new Room[NumberofRooms];
        int count=0;
        for (int i = 0 ; i<this.floors;i++){
            for (int j = 0 ; j<this.RoomsperFloor; j++){
                if (this.Rooms[i][j].search(dp) == AVAILABLE){
                    returnRoom[count]=this.Rooms[i][j];
                    count++;
                }
            }
        }
    }

//    public Room getRoom(int roomNumber)
//    {
//        return this.Rooms[(roomNumber-(roomNumber%100)/100)][(roomNumber%100];
//    }
    
    /**
     * Sets a discount for all the rooms in the hotels
     * @param Discount 
     */
    public void setRoomDicount(Double Discount){
       
       for (int i = 0 ; i<this.floors;i++){
           for (int j = 0; j < this.RoomsperFloor; j++)
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
            for (int j = 0 ; j<this.RoomsperFloor; j++){
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
