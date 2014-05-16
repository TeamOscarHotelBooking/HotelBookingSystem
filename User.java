/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HBS;

/**
 *
 * @author zhangzy
 */
public interface User {
    
    //void setpassward(String passward);
    // The method is to set user's passward.
    
    void reserve(Location[] aol ,int id, String location, DatePair date);
    // The method is to generate a new reservation object based on the user's choice for rooms.
    // Add the reservation info into a list. 
    void cancel(int ID);
    // The method is to cancel a existed reservation, notated by ID.
    void showreservation();
    //The method is to check your reservation history.
    //Return the reservation information
    
}
