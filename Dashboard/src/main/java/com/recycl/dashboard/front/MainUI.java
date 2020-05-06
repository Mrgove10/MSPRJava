package com.recycl.dashboard.front;

import com.recycl.dashboard.front.controllers.ScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainUI extends Application {

    @Override
    public void init() {
        System.out.println("Starting UI");
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("login.fxml")));
            Scene scene = new Scene(root, 1600, 900);
            ScreenController screenController = new ScreenController(scene);
            screenController.activate("login");

        } catch (Exception ex) {
            System.out.println(ex);
            stop();
        }
    }

    @Override
    public void stop() {
        System.exit(0);
    }
}

