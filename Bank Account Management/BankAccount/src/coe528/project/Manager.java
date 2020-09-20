package coe528.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;


/**
 * @author victoriasipinkarovski
 * Manager Class that extends User.
 * All functionalities of a manager 
 * is defined here
 */
public class Manager extends User{
//Overview: There is one Manager for serveral Customers. 
    //Each customer has their own username and password. The 
    //Manager keeps track of this information.
//Abstract Fuunction
    //AF(c) : All customer's usernames and passwords for n reps
    //n = number of entries in the arraylist of customer objects
//Rep Invariant:
    //if ( [all c.Customers is Customer Object] && [c.Customers != none]
    //      && [c.Customer.username != c[0 - n-1].Customer.username])
    //          Rep is arraylist of customers
    
//Create the File with customer info, one file per manager
    public void createFile(){
        
    }

//Create File to store customers usernames and passwords
    public void checkFileUserPass() {
        
    }
    
    
    
}
