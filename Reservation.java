/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;
import java.util.Scanner;
import java.io.Serializable;
import java.lang.Object;
import java.util.ArrayList;

/**
 *
 * @author gregoryelliott34
 */
public class Reservation {
    private String user;
    private Hotel chosenHotel;
    private int idNumber;
    private Room chosenRoom;
    private Location location;
    private Location[] arrayOfLocations;
    private Boolean isCancelled;
    
    public Reservation(Location[] aol, String name, int id, String desiredLocation) {
        arrayOfLocations = aol;
        SearchForLocation(desiredLocation);
        user = name;
        idNumber = id;
        isCancelled = false;
    }
    
    public void SearchForLocation(String desiredLocation) {
        for(int i=0; i<arrayOfLocations.length; i++) {
            if((arrayOfLocations[i]).getCity() == desiredLocation) {
                location = arrayOfLocations[i];
            }
        }
        ArrayList<Hotel> hotelsInLocation = location.getCityHotelDataBase();
        String hotelOptions = "The following hotels are located in " + location.getCity() + ": " + hotelsInLocation.get(0);
        for (int i = 1; i<hotelsInLocation.size(); i++) {
            hotelOptions = hotelOptions + ", " + (hotelsInLocation.get(0)).getName() ;
        }
        System.out.println(hotelOptions);
        System.out.println("Which Hotel do you want to reserve?");
        Scanner keyboard = new Scanner(System.in);
        String hotelName;
        hotelName = keyboard.nextLine();
        for (int i = 1; i<hotelsInLocation.size(); i++) {
            if(((hotelsInLocation.get(i)).getHotelName()).equals(hotelName))
                chosenHotel = hotelsInLocation.get(i); 
        }
        //chosenHotel = location.SearchForHotel(hotelName);
        chosenRoom = chosenHotel.getFreeRoom();
        chosenRoom.setState(BOOKED);
        return;
    }
    
    public void cancelReservation() {
        isCancelled = false;
        chosenRoom.setState(AVAILABLE)l
    }
    
    public String getUser() {
        return user;
    }
    
    public Hotel getChosenHotel() {
        return chosenHotel;
    }
    
    public int getIDNumber() {
        return idNumber;
    }
    
    public Room getChosenRoom() {
        return chosenRoom;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public Boolean getIsCancelled() {
        return isCancelled;
    }
}