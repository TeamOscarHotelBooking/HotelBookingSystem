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
 * has to be maintained sorted
 * make sure there is no overlap
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class DateStruct {
	private ArrayList<DatePair> ds;
	
	public DateStruct() { this.ds = new ArrayList<DatePair>(); }
	
	/**
	 * not gonna use this constructor
	 * if use, has to check no-overlap and sorted before use
	 * @param ds 
	 */
	public DateStruct(ArrayList<DatePair> ds) {	this.ds = ds; }
	
	/**
	 * need to check return value
	 * Or we can do this by throw an exception
	 * @param dp
	 * @return 0 when success, -1 when failed
	 */
	public void insert(DatePair dp) {
		// proper insert will maintain sorted and guarentee no overlap
		LocalDate attemptCheckInDate = dp.getCheckInDate();
		LocalDate attemptCheckOutDate = dp.getCheckOutDate();
		
		System.out.println("omg");
		System.out.println(attemptCheckInDate.toString());
		System.out.println(attemptCheckOutDate.toString());
		System.out.println(ds.size());
		
		
		// check whether attemptCheckInDate is valid comparing to current Date
		if (!(attemptCheckInDate.isEqual(LocalDate.now()) || 
				attemptCheckInDate.isAfter(LocalDate.now()))) {
			System.out.println("invalid DatePair0");
			System.exit(-1);
		}
		
		if (ds.size() == 0) {
			ds.add(dp);
			return;
		}
		System.out.println(ds.size());
		for (int i = 0; i < ds.size(); ++i) {
			LocalDate currentCheckInDate = ds.get(i).getCheckInDate();
			LocalDate currentCheckOutDate = ds.get(i).getCheckOutDate();
			
			System.out.println(i);
			System.out.println(currentCheckInDate.toString());
			System.out.println(currentCheckOutDate.toString());
			
			// before or on that date
			if (attemptCheckOutDate.isBefore(currentCheckInDate) || 
				attemptCheckOutDate.isEqual(currentCheckInDate)) {
				System.out.println(ds.size());
				ds.add(i, dp);
				System.out.println(ds.size());
			}
			/*
			else if (attemptCheckOutDate.isAfter(currentCheckInDate) && 
						(attemptCheckOutDate.isBefore(currentCheckOutDate) ||
						attemptCheckOutDate.isEqual(currentCheckOutDate))) {
				//return -1;
			}
			*/
			else if (attemptCheckOutDate.isAfter(currentCheckInDate) && 
					(attemptCheckOutDate.isBefore(currentCheckOutDate) ||
					attemptCheckOutDate.isEqual(currentCheckOutDate))) {
				//System.out.println(attemptCheckOutDate.isAfter(currentCheckInDate));
				//System.out.println(attemptCheckOutDate.isBefore(currentCheckOutDate));
				//System.out.println(attemptCheckOutDate.isEqual(currentCheckOutDate));
				//System.out.println(attemptCheckOutDate.toString());
				//System.out.println(currentCheckOutDate.toString());
				System.out.println("invalid DataPair1");
				System.exit(-1);
			}
			/*
			else if (attemptCheckOutDate.isAfter(currentCheckOutDate) &&
					attemptCheckInDate.isBefore(currentCheckOutDate)) {
				//return -1;
			}
			*/
			else if ((attemptCheckOutDate.isAfter(currentCheckOutDate) &&
					attemptCheckInDate.isBefore(currentCheckOutDate))) {
				System.out.println("invalid DataPair2");
				System.exit(-1);
			}
			
			/*
			else if (attemptCheckInDate.isAfter(currentCheckOutDate) &&
					i == ds.size() - 1) {
				ds.add(ds.size(), dp);
			}
			*/
			// otherwise deal in the next iteration
		}
		ds.add(ds.size(), dp);
		
		// has to do a search before insertion
		// and make sure no overlap
		// need a boolean method to check this first
	}
	
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