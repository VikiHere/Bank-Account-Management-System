package coe528.project;


/**
 * Overview: Account Class, Where the basic functionalities 
 * of all accounts are defined, Mutable
 * @author victoriasipinkarovski
 */
public class BankAccount {
    
//Defining the variables

    public AccountLevel level;
    public String levelString;
    public double balance;
    public double tempBalance; 
  
    /**
     *Once created, 100$ is deposited,
     * beginning Level is set
     */

    public BankAccount(){
        balance = 100.0; //when created 100$ is added
        level = new SilverLevel(this);//Set Level to Silver
    }    
    
//Getters and Setters

    /**
     *Setting the customer Level
     * @param y
     */
    public void setLevelString(String y){
        levelString = y;
    }
    
    /**
     *Setting the customer Level
     * @param x
     */
    public void setLevel(AccountLevel x){
        level = x;
    }
    
    /**
     *Getting the Customer level
     * @return String level of customer
     */
    public String getLevel(){
        return levelString;
    }
    
    /**
     *Getting the Balance in the 
     * customer's account
     * @return double balance in customer's account
     */
    public double getBalance(){
        return balance;
    }
 
    
//Methods
    
    /**
     *Withdraw money - returns remaining balance
     * @param x - Withdrawn amount
     */
    public void withdraw(double x){
        if (x > balance){
            //Error
            System.out.print("ERROR: Not enough money in account for this pruchase");
        }
        else if (x <= balance){
            tempBalance = balance - x;
            balance = tempBalance;
            //CHECK IF SAME LEVEL STILL
        }
    }
    
    /**
     *Deposit Money - returns remaining amount
     * @param x - Deposit amount
     */
    public void deposit(double x){
        if (x < 0){
            //Error check
                // If the value is less than 0 then the amount is not valid
            System.out.print("ERROR: Not valid amount");
        }
        else{
        //Everythin is fine
            tempBalance = balance + x;
            balance = tempBalance;
            //CHECK IF SAME LEVEL STILL
            level.LevelCheck(this);
        }
    }
    
    
}