
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
    private ArrayList<Room> chosenRoom;
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
        chosenHotel = null;
        chosenRoom = new ArrayList<Room>();
        
    }
    
    public void Search(String desiredLocation, DatePair date) {
        for(int i=0; i<arrayOfLocations.size(); i++) {
            if((arrayOfLocations.get(i).getCity()).equals(desiredLocation)) {
                location = arrayOfLocations.get(i);
            }
        }
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
    
    public void ChooseRooms(DatePair date){
        chosenDate = date;
        chosenHotel.getHotelName();
        ArrayList<Room> SingleRooms = chosenHotel.getFreeRooms(date, RoomType.SINGLE);
        ArrayList<Room> DoubleRooms = chosenHotel.getFreeRooms(date, RoomType.DOUBLE);
        ArrayList<Room> JSRooms = chosenHotel.getFreeRooms(date, RoomType.JUNIORSUITE);
	Scanner UserInput= new Scanner(System.in);
        System.out.print("Enter the TYPE of rooms you want to book, 1 for SINGLE, 2 for DOUBLE and 3 for JS: ");
        int type=UserInput.nextInt();
        System.out.print("Enter the NUMBER of rooms you want to book: ");
        int num=UserInput.nextInt();
        
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
    
    public void CalculateCost(ArrayList<Room> rooms){
        for(int i=0; i<rooms.size(); i++){
            TotalCost=TotalCost+rooms.get(i).getPrice();
        }
    }
    
    public void confirmReservation(String name, int ID, String desiredLocation, DatePair date){
        user=name;
        idNumber=ID;
        this.Search(desiredLocation, date);
        this.ChooseRooms(date);
        this.CalculateCost(chosenRoom);
        // Add the confiremed reservation to the arraylist of reservation generated in Main function
    }
    
    public void cancelReservation() {
        isCancelled = false;
        for(int i=0; i<chosenRoom.size(); i++)
            chosenRoom.get(i).cancel(this.chosenDate);
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
    
    public ArrayList<Room> getChosenRoom() {
        return chosenRoom;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public Boolean getIsCancelled() {
        return isCancelled;
    }
    @Override
    public String toString(){
        return this.idNumber+"  "+this.user+"  "+this.chosenHotel.getHotelName()+"  "+this.chosenDate;
    }
}
