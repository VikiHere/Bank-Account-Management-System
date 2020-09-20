package coe528.project;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *Main menu controller class - this is where the 
 * main menu window is created
 * @author victoriasipinkarovski
 */
public class MainController implements Initializable {
 
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label labelStatus;
    @FXML
    private Button login;


    /**
     *When initiated the program, assigns ONE manager
     * for the whole program, and only this manager is 
     * referenced.
     */
    public static final Manager manager = new Manager();
    int temp;
    
    @FXML
    private void loginpress(ActionEvent event) throws IOException{
        //is user inputs admin admin as their username and password 
            //respectivley then will go to the manager window
        if(username.getText().equals("admin") && password.getText().equals("admin")){
            FXMLLoader mm = new FXMLLoader();
            mm.setLocation(getClass().getResource("/coe528/project/ManagerWindow.fxml"));
            Parent ml = mm.load();
            
            Scene scene = new Scene(ml);
            ManagerWindowController m = mm.getController();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Bank of DollarBills - Manager Window");
            stage.show();
        }
        //Seeing if customer exists - if it does will enter the customer
            //window
        else{
            for(int i = 0; i <manager.getCustomers().size(); i++){
                if(username.getText().equals(manager.getCustomers().get(i).getUsername()) && password.getText().equals(manager.getCustomers().get(i).getPassword())){
                    //User exists, move onto Customer window
                    FXMLLoader mm = new FXMLLoader();
                    mm.setLocation(getClass().getResource("/coe528/project/CustomerWindow.fxml"));
                    Parent ml = mm.load();

                    Scene scene = new Scene(ml);
                    CustomerWindowController m = mm.getController();
                    m.openCustomer(manager.getCustomers().get(i).getUsername());
                    Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();

                    stage.setScene(scene);
                    stage.setTitle("Bank of DollarBills - Customer Window");
                    stage.show();
                }
            }
        }
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
