package coe528.project;

import java.util.Scanner;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.control.Control;
import javafx.scene.control.Labeled;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Button;


/**
 *
 * @author visipinka
 * This is the Main Portion of the Program
 */ 


public abstract class Main extends Application{
    
   /*
        In main the launch(args) calls start() here
    */ 
   @Override     
   public void start(Stage primaryStage) throws Exception { 
      /* 
      Code for JavaFX application. 
      (Stage, scene, scene graph) 
      */       
   }      
    
/*    
//Code Help taken from in class Week 10 JavaFX Lecture
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //launch(args);
        
    //Testing the Manager adding and deleting customer user/pass 
    BufferedWriter writer = null;  
    
    /*try {
         // create a BufferedWriter for the text file
         writer = new BufferedWriter(new FileWriter("passwords.txt"));

         // write text
         writer.write("Tudor");
         writer.newLine();
         writer.write("Tudorspassword");
         //etc.
    } catch (IOException e) {
        System.out.println("Failed to create file.");
        e.printStackTrace();
    } finally {
        if(writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                System.out.println("Failed to close file.");
                e.printStackTrace();
            }
        }
    }
    
        
    }*/

    
    
}
