/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hbs;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Team Oscar
 */
public class Room implements Serializable{
    
    private int number;
    private RoomType type;
    private double price;
    private DateStruct Date;
	private int floorNum;

	/**
	 * Default constructor of Room
	 * @param number room number
	 * @param type room type
	 * @param price room price
	 * @param floorNum floor number
	 */
    public Room (int number, RoomType type, double price, int floorNum){
		// no Date parameter, since we always want to start with no reservation
		this.number = number;
		this.type = type;
		this.price = price;
		this.Date =  new DateStruct();
		this.floorNum = floorNum;
    }
    
    /**
     * Room Type Transformer
     * @param type the type you want to set to
     */
    public void setType(RoomType type){
        this.type = type;
    }
    
    /** 
     * Room Price Transformer
     * @param price the price you want to set to
     */
    public void setPrice(double price){
        this.price = price;
    }
    
    
    /**
     * room type getter
     * @return the room type
     */
    public RoomType getType(){
        return this.type;
    }
    
    /**
     * room number getter
     * @return the room number
     */
	public int getNumber() {
		return this.number;
	}
	/**
	 * floor number getter
	 * @return floor number of this room
	 */
	public int getFloorNumber() {
		return this.floorNum;
	}
			
    /**
     * Room Price Observer
     * @return price of the room
     */
    public double getPrice(){
       return this.price;
    }
    
    /**
     * Function to make a discount on a room (in case of a special offer)
     * Will change the original price to new discounted one
     * @param DiscountPercentage the percentage discount rate
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
	 * output the Dates
	 */
	public void printDates() {
		System.out.println(this.Date.toString());
	}
	
	/**
	 * search whether the DatePair is booked
	 * @param dp DatePair u want to search
	 * @return RoomState of the DatePair
	 */ 
	public RoomState search(DatePair dp) {
		return Date.search(dp);
	}
	
	/**
	 * cancel the DatePair if booked
	 * return 0 for success, return -1 for failure
	 * @param dp DatePair u want to cancel
	 */
	public int cancel(DatePair dp) {
		return Date.cancel(dp);
	}
	
	/**
	 * insert the DatePair u wanted to book
	 * @param dp DatePair u want to insert
	 */
	public void insert(DatePair dp) {
		this.Date.insert(dp);
		//System.out.println(this.Date.toString());
	}
}