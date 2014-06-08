/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author zhangzy
 *
*/

public class Customer implements User, Serializable { 
   
    private String name;
    private String password;
    private ArrayList<Reservation> reservation;
    private int creditcard;
    
    /**
     * default constructor.
    
    */
    public Customer(){
        this.name=null;
        this.password="0123456789";
    }
    /** 
       * constructor a customer using name
       * @param name the name of the customer
    */
    public Customer(String name){
        this.name=name;
        this.password="0123456789";
    }
    /**
	 * used in GUI
	 * @param name the name of the customer
	 * @param password the password of the customer
    */
    public Customer(String name, String password){
        this.name=name;
        this.password=password;
		this.reservation = new ArrayList<Reservation>();
    }
    /**
        * @param password the password of the customer
        * Set the password of the customer.
    */
    public void setpassword(String password){
        this.password=password;
    }
    /**
        * Get the password of the customer.
    */
    public String getpassword(){
        return this.password;
    }
    /**
       * get the username.
    */
    public String showname(){
        return this.name;
    }
    public void setcreditcard(int credit){
        this.creditcard=credit;   
    }
    @Override
    public void reserve(ArrayList<Location> aol,int id,String desiredlocation, DatePair date ){
        Reservation res=new Reservation(aol);
        res.confirmReservation(this.name, id, desiredlocation, date);
        reservation.add(res); // add the new reservation to the list.
    }
	
	/**
	 * the parallel reserve method used in GUI
	 * @param aol a list of locations
	 * @param id the reservation ID
	 * @param desiredlocation the name of the chosen location
	 * @param date the date range wanted to reserve
	 * @param hotelIndex the index of the chosen hotel
	 * @param roomTypeIndex the index of chosen roomType
	 * @param numRoomIndex they index of chosen number of rooms
	 */
	public void reserveGUI(ArrayList<Location> aol, int id, String desiredlocation, DatePair date,
			int hotelIndex, int roomTypeIndex, int numRoomIndex){
		
        Reservation res = new Reservation(aol, LocalDate.now());
        res.allInOne(this.name, id, desiredlocation, date, hotelIndex, roomTypeIndex, numRoomIndex);
        reservation.add(res); 
    }
    /**
     * Get the most recent reservation in the list.
             
    */  	
    public Reservation getMostRecentReservation(){
        int size=this.reservation.size();
        if(size>0)
            return this.reservation.get(size-1);
        else return null;
    }
    @Override
    /**
     * cancel a reservation.
     * @param id the id number of the reservation.
             
    */  
    public void cancel(int id){
      //  Reservation res = new Reservation();
        boolean state=true;
        for (int i=0; i<this.reservation.size();i++){
           if( reservation.get(i).getIDNumber()==id){
               reservation.get(i).cancelReservation();
               reservation.remove(i);
               state=false;
               break;
           }
        }
        if(state==true)
            System.out.println("Can't find the reservation!");
    }
    @Override
    /**
        * A toString method of the reservation list of the customer.
    */
    public void showreservation(){
       int size=reservation.size();
       String output="All the reservation info:";
       for (int i=0; i<size; i++){
           output=output+reservation.get(i).toString(); // need a toString method in reservation class.
       }
       System.out.println(output);
    }
    
	/**
	 * used in GUI
	 * @return a list of all reservation of this customer
	 */
    public ArrayList<Reservation> getReservationList() {
		return this.reservation;
	}
}

