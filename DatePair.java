/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DatePair implements Serializable {

	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	// may include a field to represent personal info

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

  public LocalDate getCheckInDate() { return checkInDate; }
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
  public static void main (String[] args) {
	  LocalDate ld = LocalDate.now();
	  System.out.println(ld.getYear());
	  System.out.println(ld.getMonth());
  }

}
