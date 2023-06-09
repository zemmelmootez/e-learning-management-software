package com.example.projet;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Scanner;

public class ChatClass {

    public VBox vb=new VBox();
    public static Label c;

    public VBox chatScreen(){


        String data = null;
        File myObj = new File("C:\\Users\\ASUS\\Desktop\\projet\\projet\\src\\main\\java\\com\\example\\projet\\chat.txt");
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data += myReader.nextLine()+"\n";

        }
        myReader.close();




        c=new Label(data);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        MainHome.refresh_chat();
                    }
                });
            }
        }).start();








        vb.getChildren().addAll(c);

        return vb;

    }


}
