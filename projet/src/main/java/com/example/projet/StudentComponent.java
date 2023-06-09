package com.example.projet;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class StudentComponent {
    Connection con;

    public void DeleteOne(int id,int idc){

        try {
            PreparedStatement st=con.prepareStatement("delete from enrollments where student_id="+id+" and course_id="+idc);
          int a=  st.executeUpdate();
            if (a > 0) {
                // Show a success message
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                successAlert.setHeaderText(null);
                successAlert.setContentText("student enrollement deleted successfully!");
                successAlert.showAndWait();
                MainHome.refresh_student();
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editone(int id,String enroll_date){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Edit student");
        alert.getDialogPane().setHeader(null);
        alert.setHeaderText(null);
        alert.setContentText(null);
        alert.getDialogPane().setGraphic(null);

        Label courseLabel = new Label("Student Name:");
        courseLabel.setStyle("-fx-font-size: 17px");
        TextField courseTextField = new TextField();
        courseTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
        courseTextField.setPromptText("Enter name");
        courseTextField.setMinHeight(30);

        Label instructorLabel = new Label("Student Email:");
        instructorLabel.setStyle("-fx-font-size: 17px");
        TextField instructorTextField = new TextField();
        instructorTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
        instructorTextField.setPromptText("Enter Email");
        instructorTextField.setMinHeight(30);

        // Create submit button
        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-background-color: #56A2EC;-fx-text-fill: #FFFFFF; -fx-font-size: 17px");
        // Create layout and add components
        VBox layout = new VBox();
        Label coursechoice = new Label("choose your course:");
        coursechoice.setStyle("-fx-font-size: 17px");
        var options = FXCollections.observableArrayList(

        );

        try {
            PreparedStatement st=con.prepareStatement("select name from courses");
            ResultSet rs=st.executeQuery();
            while (rs.next()){

                options.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // Create the ComboBox and set its options
        var comboBox = new ComboBox<>(options);

        comboBox.setValue(comboBox.getItems().get(0));
        submitButton.setOnAction(actionEvent1 ->
                {

                    int course_id= comboBox.getSelectionModel().getSelectedIndex()+1;
                    try {

                        PreparedStatement st=con.prepareStatement("update students set name=? , email=? where id=?");
                        st.setString(1,courseTextField.getText());
                        st.setString(2,instructorTextField.getText());
                        st.setInt(3,id);
                        System.out.println(courseTextField.getText()+instructorTextField.getText()+ id);

                          st.executeUpdate();
                        st=con.prepareStatement("SELECT id FROM students ORDER BY id DESC LIMIT 1;");

                        ResultSet rs=st.executeQuery();
                        rs.next();
                        int a=rs.getInt(1);

                        st=con.prepareStatement("update enrollments set course_id=? where student_id=? and enroll_date=?");
                        LocalDate currentDate = LocalDate.now();

                        st.setInt(1,course_id);
                        st.setInt(2,id);
                        st.setString(3, enroll_date);
                      int aa=  st.executeUpdate();
                        if (a > 0) {
                            // Show a success message
                            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                            successAlert.setHeaderText(null);
                            successAlert.setContentText("student updated successfully!");
                            successAlert.showAndWait();
                            MainHome.refresh_student();
                        }






                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        );


        layout.setSpacing(10);
        layout.setPadding(new Insets(20, 30, 20, 30));
        layout.setPrefHeight(200);


        layout.getChildren().addAll(courseLabel, courseTextField,
                instructorLabel, instructorTextField,coursechoice,comboBox,
                submitButton);

        // Set layout properties

        layout.setAlignment(Pos.CENTER_LEFT);

        layout.setStyle("-fx-background-color: white; -fx-border-radius: 9px; -fx-border-color: #c9c9c9; -fx-border-width: 1px;");

        // Create the alert dialog
        alert.getDialogPane().setContent(layout);
        alert.showAndWait();



    }
    public VBox StudentVbox(){


        Image img = new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Search.png");
        HBox hbox=new HBox();

        Label CoursesList=new Label("Courses List");
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
        hbox.setAlignment(Pos.TOP_RIGHT);
        HBox hbutton=new HBox();
        Button Consult=new Button("Add Student");
        Consult.setStyle("-fx-background-color:#56A2EC;-fx-text-fill:white;");
        hbutton.getChildren().addAll(Consult);
        hbutton.setPadding(new Insets(20));
        hbutton.setAlignment(Pos.TOP_RIGHT);
// partie centre
        VBox vbox = new VBox();

        GridPane gridPane = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(20);
        ColumnConstraints col5 = new ColumnConstraints();
        col4.setPercentWidth(20);
        gridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5);

// Add nodes to the grid
        gridPane.add(new Label("Name"), 0, 0);
        gridPane.add(new Label("Email"), 1, 0);
        gridPane.add(new Label("Course"), 2, 0);
        gridPane.add(new Label("Enrollement date"), 3, 0);

        ScrollPane sc=new ScrollPane(gridPane);

        sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sc.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sc.setPadding(Insets.EMPTY);
        gridPane.setBackground(Background.fill(Paint.valueOf("white")));
        sc.setBackground(new Background(new BackgroundFill(Paint.valueOf("white"),CornerRadii.EMPTY,Insets.EMPTY)));
        //implementation graphique
        con=ConnectionDataBase.connect();
        int i=0;
        try {
            PreparedStatement st=con.prepareStatement(
                    "SELECT students.name,students.email,courses.name,enrollments.enroll_date,students.id,courses.id\n" +
                            "from students,enrollments,courses\n" +
                            "where students.id=enrollments.student_id and courses.id=enrollments.course_id");

            ResultSet rs=st.executeQuery();
            while(rs.next()){
                i++;
                gridPane.add(new Label(rs.getString(1)), 0, i);
                gridPane.add(new Label(rs.getString(2)), 1, i);
                gridPane.add(new Label(rs.getString(3)), 2, i);
                gridPane.add(new Label(rs.getString(4)), 3, i);
                HBox edit = new HBox();
                 ImageView editimg = new ImageView(new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\Edit.png"));

                ImageView supimg = new ImageView(new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\sup.png"));
                int id=rs.getInt(5);
                int idc=rs.getInt(6);
                String enroll_date=rs.getString(4);
                supimg.setOnMouseClicked(mouseEvent -> DeleteOne(id,idc));

                editimg.setOnMouseClicked(MouseEvent->{
                    editone(id,enroll_date);
                });


                edit.getChildren().addAll( editimg,supimg);
                edit.setSpacing(10);
                gridPane.add(edit, 4, i);
            }

           } catch (SQLException e) {
            e.printStackTrace();
        }



        gridPane.setPadding(new Insets(0,0,0,100));

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        vbox.setSpacing(14);
        vbox.getChildren().addAll(hbox,hbutton, sc);

        Consult.setOnAction(actionEvent ->
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("add student");
            alert.getDialogPane().setHeader(null);
            alert.setHeaderText(null);
            alert.setContentText(null);
            alert.getDialogPane().setGraphic(null);

            Label courseLabel = new Label("Student Name:");
            courseLabel.setStyle("-fx-font-size: 17px");
            TextField courseTextField = new TextField();
            courseTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
            courseTextField.setPromptText("Enter name");
            courseTextField.setMinHeight(30);

            Label instructorLabel = new Label("Student Email:");
            instructorLabel.setStyle("-fx-font-size: 17px");
            TextField instructorTextField = new TextField();
            instructorTextField.setStyle("-fx-background-radius: 9px; -fx-background-color: #EDEDED;-fx-text-fill: black ;-fx-font-size: 15px;");
            instructorTextField.setPromptText("Enter Email");
            instructorTextField.setMinHeight(30);

            // Create submit button
            Button submitButton = new Button("Submit");
            submitButton.setStyle("-fx-background-color: #56A2EC;-fx-text-fill: #FFFFFF; -fx-font-size: 17px");
            // Create layout and add components
            VBox layout = new VBox();
            Label coursechoice = new Label("choose your course:");
            coursechoice.setStyle("-fx-font-size: 17px");
            var options = FXCollections.observableArrayList(

            );

            try {
                PreparedStatement st=con.prepareStatement("select name from courses");
                ResultSet rs=st.executeQuery();
                while (rs.next()){

                    options.add(rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            // Create the ComboBox and set its options
            var comboBox = new ComboBox<>(options);

            comboBox.setValue(comboBox.getItems().get(0));
            submitButton.setOnAction(actionEvent1 ->
                    {

                        int course_id= comboBox.getSelectionModel().getSelectedIndex()+1;
                        try {
                            PreparedStatement st=con.prepareStatement("insert into students (name,email,graduation_status) values(?,?,'false')");
                            st.setString(1,courseTextField.getText());
                            st.setString(2,instructorTextField.getText());

                            st.executeUpdate();
                            st=con.prepareStatement("SELECT id FROM students ORDER BY id DESC LIMIT 1;");

                            ResultSet rs=st.executeQuery();
                            rs.next();
                            int a=rs.getInt(1);

                            st=con.prepareStatement("insert into enrollments (student_id,course_id,enroll_date) values(?,?,?)");
                            LocalDate currentDate = LocalDate.now();

                            st.setInt(1,a);
                            st.setInt(2,course_id);
                            st.setString(3, currentDate.toString());
                           int aaa= st.executeUpdate();
                            if (aaa > 0) {
                                // Show a success message
                                Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                                successAlert.setHeaderText(null);
                                successAlert.setContentText("student added successfully!");
                                successAlert.showAndWait();
                                MainHome.refresh_student();

                            }


                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    );


            layout.setSpacing(10);
            layout.setPadding(new Insets(20, 30, 20, 30));
            layout.setPrefHeight(200);


            layout.getChildren().addAll(courseLabel, courseTextField,
                    instructorLabel, instructorTextField,coursechoice,comboBox,
                    submitButton);

            // Set layout properties

            layout.setAlignment(Pos.CENTER_LEFT);

            layout.setStyle("-fx-background-color: white; -fx-border-radius: 9px; -fx-border-color: #c9c9c9; -fx-border-width: 1px;");

            // Create the alert dialog
            alert.getDialogPane().setContent(layout);
            alert.showAndWait();

        }
        );

            return vbox;




    }
}
