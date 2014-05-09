/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.time.LocalDate;

/**
 *
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DatePair {

  private LocalDate start;
  private LocalDate end;

  public DatePair(LocalDate start, LocalDate end) {
    this.start = start;
    this.end = end;
	//check start < end(or start <= end)
  }

  public LocalDate getStart() { return start; }
  public LocalDate getEnd() { return end; }

  @Override
  public int hashCode() { return start.hashCode() ^ end.hashCode(); }

  @Override
  public boolean equals(Object o) {
    if (o == null) return false;
    if (!(o instanceof DatePair)) return false;
    DatePair pairo = (DatePair) o;
    return this.start.equals(pairo.getStart()) &&
           this.end.equals(pairo.getEnd());
  }
  public static void main (String[] args) {
	  LocalDate ld = LocalDate.now();
	  System.out.println(ld.getYear());
	  System.out.println(ld.getMonth());
  }

}