package coe528.project;

import java.io.FileInputStream; 
import java.util.Scanner;

/**
 * Abstract Method for a parent class User,
 * This class will be extended by the customer
 * and manager classes.
 * @author victoriasipinkarovski
 */
public class User {
//Define Variables
    private String password;
    private String username;
    private String temp;
    
//Getters and Setters 
    
    /**
     *Getting the username of the user
     * @return String username of user
     */
    public String getUsername(){
        return username;
    }
    
    /**
     *Sets the user's username
     * @param x - String x, the username for current user
     */
    public void setUsername(String x){
        temp = x;
        username = temp;
    }
    
    /**
     *Gets the password of the user
     * @return String password - the password of current user
     */
    public String getPassword(){
        return password;
    }
    
    /**
     *Sets the password of the user
     * @param y - String y, the password for user
     */
    public void setPassword(String y){
        temp = y;
        password = temp;
    }
    
}



