package coe528.project;


/**
 * @author victoriasipinkarovski
 * Customer Class, all functionalities of a 
 * customer user is within this class
 */
public class Customer extends User{
    
//Each Customer has ONE BankAccount
    private BankAccount ba = new BankAccount();   
    
    /**
     *Constructor of Customer 
     * @param username - Username of customer
     * @param password - Password of customer
     */
  public Customer(String username, String password){
      super.setPassword(password);
      super.setUsername(username);
  }
    
//Opperations/Methods for the Customer 
    
    /**
     *Online purchase method for the customer
     * @param payment - amount for online purchase
     */
    public void onlinePurchase(double payment){
        if (payment < 50){
            System.out.print("ERROR: Must have purchase over 50$");
        }
        else if (payment >= 50){
        //depending on the level, a fee is charged
            if("Platinum".equals(ba.getLevel())){
                ba.withdraw(payment); // No fee
            }
            else if ("Gold".equals(ba.getLevel())){
                ba.withdraw(payment + 10.0); // 10$ fee
            }
            else if ("Silver".equals(ba.getLevel())){
                ba.withdraw(payment + 20.0); // 20$ fee
            }
        }
    }
    
    /**
     *withdraw - money taken out by customer
     * @param amt - amount to withdraw
     */
    public void withdraw(double amt){
        ba.withdraw(amt);
    }
    
    /**
     *deposit - amount being put in customer's 
     *  account
     * @param amt
     */
    public void deposit(double amt){
        ba.deposit(amt);
    }
  
//Getters of all parts of customer
    
    /**
     *Get the String level of the customer
     * @return String Level of customer account
     */
    public String getLevel(){
        return ba.getLevel();
    }
    

    /**
     *Return the Balance in the Customer's account
     * @return double balance left in the customer's account
     */
    public double getBalance(){
        return ba.getBalance();
    } 
    
}
