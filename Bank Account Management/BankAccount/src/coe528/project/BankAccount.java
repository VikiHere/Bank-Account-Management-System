package coe528.project;

/**
 * @author victoriasipinkarovski
 * Account Class, Where the basic functionalities 
 * of all accounts are defined.
 */
public class BankAccount {
    
//Defining the variables

    public AccountLevel level;
    public double tempLevel;
    public double balance;
    public double tempBalance; 
  
//Once created, 100$ is deposited, beginning Level is set

    /**
     *
     */
    public void Bankaccount(){
        balance = 100; //when created 100$ is added
        level.chgLvl(this);//Set Level to Silver
        
    }    
    
//Getters and Setters
    
    //Level, may need a temp level idk

    /**
     *
     */
    public void getLevel(){
        
    }
    
//Methods
    
    //Withdraw money - returns remaining balance

    /**
     *
     * @param x
     */
    public void withdraw(double x){
        if (x > balance){
            //Error
            System.out.print("ERROR: Not enough money in account for this pruchase");
        }
        else if (x <= balance){
            tempBalance = balance - x;
            balance = tempBalance;
        }
        //return balance;
    }
    
    //Deposit Money - returns remaining amount

    /**
     *
     * @param x
     */
    public void deposit(double x){
        if (x < 0){
            //Error
            System.out.print("ERROR: Not valid amount");
        }
        else{
            tempBalance = balance + x;
            balance = tempBalance;
        }
    }
    
    
}

/*
Exam - design patterns 2 very important since exam would be applying design patterms to this

*/
