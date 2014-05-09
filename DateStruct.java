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
 *
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DateStruct {
	private ArrayList<DatePair> ds;
	// has to be maintained sorted
	// make sure there is no overlap
	
	public DateStruct() {
		ds = new ArrayList<DatePair>();
	}
	
	public DateStruct(ArrayList<DatePair> ds) {
		this.ds = ds;
	}

	
	public void insert(DatePair dp) {
		// has to do a search before insertion
		ds.add(dp);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (DatePair dp : ds) {
			LocalDate lds = dp.getStart();
			LocalDate lde = dp.getEnd();
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
	public static void main (String[] args) {
		ArrayList<DatePair> list = new ArrayList<DatePair>();
		DatePair dp1 = new DatePair(LocalDate.now(), LocalDate.of(2014, Month.MAY, 25));
		DatePair dp2 = new DatePair(LocalDate.of(2014, Month.JUNE, 3), LocalDate.of(2014, Month.JULY, 10));
		list.add(dp1);
		list.add(dp2);
		DateStruct ds = new DateStruct(list);
		System.out.println(ds.toString());
	}
}

/*
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

Period p = Period.between(birthday, today);
long p2 = ChronoUnit.DAYS.between(birthday, today);
System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                   " months, and " + p.getDays() +
                   " days old. (" + p2 + " days total)");
*/