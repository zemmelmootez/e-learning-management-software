package com.example.projet;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class studentslist  {


    public BorderPane StudentSCREEN() {
        BorderPane borderPane = new BorderPane();
        borderPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        Image logo = new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\logo.png");
        Image img = new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Search.png");
        ImageView imageView = new ImageView(logo);
        imageView.setFitWidth(170);
        imageView.setFitHeight(130);
        imageView.setPreserveRatio(true);
        Label list = new Label("Students List");
        list.setFont(Font.font("poppins", 25));
        list.setTextFill(Color.valueOf("#717171"));
        list.setPadding(new Insets(10, 0, 0, 0));

        TextField search = new TextField();
        search.setPromptText("Search");
        ImageView searchIcon = new ImageView(img);
        BorderPane searchbar = new BorderPane();
        searchbar.setLeft(searchIcon);
        searchbar.setRight(search);
        searchbar.setPadding(new Insets(10, 0, 0, 0));
        search.setMinHeight(35);
        search.setMinWidth(200);
        search.setStyle("-fx-background-radius: 34px; -fx-text-fill:#999999;-fx-border-color: #B5D6F6;-fx-border-radius:34 ;-fx-prompt-text-fill:#999999  ;-fx-font-size: 14px;");


        HBox seachb = new HBox();
        seachb.getChildren().addAll(searchbar);

        HBox hbox = new HBox();
        hbox.setSpacing(250);
        hbox.getChildren().addAll(imageView, list, seachb);


        borderPane.setTop(hbox);
        //partie centre
        VBox vbox = new VBox();
        Button add = new Button("Add Student");
        add.setMinHeight(50);
        add.setMinWidth(50);
        add.setTextFill(Color.WHITE);
        add.setFont(Font.font("poppins", 15));
        add.setBackground(new Background(new BackgroundFill(Color.valueOf("#56A2EC"), CornerRadii.EMPTY, Insets.EMPTY)));


        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(15);
        ColumnConstraints col5 = new ColumnConstraints();
        col4.setPercentWidth(10);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

// Add nodes to the grid
        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Email"), 1, 0);
        gridPane.add(new Label("Course"), 2, 0);
        gridPane.add(new Label("Subscription Date"), 3, 0);

        HBox edit = new HBox();
        ImageView editimg = new ImageView(new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Edit.png"));
        ImageView supimg = new ImageView(new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\sup.png"));
        edit.getChildren().addAll(editimg, supimg);

        //implementation graphique
        gridPane.add(new Label("John Doe"), 0, 1);
        gridPane.add(new Label("johndoe@example.com"), 1, 1);
        gridPane.add(new Label("Java Programming"), 2, 1);
        gridPane.add(new Label("2022-03-30"), 3, 1);
        gridPane.add(edit, 4, 1);


        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10));

        vbox.getChildren().addAll(add, gridPane);
        borderPane.setCenter(vbox);



        return borderPane;
    }
}
