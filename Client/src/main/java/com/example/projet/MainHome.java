package com.example.projet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainHome {
    static BorderPane bd;
    Button students;
    public Scene startHome () throws FileNotFoundException {

        Client c=new Client();
        c.main();

        VBox vb=new VBox();
        vb.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));




        Scene scene = new Scene(vb, 1000, 600);

        scene.getStylesheets().add("style.css");


        vb.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Image img=new Image(new FileInputStream("C:\\Users\\ASUS\\Desktop\\projet\\Client\\src\\main\\resources\\logo.png"));

        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(240);
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        bd=new BorderPane();
        VBox buttonContainer=new VBox();


        Button chat=new Button("chat");

          Image imageChat=new Image("C:\\Users\\ASUS\\Desktop\\projet\\Client\\src\\main\\resources\\chat.png");

          bd.setLeft(buttonContainer);
        ImageView chatImageView=new ImageView(imageChat);

        chatImageView.setFitWidth(20);
        chatImageView.setFitHeight(20);
        chat.setGraphic(chatImageView);
        buttonContainer.getChildren().add(chat);

        vb.getChildren().addAll(imageView,bd);

        chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


              ChatClass c=new ChatClass();
               bd.setCenter(c.chatScreen());
               bd.setBottom(new Chat().Chatshow());
            }
        });



        return scene;


    }

    public  static  void refresh_chat(){
        ChatClass c=new ChatClass();
        bd.setCenter(c.chatScreen());
    }
    public static void Add_content(String ch){

        bd.setCenter(new Label(ch));
    }

}