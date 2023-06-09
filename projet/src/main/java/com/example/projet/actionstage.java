package com.example.projet;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class actionstage {
    public Stage actionStage(int total,int graduated){
        Stage secondaryStage = new Stage();
        secondaryStage.initModality(Modality.APPLICATION_MODAL);

        PieChart.Data slice1 = new PieChart.Data("Total students", total);
        PieChart.Data slice2 = new PieChart.Data("Graduated", graduated);
        PieChart.Data[] data = new PieChart.Data[]{slice1, slice2};
        PieChart pieChart = new PieChart(FXCollections.observableArrayList(data));



        VBox vbox = new VBox(pieChart);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        BorderPane pane = new BorderPane();
        pane.setCenter(vbox);
        Scene secondaryScene = new Scene(pane, 400, 400);
        secondaryStage.setScene(secondaryScene);
        secondaryStage.setTitle("diag chart");
        Image img=new Image("C:\\Users\\ASUS\\Downloads\\projet\\projet\\src\\main\\resources\\action.png");
        secondaryStage.getIcons().add(img);
        secondaryStage.showAndWait();
        return secondaryStage;

    }

}
