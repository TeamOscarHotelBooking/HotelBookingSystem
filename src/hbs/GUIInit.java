/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import static hbs.HBS.writeCustomerList;
import static hbs.HBS.writeLocationList;
import static hbs.HBS.writeReservationID;
import java.util.ArrayList;

/**
 * This class initialize the database files used in GUI
 * 2 locations with 2 hotels each, and no user as default
 * first reservation ID is 100
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class GUIInit {
	/**
	 * main function to initialize the database files
	 * @param args 
	 */
	public static void main(String [] args) {
		Hotel h1 = new Hotel("Hilton", 10, 20, 30, 100, 200, 300, 3, "Chicago");
		Hotel h2 = new Hotel("Days Inn", 10, 20, 30, 100, 200, 300, 3, "Chicago");
		Hotel h3 = new Hotel("Ru Jia", 10, 20, 30, 100, 200, 300, 3, "Evanston");
		Hotel h4 = new Hotel("Five Star", 10, 20, 30, 100, 200, 300, 3, "Evanston");
		
		Location loc1 = new Location("Chicago");
		Location loc2 = new Location("Evanston");
		
		loc1.AddHoteltoDataBase(h1);
		loc1.AddHoteltoDataBase(h2);
		loc2.AddHoteltoDataBase(h3);
		loc2.AddHoteltoDataBase(h4);
		
		ArrayList<Location> database = new ArrayList<Location>();
		
		database.add(loc1);
		database.add(loc2);
				
		writeLocationList("locationDB.dat", database);
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		writeCustomerList("customerDB.dat", customerList);
		
		Integer myint = new Integer(100);
		writeReservationID("idDB.dat", myint);
		System.out.println("finished init DB files.");
	}
}
