/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * DateStruct contains an array of DatePair representing all booked periods
 * has to be maintained sorted, make sure there is no overlap
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DateStruct {
	private ArrayList<DatePair> ds;
	
	/**
	 * DateStruct default c'tor
	 */
	public DateStruct() { this.ds = new ArrayList<DatePair>(); }
	
	/**
	 * not gonna use this constructor
	 * if use, has to check no-overlap and sorted before use
	 * @param ds an ArrayList of DatePair
	 */
	public DateStruct(ArrayList<DatePair> ds) {	this.ds = ds; }
	
	/**
	 * cancel the a period of specific DatePair
	 * @param dp user-specified DatePair
	 * @return return 0 for success, return -1 for failure
	 */
	public int cancel(DatePair dp) {
		int ret = -1;
		for (int i = 0; i < ds.size(); ++i) {
			if (ds.get(i).equals(dp)) {
				ds.remove(i);
				ret = 0;
			}
		}
		return ret;
	}
	
	/**
	 * does both throw exception and return BOOKED/AVAILABLE
	 * @param dp the DatePair u want to search
	 * @return the RoomState of that DatePair
	 */
	public RoomState search(DatePair dp) {
		
		LocalDate attemptCheckInDate = dp.getCheckInDate();
		LocalDate attemptCheckOutDate = dp.getCheckOutDate();
		
		if (!(attemptCheckInDate.isEqual(LocalDate.now()) || 
				attemptCheckInDate.isAfter(LocalDate.now()))) {
			throw new UnsupportedOperationException("invalid DatePair0");
			//here throw exception makes more sense
		}
		
		if (ds.size() == 0) {
			//ds.add(dp);
			return RoomState.AVAILABLE;
		}
		
		for (int i = 0; i < ds.size(); ++i) {
			LocalDate currentCheckInDate = ds.get(i).getCheckInDate();
			LocalDate currentCheckOutDate = ds.get(i).getCheckOutDate();
			if (attemptCheckOutDate.isBefore(currentCheckInDate) || 
				attemptCheckOutDate.isEqual(currentCheckInDate)) {
				//ds.add(i, dp);
				return RoomState.AVAILABLE;
			}
			else if (attemptCheckOutDate.isAfter(currentCheckInDate) && 
					(attemptCheckOutDate.isBefore(currentCheckOutDate) ||
					attemptCheckOutDate.isEqual(currentCheckOutDate))) {
				//throw new UnsupportedOperationException("invalid DatePair1");
				return RoomState.BOOKED;
			}
			else if ((attemptCheckOutDate.isAfter(currentCheckOutDate) &&
					attemptCheckInDate.isBefore(currentCheckOutDate))) {
				//throw new UnsupportedOperationException("invalid DatePair2");
				return RoomState.BOOKED;
			}
		}
		//ds.add(ds.size(), dp);
		return RoomState.AVAILABLE;
	}
	
	/**
	 * insert a DatePair
	 * @param dp the DatePair u want to insert
	 * @return 0 when success, -1 when failed
	 */
	public void insert(DatePair dp) {
		// proper insert will maintain sorted and guarentee no overlap
		LocalDate attemptCheckInDate = dp.getCheckInDate();
		LocalDate attemptCheckOutDate = dp.getCheckOutDate();
		
		// check whether attemptCheckInDate is valid comparing to current Date
		if (!(attemptCheckInDate.isEqual(LocalDate.now()) || 
				attemptCheckInDate.isAfter(LocalDate.now()))) {
			throw new UnsupportedOperationException("invalid DatePair0");
		}
		
		if (ds.size() == 0) {
			ds.add(dp);
			return;
		}
		
		for (int i = 0; i < ds.size(); ++i) {
			LocalDate currentCheckInDate = ds.get(i).getCheckInDate();
			LocalDate currentCheckOutDate = ds.get(i).getCheckOutDate();
			
			// before or on that date
			if (attemptCheckOutDate.isBefore(currentCheckInDate) || 
				attemptCheckOutDate.isEqual(currentCheckInDate)) {
				ds.add(i, dp);
			}
			else if (attemptCheckOutDate.isAfter(currentCheckInDate) && 
					(attemptCheckOutDate.isBefore(currentCheckOutDate) ||
					attemptCheckOutDate.isEqual(currentCheckOutDate))) {
				throw new UnsupportedOperationException("invalid DatePair1");
			}
			else if ((attemptCheckOutDate.isAfter(currentCheckOutDate) &&
					attemptCheckInDate.isBefore(currentCheckOutDate))) {
				//System.exit(-1);
				throw new UnsupportedOperationException("invalid DatePair2");
			}
		}
		ds.add(ds.size(), dp);
		
		// has to do a search before insertion
		// and make sure no overlap
		// need a boolean method to check this first
	}
	/**
	 * toString method to format the output
	 * @return a formatted string showing all the booked period 
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (DatePair dp : ds) {
			LocalDate lds = dp.getCheckInDate();
			LocalDate lde = dp.getCheckOutDate();
			sb.append("from: " +
					lds.getYear() +
					" " +
					lds.getMonth() +
					" " +
					lds.getDayOfMonth());
			sb.append(" \t");
			sb.append("to: " +
					lde.getYear() +
					" " +
					lde.getMonth() +
					" " +
					lde.getDayOfMonth());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/*
	public static void main (String[] args) {
		ArrayList<DatePair> list = new ArrayList<DatePair>();
		DatePair dp1 = new DatePair(LocalDate.now(), LocalDate.of(2014, Month.MAY, 25));
		DatePair dp2 = new DatePair(LocalDate.of(2014, Month.JUNE, 3), LocalDate.of(2014, Month.JULY, 10));
		list.add(dp1);
		list.add(dp2);
		DateStruct ds = new DateStruct(list);
		System.out.println(ds.toString());
	}
	*/
}