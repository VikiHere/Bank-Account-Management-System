package coe528.project;
/**
 *Method for the silver level for
 * account level
 * @author victoriasipinkarovski
 */
public class SilverLevel implements AccountLevel {
    
    /**
     *Setting the account level to sliver
     * @param x
     */
    public SilverLevel(BankAccount x){
        x.setLevelString("Silver");
    }
    
    @Override
    public void LevelCheck(BankAccount ba){
    //Upgrade to platinum    
        if(ba.getBalance() >= 20000){
            AccountLevel plat = new PlatinumLevel(ba);
            ba.setLevel(plat);
        }
    //Upgrade to gold
        else if ((ba.getBalance() < 20000) && (ba.getBalance() >= 10000)){
            AccountLevel gold = new GoldLevel(ba);
            ba.setLevel(gold);
        }  
    }
}
