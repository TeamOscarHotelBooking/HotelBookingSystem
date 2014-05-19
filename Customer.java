/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HBS;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author zhangzy
 *
 */
/*
I have some suggestions about the reservation class based on my implements of the customer class:
IsEqual();             compare the this reservation ID to a given ID, see if it is the reservation we want to get.
Room[] searchForRoom(hotel, datepair);      return all the rooms which is available during datepairin this hotel.
confirmreservation(Hotel, datepair);{
    random generate a reservation ID;
    set all of the reservation info;
    push it into the reservation arraylist.
}
toString();     
*/
public class Customer implements User { 
   
    private String name;
    private String password;
    private ArrayList<Reservation> reservation;
    private int creditcard;
    
    //default constructor
    public Customer(){
        this.name=null;
        this.password="0123456789";
    }
    // constructor a customer using name
    public Customer(String name){
        this.name=name;
        this.password="0123456789";
    }
    public void setpassword(String password){
        this.password=password;
    }
    public String getpassword(){
        return this.password;
    }
    public String showname(){
        return this.name;
    }
    public void setcreditcard(int credit){
        this.creditcard=credit;   
    }
    @Override
    public void reserve(Location[] aol,int id,String desiredlocation, DatePair date ){
        Reservation res=new Reservation(aol);
        Scanner keyboard = new Scanner(System.in);
        res.confirmReservation( this.name, id , desiredlocation, date);
        /* setup the reservation based on the customer's choice.
        need more details in reservation class.
        */
        reservation.add(res); // add the new reservation to the list.
    }
    
    @Override
    // cancel a reservation  
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
    public void showreservation(){
       int size=reservation.size();
       String output="All the reservation info:";
       for (int i=0; i<size; i++){
           output=output+reservation.get(i).toString(); // need a toString method in reservation class.
       }
       System.out.println(output);
    }
    
    
}
