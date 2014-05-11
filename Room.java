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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Room {
    
    protected int number;
    protected RoomType type;
    protected double price;
    protected DateStruct Date;
    protected RoomState state;
    
    /**
     * Default Constructor
     * Numbers are random currently to ease the process for other methods in the project
     */
    public Room(){
		this.number = 1;
		this.type = RoomType.SINGLE;
		this.price = 100;
		this.Date =  new DateStruct();
		this.state = RoomState.AVAILABLE;
    }
    
    public Room (int number, RoomType type, double price){
		// no Date parameter, since we always want to start with no reservation
		this.number = number;
		this.type = type;
		this.price = price;
		this.Date =  new DateStruct();
		this.state = RoomState.AVAILABLE;
    }
    
    /**
     * Room Type Transformer
     * @param type 
     */
    public void setType(RoomType type){
        this.type = type;
    }
    
    /** 
     * Room Price Transformer
     * @param price 
     */
    public void setPrice(double price){
        this.price = price;
    }
    
    /**
     * Room State Transformer
     * @param state 
     */
    public void setState(RoomState state){
        this.state = state;
    }
    
    /**
     * Room Type observer
     * @return type
     */
    public RoomType getType(){
        return this.type;
    }
    
    /**
     * Room Price Observer
     * @return price
     */
    public double getPrice(){
       return this.price;
    }
    
    /**
     * Room State observer
     * @return state
     */
    public RoomState getState(){
        return this.state;
    }
    
    /**
     * Function to make a discount on a room (in case of a special offer)
     * Will change the original price to new discounted one
     * @param DiscountPercentage 
     */
    public void DiscountPrice(double DiscountPercentage){
        if (DiscountPercentage <1 && DiscountPercentage > 0){
			this.price = (1-DiscountPercentage)*this.price;
        }
        else {
            System.out.println("Non authorized Discount");
        }
    }
    
    /**
     * Function to check if the room is booked or not 
     * @return true if the room is available
     */
    public boolean isEmpty(){
        if (this.state == RoomState.BOOKED){
            return false;
        }
        return true;
    }
	
	public void printDates() {
		System.out.println(this.Date.toString());
	}
	
	public void insert(DatePair dp) {
		this.Date.insert(dp);
		//System.out.println(this.Date.toString());
	}
	
	public static void main (String [] args) {
		Room rm = new Room(204, RoomType.DOUBLE, 125.99);
		DatePair dp1 = new DatePair(LocalDate.of(2015, Month.MAY, 6), LocalDate.of(2015, Month.MAY, 25));
		DatePair dp2 = new DatePair(LocalDate.of(2015, Month.JUNE, 3), LocalDate.of(2015, Month.JULY, 10));
		rm.insert(dp1);
		rm.insert(dp2);
		rm.printDates();
		
		//test-cases
		//invalid DatePair construction
		//DatePair dp3 = new DatePair(LocalDate.of(2013, Month.JULY, 16), LocalDate.of(2013, Month.JULY, 10));
		
		//insert before today
		/*
		DatePair dp3 = new DatePair(LocalDate.of(2013, Month.JUNE, 3), LocalDate.of(2013, Month.JULY, 10));
		rm.insert(dp3);
		*/
		
		//overlap case 1
		/*
		DatePair dp3 = new DatePair(LocalDate.of(2015, Month.MAY, 3), LocalDate.of(2015, Month.MAY, 7));
		rm.insert(dp3);
		*/
		
		//overlap case 2
		/*
		DatePair dp3 = new DatePair(LocalDate.of(2015, Month.MAY, 20), LocalDate.of(2015, Month.MAY, 27));
		rm.insert(dp3);
		*/
		
		
	}
}







/*

 
public class Room {
	
	private int price;
	private int floorNum;
	private String roomNumber;
	int roomType; // could be Enum
	private Hotel hotel_ref;
	//boolean[] state;
	//details[];
	
	//c'tors
	public Room() {
		price = -1;
		floorNum = 0;
		roomNumber = "";
		hotel_ref = null;
	}
	public Room(int price, int floorNum, String roomNumber, int roomType, Hotel hotel_ref) {
		this.price = price;
		this.floorNum = floorNum;
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.hotel_ref = hotel_ref;
	}
	//changeState();
	public int getPrice() {
		return price;
	}
	public int getFloorNum() {
		return floorNum;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public int getType() {
		return roomType;
	}
	public String toString() {
		return	"Room: " + roomNumber + "\n" +
				"Type: " + roomType + "\n" +
				"Floor#: " + floorNum + "\n" +
				"Price: " + price + "\n" +
				"Belongs to: " + hotel_ref.toString() + "\n";
	}
	//showDetails();
	public Hotel showBelong() {
		return hotel_ref;
	}
}
*/