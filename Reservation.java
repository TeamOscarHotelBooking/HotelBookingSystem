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
    
    public Reservation() {
    }
    
    public void Search(String desiredLocation, String hotelName) {
        Location targetLocation;
        Hotel targetHotel;
        Room freeRoom;
        for(int i=0; i<arrayOfLocations.length; i++) {
            if((arrayOfLocations[i]).getCity() == desiredLocation) {
                targetLocation = arrayOfLocations[i];
            }
        }
        /*Hotel[] hotelsInLocation = new Hotel[numHotels];
        int numHotelsInLocations = 0;
        for (int i = 0; i<arrayOfHotels.length; i++) {
            if((arrayOfHotels[i].getLocation()).equals(location)) {
                hotelsInLocation[numHotelsInLocation] = arrayOfHotels[i];
            }
        }
        return hotelsInLocation;*/
        targetHotel = targetLocation.SearchForHotel(hotelName);
        freeRoom = targetHotel.getFreeRoom();
        freeRoom.setState("booked");
    }
    
}
