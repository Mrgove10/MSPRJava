package com.recycl.dashboard;

import com.recycl.dashboard.back.MainBDD;
import com.recycl.dashboard.front.helpers.AlertHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

public class Main extends Application {
    public static void main(String[] args) throws SQLException, ParseException {
        MainBDD bdd = new MainBDD();
       // bdd.startBDD();
        launch(args); //Comment this to deactivate the UI
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("RECYCL Dashboard");
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
            Scene scene = new Scene(root, 400, 250);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            AlertHelper.showAlert(Alert.AlertType.ERROR, primaryStage, "Error", e.toString());
        }
    }
}



