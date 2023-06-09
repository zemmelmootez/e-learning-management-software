package com.example.projet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Chat {
    Chat(){

}
 public  HBox Chatshow(){
        HBox hb=new HBox();
        TextField msg=new TextField();


        Button btn=new Button("send message");


        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Ecriture.Test(msg.getText());

            }

        });
        hb.getChildren().addAll(msg,btn);
        return hb;
    }
}
