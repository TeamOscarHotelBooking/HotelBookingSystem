/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.time.LocalDate;

/**
 * DatePair represent one single period of time the room is booked
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DatePair {

	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	// may include a field to represent personal info

	/**
	 * DatePair explicit constructor
	 * @param checkInDate the LocalDate represent the check-in date
	 * @param checkOutDate the LocalDate represent the check-out date
	 */
	public DatePair(LocalDate checkInDate, LocalDate checkOutDate) {
		// check checkInDate is before checkOutDate
		if (!(checkInDate.isBefore(checkOutDate))) {
			//System.exit(-1);
			throw new UnsupportedOperationException("checkInDate should be prior to checkOutDate");
		}

		// don't need to make a deep copy since LocalDate once constructed
		// will never change
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

  @Override
  public int hashCode() { return checkInDate.hashCode() ^ checkOutDate.hashCode(); }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof DatePair)) return false;
    DatePair pairo = (DatePair) o;
    return this.checkInDate.equals(pairo.getCheckInDate()) &&
           this.checkOutDate.equals(pairo.getCheckOutDate());
  }
  /*
  public static void main (String[] args) {
	  LocalDate ld = LocalDate.now();
	  System.out.println(ld.getYear());
	  System.out.println(ld.getMonth());
  }
  */

}