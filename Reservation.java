
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HBS;
import java.util.Scanner;
//import java.io.Serializable;
//import java.lang.Object;
import java.util.ArrayList;

/**
 *
 * @author gregoryelliott34
 */
public class Reservation {
    private String user;
    private Hotel chosenHotel;
    private int idNumber;
    private Room[] chosenRoom;
    private Location location;
    private Location[] arrayOfLocations;  // Why put it in the reservation class. It can be a public database.
    private Boolean isCancelled;    // 
    private double TotalCost;
    private DatePair chosenDate;
    // better to generate an ID by system
    
    public Reservation(Location[] aol) {
        arrayOfLocations = aol;
        user = null;
        idNumber = 0;
        TotalCost=0;
        isCancelled = false;
        chosenDate=null;
        
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
            hotelOptions = hotelOptions + ", " + (hotelsInLocation.get(0)).getHotelName() ;
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
    }
    
    public void SearchForDate(Hotel hotel, DatePair date){
        chosenDate=date;
        Room[] rooms = hotel.getFreeRoom(date);
        String roomOptions = "The following rooms are available : " + rooms[0].toString();
        for (int i = 1; i<rooms.length; i++) {
            roomOptions = roomOptions + ", " + rooms[i].toString() ;
        }
        System.out.println(roomOptions);
        System.out.println("Which room do you want to reserve?");
        Scanner keyboard = new Scanner(System.in);
        int j=0;
        while (keyboard.hasNextInt()){
            int roomNumber;
            roomNumber = keyboard.nextInt();
            for (int i = 1; i<rooms.length; i++) {
                if(rooms[i].getNumber()==roomNumber){
                    chosenRoom[j] = rooms[i];
                    j++;
                }
            }
        }
        for(int i=0; i<j; i++)
            chosenRoom[i].insert(chosenDate);
    }
    
    public void CalculateCost(Room[] rooms){
        for(int i=0; i<rooms.length; i++){
            TotalCost=TotalCost+rooms[i].getPrice();
        }
    }
    
    public void confirmReservation(String name, int ID, String desiredLocation, DatePair date){
        user=name;
        idNumber=ID;
        this.SearchForLocation(desiredLocation);
        this.SearchForDate(chosenHotel, date);
        this.CalculateCost(chosenRoom);
        // Add the confiremed reservation to the arraylist of reservation generated in Main function
    }
    
    public void cancelReservation() {
        isCancelled = false;
        for(int i=0; i<chosenRoom.length; i++)
            chosenRoom[i].cancel(this.chosendate);
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
    
    public Room[] getChosenRoom() {
        return chosenRoom;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public Boolean getIsCancelled() {
        return isCancelled;
    }
}
