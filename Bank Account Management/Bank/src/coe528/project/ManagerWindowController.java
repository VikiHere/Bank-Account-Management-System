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
 *FXML controller class for the manager window
 * @author victoriasipinkarovski
 */
public class ManagerWindowController implements Initializable {
 
    
    @FXML
    private Label adcustldl;
    @FXML
    private Label delcustlbl;
    @FXML
    private TextField newuserbox;
    @FXML
    private TextField newpassbox;
    @FXML
    private Label sysresp;
    @FXML
    private TextField delusername;
    @FXML
    private Button addconfirm;
    @FXML
    private Button delconfirm;

    /**
     *Method for when the add customer button is pressed,
     * once pressed the username and password inputted
     * will go through a series of checks before is added as
     * a customer under the manager and to the customer files
     * @param event
     * @throws IOException
     */
    @FXML
    public void addButton(ActionEvent event) throws IOException{
        String username = newuserbox.getText();
        String password = newpassbox.getText();
        int check = 0;
    
    //goes through the customers arraylist in manager and checks if there
        //already exists a customer with the promted username
        for(int i =0; i < MainController.manager.customers.size(); i++){
            if(username.equals(MainController.manager.customers.get(i).getUsername())){
            //if a username that is equa is found, then the check is set and 
                //will proceed to the below conditional checks
                check = 1;
            }
            else{
                check = 0;
            }
        }
        
        if(check == 1){
            sysresp.setText("Hey!\nThat username already exists\nPlease try another Username!");
        }
    //Making sure that the text fields are not empty
        else if(username == null || password == null || username.isEmpty() != false || password.isEmpty() != false){
            sysresp.setText("Invalid! \nPlease enter valid inputs");
        }
        else{
            MainController.manager.addCustomer(username, password);
            sysresp.setText("Customer Added!");
        }
    }
    
    /**
     *Method for when the delete customer button is clicked, once
     * clicked the customer with the promted username is removed
     * from the arraylist and customerfiles
     * @param event
     * @throws IOException
     */
    @FXML
    public void delButton(ActionEvent event) throws IOException{
        String username = delusername.getText();
        int check = 0;
        
        if(MainController.manager.customers.isEmpty() == true){
            sysresp.setText("Hey!\nThat user does not exist\nPlease try another Username!");
        }
        else{
            for(int i =0; i < MainController.manager.customers.size(); i++){
                if(username.equals(MainController.manager.customers.get(i).getUsername())){
                    check = 0;
                }
                else{
                    check = 1;
                }
            }

            if(check == 1){
                sysresp.setText("Hey!\nThat user does not exist\nPlease try another Username!");
            }
            else if(username == null || username.isEmpty() != false){
                sysresp.setText("Invalid! \nThis user does not exist\nPlease enter a existing Username");
            }
            else if (check == 0){
                MainController.manager.deleteCustomer(username);

                sysresp.setText("Customer Deleted!!");
            }
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
