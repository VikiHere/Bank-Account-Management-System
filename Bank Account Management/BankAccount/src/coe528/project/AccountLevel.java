package coe528.project;

/**
 * @author victoriasipinkarovski
 * Interface for the Account Levels
 * Only Method is changing the Level of the customer
 */
public interface AccountLevel {//DONE
//Overview: Method for managing the 
    //customer account level
    
    /*
        Method that will get overrided
        in the BankAccount class
    */
    public void chgLvl(BankAccount A);
    
}
