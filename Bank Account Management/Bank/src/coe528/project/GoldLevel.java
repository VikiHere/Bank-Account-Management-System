package coe528.project;


/**
 *Goldlevel class, implements accountlevel abstract
 * class
 * @author victoriasipinkarovski
 */
public class GoldLevel implements AccountLevel{
    
    /**
     *Sets the level of the bankaccount to gold
     * @param x - bank account object
     */
    public GoldLevel(BankAccount x){
        x.setLevelString("Gold");
    }
    
    /**
     *Overview: Checks the level of a class depending on their
     * balance, and makes the appropriate changes depending
     * on the value in the customer's account
     * @param ba - bank account object
     */
    @Override
    public void LevelCheck(BankAccount ba){
    //Upgrade to platinum    
        if(ba.getBalance() >= 20000){
            AccountLevel plat = new PlatinumLevel(ba);
            ba.setLevel(plat);
        }
    //Downgrade to Silver
        else if (ba.getBalance() < 10000){
            AccountLevel silver = new SilverLevel(ba);
            ba.setLevel(silver);
        }  
    }
    
    
}
