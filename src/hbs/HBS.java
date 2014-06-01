/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hbs;

import java.io.*;
import java.math.BigInteger;
import java.text.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class defines method to read/write states to files
 * @author Shuo Zhang <shuozhang2014@u.northwestern.edu>
 */
public class HBS {

    /**
     * Method to write location list to a file
     * @param FileName, path-to-the-file
     * @param DataBase, a list of location
     * @author Naif Almakhdhub
     */
    public static void writeLocationList(String FileName, ArrayList<Location> DataBase){
        
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(DataBase);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Method to read location list from a file
     * @param FileName, path-to-the-file
     * @author Naif Almakhdhub
	 * @return a list of locations
     */
    public static ArrayList<Location> readLocationList(String FileName){
         ArrayList<Location> DataBase =null;
        try {
            ObjectInputStream input = new ObjectInputStream (new FileInputStream(FileName));
            DataBase = (ArrayList<Location>) input.readObject();
            input.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DataBase;
    }
	
	/**
	 * Method to write customer list to a file
	 * @param FileName, path-to-a-file
	 * @param DataBase, a list of customers
	 */
	public static void writeCustomerList(String FileName, ArrayList<Customer> DataBase){
        
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(DataBase);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
	/**
	 * Method to read customer list from a file
	 * @param FileName, path-to-a-file
	 * @return the list of customer
	 */
    public static ArrayList<Customer> readCustomerList(String FileName){
         ArrayList<Customer> DataBase =null;
        try {
            ObjectInputStream input = new ObjectInputStream (new FileInputStream(FileName));
            DataBase = (ArrayList<Customer>) input.readObject();
            input.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DataBase;
    }
	
	/**
	 * Method to write reservation ID to a file
	 * @param FileName, path-to-a-file
	 * @param DataBase, most recent reservation ID
	 */
	public static void writeReservationID(String FileName, Integer DataBase){
        
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FileName));
            output.writeObject(DataBase);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
	/**
	 * Method to read most recent reservation ID from a file
	 * @param FileName, path-to-a-file
	 * @return most recent reservation ID
	 */
    public static Integer readReservatinID(String FileName){
        Integer DataBase =null;
        try {
            ObjectInputStream input = new ObjectInputStream (new FileInputStream(FileName));
            DataBase = (Integer) input.readObject();
            input.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HBS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return DataBase;
    }
}