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
     * Temporary method to check the code
     * @param HotelName
     * @return Hotel
     */
    public Hotel getHotel(Hotel HotelName){
            
            if(CityHotelDataBase.indexOf(HotelName)!= -1){      // This condition because the function will return -1 if the hotels does not exist
                int DesiredHotel = CityHotelDataBase.indexOf(HotelName);
                return this.CityHotelDataBase.get(DesiredHotel);
            }
        
        return null;
    }
    
    /**
     * Observer of the state of a specific room in a desired hotel at a certain location
     * @param hotel
     * @param floor
     * @param RoomNumber
     * @return State of the room
     * @author Naif Almakhdhub
     */
    public RoomState getHotelRoomState(Hotel hotel, int floor, int RoomNumber){
        
        return this.getHotel(hotel).getRoomState(floor, RoomNumber);
        
    }
    
    
    
}
