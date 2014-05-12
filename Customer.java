/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HBS;
import java.util.ArrayList;
/**
 *
 * @author zhangzy
 *
 */
public class Customer implements User { 
   
    private String name;
    private String passward;
    private ArrayList<Reservation> reservation;
    private int creditcard;
    
    //default constructor
    public Customer(){
        this.name=null;
        this.passward="0123456789";
    }
    // constructor a customer using name
    public Customer(String name){
        this.name=name;
        this.passward="0123456789";
    }
    public void setpassward(String passward){
        this.passward=passward;
    }
    public String showname(){
        return this.name;
    }
    public void setcreditcard(int credit){
        this.creditcard=credit;   
    }
    @Override
    public void reserve(){
        Reservation res=new Reservation();
        /* setup the reservation based on the customer's choice.
        need more details in reservation class.
        */
        reservation.add(res); // add the new reservation to the list.
    }
    @Override
    // cancel a reservation  
    public void cancel(Reservation res){
        if (reservation.contains(res))
            reservation.remove(res);
        else 
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
