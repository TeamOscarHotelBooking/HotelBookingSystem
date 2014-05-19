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
 
 import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Room implements Serializable{
    
    protected int number;
    protected RoomType type;
    protected double price;
    protected DateStruct Date;
    
    /**
     * Default Constructor
     * Numbers are random currently to ease the process for other methods in the project
     */
    public Room(){
		this.number = 1;
		this.type = RoomType.SINGLE;
		this.price = 100;
		this.Date =  new DateStruct();
    }
    
    public Room (int number, RoomType type, double price){
		// no Date parameter, since we always want to start with no reservation
		this.number = number;
		this.type = type;
		this.price = price;
		this.Date =  new DateStruct();
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
	
	public void printDates() {
		System.out.println(this.Date.toString());
	}
	
	/**
	 * 
	 * @param dp
	 * @return 
	 */ 
	public RoomState search(DatePair dp) {
		return Date.search(dp);
	}
	
	/**
	 * return 0 for success, return -1 for failure
	 * @param dp 
	 */
	public int cancel(DatePair dp) {
		return Date.cancel(dp);
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
		try {
			DatePair dp3 = new DatePair(LocalDate.of(2015, Month.JULY, 16), LocalDate.of(2013, Month.JULY, 10));
		} catch (UnsupportedOperationException e) {
			System.out.println("exception: invalid DatePair construction");
		}
		
		//insert before today
		try {
			DatePair dp3 = new DatePair(LocalDate.of(2013, Month.JUNE, 3), LocalDate.of(2013, Month.JULY, 10));
			rm.insert(dp3);
		} catch (UnsupportedOperationException e) {
			System.out.println("exception: insert before today");
		}
		
		//overlap case 1
		try {
			DatePair dp3 = new DatePair(LocalDate.of(2015, Month.MAY, 3), LocalDate.of(2015, Month.MAY, 7));
			rm.insert(dp3);
		} catch (UnsupportedOperationException e) {
			System.out.println("exception: overlap case 1");
		}
		
		//overlap case 2
		try {
			DatePair dp3 = new DatePair(LocalDate.of(2015, Month.MAY, 20), LocalDate.of(2015, Month.MAY, 27));
			rm.insert(dp3);
		} catch (UnsupportedOperationException e) {
			System.out.println("exception: overlap case 2");
		}
	}
}
