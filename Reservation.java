/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel;

/**
 *
 * @author gregoryelliott34
 */
public class Reservation {
    private Hotel [] arrayOfHotels;
    private numHotels;
    
    public Reservation(int numberOfHotels) {
        numHotels = numberOfHotels;
        for(int i = 0; i<numHotels; i++) {
            arrayOfHotels[i] = new Hotel();
        }
    }
    
    public Hotel[] Search(String location) {
        Hotel[] hotelsInLocation = new Hotel[numHotels];
        int numHotelsInLocations = 0;
        for (int i = 0; i<arrayOfHotels.length; i++) {
            if((arrayOfHotels[i].getLocation()).equals(location)) {
                hotelsInLocation[numHotelsInLocation] = arrayOfHotels[i];
            }
        }
        return hotelsInLocation;
    }
    
}
