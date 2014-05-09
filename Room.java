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
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Room {
    
    protected int number;
    protected RoomType type ;
    protected double price;
    protected Calendar Date;
    protected RoomState[] state;
    
    /**
     * Default Constructor
     * Numbers are random currently to ease the process for other methods in the project
     */
    public Room(){
    this.number = 1;
    this.type = RoomType.SINGLE;
    this.price = 100;
    this.Date =  new GregorianCalendar();
    this.state = new RoomState[60];
    for (int i=0; i<60; i++){
        this.state[i]=RoomState.AVAILABLE;
    }       
    }
    
    public Room (int number,RoomType type,double price){
    this.number = number;
    this.type = type;
    this.price = price;
    this.Date =  new GregorianCalendar();
    this.state = new RoomState[60];
    for (int i=0; i<60; i++){
        this.state[i]=RoomState.AVAILABLE;
    }
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
    public String getState(){
        String s="the state of this room:";
        for (int i=0; i<60; i++){
            s=s+" "+this.state[i];
        }
        return s;
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
    public boolean isEmpty(GregorianCalendar g1,int nights){
        Date nowdate = new Date();
        GregorianCalendar g2= new GregorianCalendar();
        g2.setTime(nowdate);
        date d=new date();
        int interval=d.daysInterval(g1, g2);
        if((interval+nights)<60){
            for (int i=interval; i<=(interval+nights); i++){
                if (this.state[i] == RoomState.BOOKED){
                    return false;
                }
            }
         }
        else System.out.println("Error: overflow.");
        return true;
    }
    
    public void bookroom(GregorianCalendar g1,int nights)
  {
        Date nowdate = new Date();
        GregorianCalendar g2= new GregorianCalendar();
        g2.setTime(nowdate);
        date d=new date();
        int interval=d.daysInterval(g1, g2);
        if((interval+nights)<60){
            for (int i=interval; i<=(interval+nights); i++)
            {
                this.state[i]=RoomState.BOOKED;
            }
        }
        else System.out.println("Error: overflow.");
  }

    
    
    
    
}
