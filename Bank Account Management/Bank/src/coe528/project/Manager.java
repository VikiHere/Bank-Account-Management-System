package coe528.project;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;


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
    
    /**
     *Arraylist of Customers
     */
    public ArrayList<Customer> customers = new ArrayList<Customer>();
    
//Variables
    int temp;

    /**
     *Manager Constructor  
     */
    public Manager(){
    //Setting the password of the manager. One manager per Bank
        super.setPassword("admin");
        super.setUsername("admin");
        
    //Clearing any only files - When you close the program and 
        //open it again, all customers from the previous session 
        //will be deleted
        File directory = new File("./src/CustomerFiles");      
        String[] insideFiles;    
        if(directory.isDirectory()){
            insideFiles = directory.list();
            for (int i=0; i<insideFiles.length; i++) {
                File temp = new File(directory, insideFiles[i]); 
                temp.delete();
            }
         } 
    }
    

    /**
     *Method used in adding customer to add the 
     * customer to the customer files folder
     * @param username
     * @return
     */
    public Customer getCustomerFromArrayList(String username){
        int track = 0;
        for (int i = 0; i < customers.size(); i++){//goes through the arraylist
            if(username.equals(customers.get(i).getUsername())){
                track = i;
                //System.out.println("Found the customer");
                break;
            }
        }
        if (track >= 0){
            //System.out.println("returning the customer arraylist thing");
            return customers.get(track);
        }
        else{
            //System.out.println("ERROR: Can't find user, Username does not exist");
            return null;
        }
    }
   

    /**
     *Add customer to store usernames and passwords
     * @param username
     * @param password
     */
    public void addCustomerToFile(String username, String password) {
    //Check if username already has a file    
        File tempFile = new File("./src/CustomerFiles/" + username + ".txt");
        boolean ifExists = tempFile.exists();
    //Username/file already exists    
        if(ifExists == true){
            System.out.println("ERROR: A Customer with that username already exists!");
        }
    //Username does not have a file that exists
        else if (ifExists == false){
        //Create New User File
            try {                  

                FileWriter output = new FileWriter("./src/CustomerFiles/" + username + ".txt");// this here allows file to be appended
                output.write("Username: " + username + "\nPassword: " + password );//this is writing new line by line
                output.close();

            } catch ( IOException e ) {
            }
        }
    }

    /**
     *Method for deleting a customer to use to also 
     * delete their customer file from the customer
     * files folder
     * @param username
     */
    public void deleteCustomerFromFile(String username) {
        boolean deleted;
    //Check if username already has a file    
        File tempFile = new File("./src/CustomerFiles/" + username + ".txt");
        boolean ifExists = tempFile.exists();
    //Username/file already exists    
        if(ifExists == false){
            System.out.println("ERROR: A Customer with that username does not exist");
        }
    //Username does not have a file that exists
        else if (ifExists == true){
        //delete File         
            deleted = tempFile.delete();
        //True if files deleted sucessffulylylyl    
            if(deleted == true){
                System.out.println("Deleted Customer Sucessfully!");
            }
        //False if something went wrong
            else if(deleted == false){
                System.out.println("ERROR: Something went wrong while trying to delete customer");
            }
        }
        
    }
    
//Getters

    /**
     *Get the arraylist of customers - helper
     * method
     * @return
     */
    public ArrayList<Customer> getCustomers() {
        return customers;
    }   

    /**
     *Method to Delete a Customer in arraylist
     * @param username
     * @return
     */
    public String deleteCustomer(String username){
        String message = "--";
        
    //If empty, error
        if(customers.isEmpty() == true){
            System.out.println("ERROR: No Customers to delete");
            message = "No Customers to delete";                         
        }
        for (temp = 0; temp < customers.size(); temp++){
            if(username.equals(customers.get(temp).getUsername())){
                customers.remove(temp);
                deleteCustomerFromFile(username); 
                message = "Customer removed!";
                break;
            }
        }
        return message;
    }

    /**
     *Method to Add customer in arraylist    
     * @param username
     * @param password
     * @return
     */
    public String addCustomer(String username, String password){
        int added = 0;
        int notAdd = 0;
        String message = "";
        
    //If empty, add the customer
        if(customers.isEmpty() == true){
            Customer cust = new Customer(username, password);
            customers.add(cust);
            addCustomerToFile(username, password);
            message = "Customer added!";                         
        }
    //Checking to see any duplicate usernamers
        else{
            for (temp = 0; temp < customers.size(); temp++){
                if(customers.get(temp).getUsername().equals(username)){
                    System.out.println("ERROR: Username already exists");
                    message = "Username Taken";
                    break;
                }
            }
            if (!message.equals("Username Taken")){
                Customer newCust = new Customer(username, password);
                customers.add(newCust);
                addCustomerToFile(username, password);
                message = "Customer added!";
            }
            
        }
        return message;
    }
    
}
    

