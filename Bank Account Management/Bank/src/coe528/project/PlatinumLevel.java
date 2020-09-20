package coe528.project;
/**
 *Class for the platinum level of 
 * account levels
 * @author victoriasipinkarovski
 */
public class PlatinumLevel implements AccountLevel{
    
    /**
     *Setting the account level to platinum
     * @param x
     */
    public PlatinumLevel(BankAccount x){
        x.setLevelString("Platinum");
    }
    
    @Override
    public void LevelCheck(BankAccount ba){
    //Downgrade to Gold    
        if((ba.getBalance() < 20000) && (ba.getBalance() >= 10000)){
            AccountLevel gold = new GoldLevel(ba);
            ba.setLevel(gold);
        }
    //Downgrade to Silver
        else if (ba.getBalance() < 10000){
            AccountLevel silver = new SilverLevel(ba);
            ba.setLevel(silver);
        }  
    }
}
