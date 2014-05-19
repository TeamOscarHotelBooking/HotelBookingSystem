
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;
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
    private ArrayList<Location> arrayOfLocations;  // Why put it in the reservation class. It can be a public database.
    private Boolean isCancelled;    // 
    private double TotalCost;
    private DatePair chosenDate;
    // better to generate an ID by system
    
    public Reservation(ArrayList<Location> aol) {
        arrayOfLocations = aol;
        user = null;
        idNumber = 0;
        TotalCost=0;
        isCancelled = false;
        
    }
    
    
    
    public void Search(String desiredLocation, DatePair date) {
        for(int i=0; i<arrayOfLocations.size(); i++) {
            if((arrayOfLocations.get(i).getCity()).equals(desiredLocation)) {
                location = arrayOfLocations.get(i);
            }
        }
        ArrayList<Hotel> hotelsInLocation = location.getCityHotelDataBase();
        String hotelOptions = "The following hotels are located in " + location.getCity() + ": " + hotelsInLocation.get(0).getHotelName();
        for (int i = 1; i<hotelsInLocation.size(); i++) {
            hotelOptions = hotelOptions + ", " + (hotelsInLocation.get(i)).getHotelName() ;
        }
        System.out.println(hotelOptions);
	
	
	
	
	
	
	
	/*
        System.out.println("Which Hotel do you want to reserve?");
        Scanner keyboard = new Scanner(System.in);
        String hotelName;
        hotelName = keyboard.nextLine();
        for (int i = 0; i<hotelsInLocation.size(); i++) {
            if(((hotelsInLocation.get(i)).getHotelName()).equals(hotelName))
                chosenHotel = hotelsInLocation.get(i); 
        }
	
    
        
	
	chosenDate = date;
	chosenHotel.getHotelName();
	ArrayList<Room> SingleRooms = chosenHotel.getFreeRooms(date, RoomType.SINGLE);
	ArrayList<Room> DoubleRooms = chosenHotel.getFreeRooms(date, RoomType.DOUBLE);
	ArrayList<Room> JSRooms = chosenHotel.getFreeRooms(date, RoomType.JUNIORSUITE);
	*/
	
        //Room[] rooms = chosenHotel.getFreeRooms(date);
		/*
        String roomOptions = "The following rooms are available : " + rooms[0].toString();
        for (int i = 1; i<rooms.length; i++) {
            roomOptions = roomOptions + ", " + rooms[i].toString() ;
        }
        System.out.println(roomOptions);
        System.out.println("Enter the room numbers for each room you want to reserve seperated by commas:");
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
				*/
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
        this.SearchForDate(date);
        this.CalculateCost(chosenRoom);
        // Add the confiremed reservation to the arraylist of reservation generated in Main function
    }
    
    public void cancelReservation() {
        isCancelled = false;
        for(int i=0; i<chosenRoom.length; i++)
            chosenRoom[i].cancel(this.chosenDate);
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
