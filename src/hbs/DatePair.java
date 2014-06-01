/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DatePair represent one single period of time the room is booked
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DatePair implements Serializable {

	private LocalDate checkInDate;
	private LocalDate checkOutDate;

	/**
	 * DatePair's default constructor
	 */
	public DatePair() {
		
	}
	/**
	 * DatePair explicit constructor
	 * @param checkInDate the LocalDate represent the check-in date
	 * @param checkOutDate the LocalDate represent the check-out date
	 */
	public DatePair(LocalDate checkInDate, LocalDate checkOutDate) throws BeforeTodayException, CheckinAfterCheckoutException {
		// check checkInDate is after today
		if (checkInDate.isBefore(LocalDate.now())) {
			throw new BeforeTodayException("checkInDate should be after to today");
		}
		// check checkInDate is before checkOutDate
		if (checkInDate.isAfter(checkOutDate)) {
			throw new CheckinAfterCheckoutException("checkInDate should be prior to checkOutDate");
		}

		// don't need to make a deep copy since LocalDate once constructed will never change
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}

	/**
	 * get the check-in date
	 * @return the check-in Date
	 */
	public LocalDate getCheckInDate() { return checkInDate; }
  
	/**
	 * get the check-out date
	 * @return the check-in Date
	 */
	public LocalDate getCheckOutDate() { return checkOutDate; }

	/**
	 * check whether 2 object are equal
	 * @param o, target object
	 * @return whether they are equal
	 */
	public boolean equals(Object o) {
	    if (o == null) return false;
		if (!(o instanceof DatePair)) 
			return false;
		DatePair pairo = (DatePair) o;
		return this.checkInDate.equals(pairo.getCheckInDate()) &&
			   this.checkOutDate.equals(pairo.getCheckOutDate());
	}
	
	/**
	 * calculate how many days are there between checkInDate and checkOutDate
	 * @return number of days in between
	 */
	public int daysBetween(){
      int days=0;
      LocalDate temp1 = checkInDate;
      LocalDate temp2 = checkOutDate;
      while(temp2.compareTo(temp1) > 0){
          temp2 = temp2.minusDays(1);
          days++;
      }
      return days;
	}
}