package coe528.project;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.shape.*;
import javafx.scene.effect.*;
import javafx.scene.control.*;
import javafx.scene.control.Button.*;
import javafx.scene.layout.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

/**
 *This class calls the main menu
 * application, where the whole 
 * program starts
 * @author victoriasipinkarovski
 */
public class MainMenu extends Application{    


    @Override
    public void start(Stage stage) throws Exception {
       
       //!! how FXML is accesed!!
        FXMLLoader menu = new FXMLLoader();
        menu.setLocation(getClass().getResource("/coe528/project/Main.fxml"));
       
    //Creates this as the parent class to be loaded
        Parent load = menu.load(); 

        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.setTitle("Bank of Dollar Bills");
        stage.show();

    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);

    }
}