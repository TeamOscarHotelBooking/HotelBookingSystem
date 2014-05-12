/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

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
    
    public Reservation(Location[] aol, String name, int id) {
        arrayOfLocations = aol;
        user = name;
        idNumber = id;
    }
    
    public void SearchForLocation(String desiredLocation) {
        for(int i=0; i<arrayOfLocations.length; i++) {
            if((arrayOfLocations[i]).getCity() == desiredLocation) {
                location = arrayOfLocations[i];
            }
        }
        String hotelOptions = "The following hotels are located in " + location.getCity() + ": " + hotelsInLocation[0];
        Hotel[] hotelsInLocation = location.getCityHotelDataBase();
        for (int i = 1; i<hotelsInLocation.length; i++) {
            hotelOptions = hotelOptions + ", " + hotelsInLocation.getName() ;
        }
        System.out.println(hotelOptions);
        System.out.println("Which Hotel do you want to reserve?");
        hotelName = userInput;
        targetHotel = targetLocation.SearchForHotel(hotelName);
        freeRoom = targetHotel.getFreeRoom();
        freeRoom.setState("booked");
    }
}
