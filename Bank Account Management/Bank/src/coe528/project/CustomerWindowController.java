package coe528.project;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *This is for the customer window
 * @author victoriasipinkarovski
 */
public class CustomerWindowController implements Initializable {

    @FXML
    private Label sysresp;
    @FXML
    private TextField withuser;
    @FXML
    private TextField depuser;
    @FXML
    private TextField puruser;
    
    Customer  customer ;
    double with, dep, temp;
    double online;

    /**
     *A method to call the customer from the manager's customer
     *  arraylist 
     * @param username  - username of Customer
     */
    public void openCustomer(String username) {
        customer = MainController.manager.getCustomerFromArrayList(username);
    }
    
    /**
     *Method for when the Get Level button is clicked
     * @param event 
     * @throws IOException
     */
    @FXML
    public void levelButton(ActionEvent event) throws IOException{
        System.out.println(customer.getLevel());
        sysresp.setText("Current Level: \n" + customer.getLevel());
    }               
    
    /**
     *Method for when the get balance button is clicked
     * @param event
     * @throws IOException
     */
    @FXML
    public void balanceButton(ActionEvent event) throws IOException{
        sysresp.setText("Current Balance: \n" + customer.getBalance());
    }               
    
    /**
     *Method for when the online purchase button is clicked, here
     *  the customer enters a value as the online purchase amount
     * @param event
     * @throws IOException
     */
    @FXML
    public void onlinePurchaseButton(ActionEvent event) throws IOException{
        try{
            online = Double.parseDouble(puruser.getText());
            if(online < 50){
                sysresp.setText("Value Over 50$ please.\nTransaction not authorized.");
            }
            //if online purchase is higher than the balance in the customer's account
            else if (online > 50 && online > customer.getBalance()){
                sysresp.setText("Online Purchase is too large!\nNot enough Funds to buy this");
            }
            else{
                customer.onlinePurchase(online);
            }
        }catch (NumberFormatException e) {
            sysresp.setText("Oops!\nSeems like you did not enter proper number.\nPlease enter a proper number!");
        }
    }               
    
    /**
     *Method for when the deposit method is clicked, here the customer
     * inputs the amount they want to put into their account.
     * @param event
     * @throws IOException
     */
    @FXML
    public void depositButton(ActionEvent event) throws IOException{
        try{
            dep = Double.parseDouble(depuser.getText());
            if(dep < 0){
                sysresp.setText("Value Over 0$ please.");
            }
            else{
                customer.deposit(dep);
                sysresp.setText("Deposit Sucessfull!");
            }
        }catch (NumberFormatException e) {
            sysresp.setText("Oops!\nSeems like you did not enter proper number.\nPlease enter a proper number!");
        } 
    }               

    /**
     *Method for when the withdraw button is clicked, once clicked the customer
     * is able to take out the amount they want from their account.
     * @param event
     * @throws IOException
     */
    @FXML
    public void withdrawButton(ActionEvent event) throws IOException{
        try{
            with = Double.parseDouble(withuser.getText());
            if(with > customer.getBalance()){
                sysresp.setText("Not enough money in your account");
            }
            else if (with < 0){
                sysresp.setText("Not Valid amount to withdraw\nTry agian!");
            }
            else{
                customer.withdraw(with);
                sysresp.setText("Withdrawl Sucessfull!");
            }
        }catch (NumberFormatException e) {
            sysresp.setText("Oops!\nSeems like you did not enter proper number.\nPlease enter a proper number!");
        }   
    }           
    
    /**
     *Method for when the logout button is clicked, the customer 
     * is logged out and the user is returned to the main
     * menu.
     * @param event
     * @throws IOException
     */
    @FXML
    public void logoutButton(ActionEvent event) throws IOException{
    //want to go back to the main menu
        FXMLLoader mm = new FXMLLoader();
        mm.setLocation(getClass().getResource("/coe528/project/Main.fxml"));
        Parent temp = mm.load();
        
        Scene scene = new Scene(temp);
        MainController m = mm.getController();
        //setting the stage
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            
        stage.setScene(scene);
        stage.setTitle("Bank of DollarBills");
        stage.show();
    }       
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
