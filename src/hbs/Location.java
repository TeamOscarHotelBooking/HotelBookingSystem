/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

/**
 *
 * @author Naif Almakhdhub
 */
import java.io.Serializable;
import java.lang.Object;
import java.util.ArrayList;
public class Location implements Serializable {
    
    private ArrayList<Hotel> CityHotelDataBase;
    private String City;
    
    public Location(){
        
    }
    
    /**
     * Constructor
     * Constructs a data base in form of a list
     */
    public Location(String City){
        this.CityHotelDataBase = new ArrayList<Hotel>();
        this.City = City;
    }
    
    /**
     * Copy Constructor
     * @param copyLocation 
     * @author Naif Almakhdhub
     */
    public Location(Location copyLocation){
        this.CityHotelDataBase = copyLocation.getCityHotelDataBase();
        this.City = copyLocation.getCity();
    }
    
    /**
     * Adds a hotel to the data base
     * If hotel already exists, will prompt a notification to the user
     */
    public void AddHoteltoDataBase(Hotel hotel){
        if(CityHotelDataBase.indexOf(hotel)==-1){   // Check if hotel has not been added already
        this.CityHotelDataBase.add(hotel);
        }
        else{
            System.out.println("This hotel has already been added to the Data Base");
        }
    }
    
    /**
     * Observer of City Hotel Data Base
     * @return CityHotelDataBase
     */
    public ArrayList<Hotel> getCityHotelDataBase(){
        return this.CityHotelDataBase;
    }
    
    /**
     * Observer of the City name
     */
    public String getCity(){
        return this.City;
    }
    
    /**
     * Method to return a specific hotel in Location given the hotel name.
     * @param HotelName
     * @return Hotel
     */
    public Hotel getHotel(String HotelName){
        
        for(int i = 0; i<this.CityHotelDataBase.size();i++){
            
            if(this.CityHotelDataBase.get(i).getHotelName().equals(HotelName)){
                return this.CityHotelDataBase.get(i);
                
            }
        }
        
        return null;
    }
    
    /**
     * Observer of the room state
     * @param hotel
     * @param floor
     * @param RoomNumber
     * @param dp
     * @return 
     */
    public RoomState getHotelRoomState(String hotel, int floor, int RoomNumber, DatePair dp){
        
        return this.getHotel(hotel).getRoom(floor, RoomNumber).search(dp);
        
    }
    
    
    
}


