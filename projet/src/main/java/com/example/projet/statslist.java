package com.example.projet;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class statslist {
    public VBox statsVbox(){

        Image img = new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Search.png");
        HBox hbox=new HBox();

        Label CoursesList=new Label("Statistics");
        TextField searchText=new TextField();
        searchText.setPromptText("Search");
        searchText.setStyle("-fx-background-color: transparent; -fx-background-insets: 0; -fx-border-width: 0;");
        searchText.setBorder(Border.EMPTY);

        HBox hsearch=new HBox();
        ImageView isearch=new ImageView(img);
        hsearch.setStyle("-fx-background-insets: 20;-fx-border-color:#B5D6F6; -fx-border-width: 1;-fx-border-radius:20");
        hsearch.setAlignment(Pos.CENTER);
        isearch.setFitWidth(12);
        hsearch.setPadding(new Insets(5));
        isearch.setPreserveRatio(true);
        hsearch.getChildren().addAll(isearch,searchText);

        CoursesList.setTextFill(Paint.valueOf("#717171"));
        CoursesList.setFont(new Font("Arial",20));

        hbox.getChildren().addAll(CoursesList,hsearch);
        hbox.setSpacing(400);
        hbox.setAlignment(Pos.CENTER);

// partie centre
        VBox vbox = new VBox();

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(30);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(30);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4);

// Add nodes to the grid
        gridPane.add(new Label("Cours Name"), 0, 0);
        gridPane.add(new Label("Number of Enrollement"), 1, 0);
        gridPane.add(new Label("Graduated Student"), 2, 0);
        gridPane.add(new Label("Action"), 3, 0);



        //implementation graphique



        Connection con=ConnectionDataBase.connect();
        int i=0;
        ResultSet rs;
        try {
            PreparedStatement st=con.prepareStatement("select name,total_students,students_graduated from courses");
          rs=st.executeQuery();
            while (rs.next()){
                i++;
                gridPane.add(new Label(rs.getString(1)), 0, i);
                gridPane.add(new Label(rs.getString(2)), 1, i);
                gridPane.add(new Label(rs.getString(3)), 2, i);
                ImageView Action = new ImageView(new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\action.png"));

                int total=rs.getInt(2);
                int graduated=rs.getInt(3);
                Action.setOnMouseClicked(event -> {
                    actionstage actionstage=new actionstage();


                        actionstage.actionStage(total,graduated);



                });
                gridPane.add(Action, 3, i);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }



        gridPane.setPadding(new Insets(30,0,0,100));

        gridPane.setHgap(60);
        gridPane.setVgap(10);



        hbox.setAlignment(Pos.TOP_RIGHT);
        vbox.setSpacing(14);
        vbox.getChildren().addAll(hbox, gridPane);

        return vbox;




    }

}
