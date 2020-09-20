package coe528.project;

import java.io.FileInputStream; 
import java.util.Scanner;

/**
 * @author victoriasipinkarovski
 * Abstract Method for a parent class User.
 * This class will be extended by the customer
 * and manager classes.
 */
public class User {
//Define Variables
    private String password;
    private String username;
    private String temp;
    
//Getters and Setters 
    
    //Username
    public String getUsername(){
        return username;
    }
    
    //add to the file?? - only manager can use
    public void setUsername(String x){
        temp = x;
        username = temp;
    }
    
    //Password
    public String getPassword(){
        return password;
    }
    
    //Add to the file?? - only manager can use
    public void setPassword(String y){
        temp = y;
        password = temp;
    }
    
}



