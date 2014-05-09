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
import java.util.ArrayList;
import java.lang.Object;
public class Location {
    
    protected ArrayList<Hotel> CityHotelDataBase;
    protected String City;
    
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
     * Observer of the City name
     */
    public String getCity(Location CurrentLocation){
        return this.City;
    }
    
    /**
     * Temporary method to check the code
     * @param HotelName
     * @return 
     */
    public Hotel SearchForHotel(Hotel HotelName){
        
            if(CityHotelDataBase.indexOf(HotelName)!= -1){      // This condition because the function will return -1 if the hotels does not exist
                int DesiredHotel = CityHotelDataBase.indexOf(HotelName);
                return CityHotelDataBase.get(DesiredHotel);
            }
        
        return null;
    }
    
    
    
}
