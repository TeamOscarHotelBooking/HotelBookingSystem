/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

/**
 * This class define the exception when check-in date is before current date.
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class BeforeTodayException extends Exception{
	
	/**
	 * Exception's default constructor
	 */
	public BeforeTodayException() { super(); }
	
	/**
	 * Exception's message constructor
	 * @param message, error message
	 */
	public BeforeTodayException(String message) { super(message); }
}

