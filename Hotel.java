/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;
import java.util.Scanner;

/**
 *
 * @author Team Oscar
 */
public class Hotel 
{
    
    protected Room[][] Rooms;
    protected int floors;
    protected String HotelName;
    protected int NumberofRooms;
    protected String location;
    
    /**
     * Hotel Constructor 
     * @param HotelName
     * @param NumberofRooms
     * @param floors
     * @param type
     * @param price 
     */
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
    
    public Room[][] getRooms()
    {
        return this.Rooms;
    }
    
       
        
    
    
    /**
     * A method to set a discount for a specific room in the hotel 
     * @param RoomNumber
     * @param Dicount 
     */
    
//    public void setRoomDicount(int RoomNumber,Double Dicount){
//       this.Rooms[RoomNumber].DiscountPrice(Dicount);
//    }
    
}
