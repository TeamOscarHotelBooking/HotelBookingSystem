
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
    private ArrayList<Room> chosenRoom;
    private Location location;
    private ArrayList<Location> arrayOfLocations;  // Why put it in the reservation class. It can be a public database.
    private Boolean isCancelled;    // 
    private double TotalCost;
    private DatePair chosenDate;
    // better to generate an ID by system
    
    /*constructor for Reservation class. Initialize all values at 0 or null and assign values to them later by calling the confirmReservation method
    */
    public Reservation(ArrayList<Location> aol) {
        arrayOfLocations = aol;
        user = null;
        idNumber = 0;
        TotalCost=0;
        isCancelled = false;
        chosenHotel = null;
        chosenRoom = new ArrayList<Room>();
        
    }
    
    /*take datepair and desired location as inputs from user and set the chosenHotel instance variable
    by prompting the user to select a hotel from a list of the free hotels in the inputted location
    */
    public void Search(String desiredLocation, DatePair date) {
        /*search through array of locations and set the location instance variable to the location that the user inputted
        */
        for(int i=0; i<arrayOfLocations.size(); i++) {
            if((arrayOfLocations.get(i).getCity()).equals(desiredLocation)) {
                location = arrayOfLocations.get(i);
            }
        }
        /*check if user inputted the correct location
        */
        if(location==null) {
            System.out.println("The user did not input a valid location");
            return;
        }
        /*print available rooms and corresponding prices for each hotel in the location
        */
        System.out.println( "\t\t"+location.getCity());
        System.out.print("Choice Number\tHotel Name\t Number of Single Rooms \t Single Room Price");
        System.out.print("\tNumber of Double Rooms \t Double Room Price");
        System.out.print("\t Number of JS Rooms \t JS Room Price\n");
        for(int i=0; i<location.getCityHotelDataBase().size();i++){
            location.getCityHotelDataBase().get(i).toString();
            ArrayList<Room> SingleRooms = location.getCityHotelDataBase().get(i).getFreeRooms(date, RoomType.SINGLE);
            ArrayList<Room> DoubleRooms = location.getCityHotelDataBase().get(i).getFreeRooms(date, RoomType.DOUBLE);
            ArrayList<Room> JSRooms = location.getCityHotelDataBase().get(i).getFreeRooms(date, RoomType.JUNIORSUITE);
            System.out.print((i+1)+"\t\t"+location.getCityHotelDataBase().get(i).getHotelName()+ "\t");
            System.out.print(SingleRooms.size()+ "\t\t"+ SingleRooms.get(0).getPrice()+"\t\t");
            System.out.print(DoubleRooms.size()+ "\t\t"+ DoubleRooms.get(0).getPrice()+"\t\t");
            System.out.print(JSRooms.size()+ "\t\t"+ JSRooms.get(0).getPrice()+"\n");
        }
        /*prompt the user to select a hotel
        */
        Scanner UserInput= new Scanner(System.in);
        System.out.print("Enter the NUMBER of hotel you choose: ");
        boolean keepgoing=true;
        while(keepgoing){
            if(UserInput.hasNextInt()){
                chosenHotel=location.getCityHotelDataBase().get(UserInput.nextInt());
                keepgoing=false;
            }
            else{
                System.out.println("Error");
                keepgoing=true;
            }
        }        
    }
    
    /*take in a datepair and use it to allow the user to select a room or multiple rooms to reserve
    */
    public void ChooseRooms(DatePair date){
        /*set chosenDate instance variable
        */
        chosenDate = date;
        chosenHotel.getHotelName();
        ArrayList<Room> SingleRooms = chosenHotel.getFreeRooms(date, RoomType.SINGLE);
        ArrayList<Room> DoubleRooms = chosenHotel.getFreeRooms(date, RoomType.DOUBLE);
        ArrayList<Room> JSRooms = chosenHotel.getFreeRooms(date, RoomType.JUNIORSUITE);
        /*prompt the user to input the type of room they want
	*/
        Scanner UserInput= new Scanner(System.in);
        System.out.print("Enter the TYPE of rooms you want to book, 1 for SINGLE, 2 for DOUBLE and 3 for JS: ");
        int type=UserInput.nextInt();
        /*(prompt the user to input the number of rooms they want
        */
        System.out.print("Enter the NUMBER of rooms you want to book: ");
        int num=UserInput.nextInt();
        
        /*reserve rooms for user by adding them to the chosen room instance variable
        */
        switch(type){
            case 1: {
                for(int i=0; i<num; i++) 
                    chosenRoom.add(SingleRooms.get(i));
                break;
            }
            case 2:{
                for(int i=0; i<num; i++) 
                    chosenRoom.add(DoubleRooms.get(i));
                break;
            }
            case 3:{
                for(int i=0; i<num; i++) 
                    chosenRoom.add(JSRooms.get(i)); 
                break;
            }
        }
        for(int i=0; i<chosenRoom.size();i++)
            chosenRoom.get(i).insert(date);
    } 
    
    /*calculates the net cost of all the rooms in the reservation
    */
    public void CalculateCost(ArrayList<Room> rooms){
        for(int i=0; i<rooms.size(); i++){
            TotalCost=TotalCost+rooms.get(i).getPrice();
        }
    }
    
    /*assign values to all the instance variables in the reservation either directly or by calling other methods
    */
    public void confirmReservation(String name, int ID, String desiredLocation, DatePair date){
        user=name;
        idNumber=ID;
        this.Search(desiredLocation, date);
        this.ChooseRooms(date);
        this.CalculateCost(chosenRoom);
        // Add the confirmed reservation to the arraylist of reservation generated in Main function
    }
    
    /*cancel reservation by setting isCancelled instance variable to false and calling the cancel method on each room in the reservation
    */
    public void cancelReservation() {
        isCancelled = false;
        for(int i=0; i<chosenRoom.size(); i++)
            chosenRoom.get(i).cancel(this.chosenDate);
    }
    
    /*getter methods
    */
    public String getUser() {
        return user;
    }
    
    public Hotel getChosenHotel() {
        return chosenHotel;
    }
    
    public int getIDNumber() {
        return idNumber;
    }
    
    public ArrayList<Room> getChosenRoom() {
        return chosenRoom;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public Boolean getIsCancelled() {
        return isCancelled;
    }
    
    /*toString method
    */
    @Override
    public String toString(){
        return "User Name:  " + this.user + "\nid Number: " + this.idNumber + "\nHotel: "+this.chosenHotel.getHotelName()+"\n "+this.chosenDate;
    }
}
