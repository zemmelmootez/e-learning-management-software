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
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainHome {
    static BorderPane bd;
    Button students;
    public Scene startHome () throws FileNotFoundException {







        VBox vb=new VBox();
        vb.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));


        Image img=new Image(new FileInputStream("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\logo.png"));

        ImageView imageView = new ImageView(img);
        imageView.setFitHeight(240);
        imageView.setFitWidth(120);
        imageView.setPreserveRatio(true);

        bd=new BorderPane();
        VBox buttonContainer=new VBox();

        Button home=new Button(" Home");
        students=new Button(" Students");
        Button courses=new Button(" Courses");
        Button stats=new Button(" Stats");
        Button chat=new Button("chat");



        Image imageHome=new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Vector.png");
        Image imageStudents=new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Vector-1.png");
        Image imageCourses=new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Vector-2.png");
        Image imageStats=new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Vector-3.png");
        Image imageChat=new Image("C:\\Users\\ASUS\\Desktop\\projet\\projet\\src\\main\\resources\\chat.png");
        ImageView homeImageView=new ImageView(imageHome);


        ImageView chatImageView=new ImageView(imageChat);
        chatImageView.setFitWidth(20);
        chatImageView.setFitHeight(20);
        homeImageView.setFitWidth(20);
        homeImageView.setFitHeight(20);

        ImageView StudentsImageView=new ImageView(imageStudents);
        StudentsImageView.setFitWidth(20);
        StudentsImageView.setFitHeight(20);

        ImageView coursesImageView=new ImageView(imageCourses);
        coursesImageView.setFitWidth(20);
        coursesImageView.setFitHeight(20);

        ImageView statsImageView=new ImageView(imageStats);
        statsImageView.setFitWidth(20);
        statsImageView.setFitHeight(20);





        home.setGraphic(homeImageView);
        students.setGraphic(StudentsImageView);
        stats.setGraphic(statsImageView);
        courses.setGraphic(coursesImageView);

        chat.setGraphic(chatImageView);
        buttonContainer.setSpacing(12);
        buttonContainer.getChildren().addAll(home,students,courses,stats,chat);
        buttonContainer.setAlignment(Pos.BASELINE_LEFT);

        bd.setLeft(buttonContainer);

        HomeComponent h2=new HomeComponent();
        bd.setCenter(h2.homeVbox());

        vb.setPadding(new Insets(0,10,20,30));

        vb.getChildren().addAll(imageView,bd);
        Scene scene = new Scene(vb, 1000, 600);

        scene.getStylesheets().add("style.css");




        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HomeComponent homeComponent=new HomeComponent();
                bd.setCenter(homeComponent.homeVbox());

            }
        });


        chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


              ChatClass c=new ChatClass();
               bd.setCenter(c.chatScreen());
               bd.setBottom(new Chat().Chatshow());
            }
        });
        courses.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                CoursesComponent co=new CoursesComponent();


                bd.setCenter(co.coursesScreen());
            }
        });

        stats.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                statslist statslist=new statslist();
                bd.setCenter(statslist.statsVbox());
            }});
        students.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StudentComponent studentComponent=new StudentComponent();
                bd.setCenter(studentComponent.StudentVbox());
            }});


        return scene;


    }
    public static void refresh_student(){
        StudentComponent studentComponent=new StudentComponent();
        bd.setCenter(studentComponent.StudentVbox());

    }
    public  static  void refresh_chat(){
        ChatClass c=new ChatClass();
        bd.setCenter(c.chatScreen());
    }
    public static void Add_content(String ch){

        bd.setCenter(new Label(ch));
    }

}