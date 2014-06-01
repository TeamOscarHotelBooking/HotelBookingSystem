/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

/**
 * This class define the exception when check-in date is after check-out date.
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class CheckinAfterCheckoutException extends Exception{
	/**
	 * Exception's default constructor
	 */
	public CheckinAfterCheckoutException() { super(); }
	
	/**
	 * Exception's message constructor
	 * @param message, the error message
	 */
	public CheckinAfterCheckoutException(String message) { super(message); }
}

