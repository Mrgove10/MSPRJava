package com.recycl.dashboard.front.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.controlsfx.control.MasterDetailPane;

public class MainController {
    @FXML
    private void initialize() {
        MasterDetailPane pane = new MasterDetailPane();
    }

    public void handleButtonR1(ActionEvent actionEvent) {
        System.out.println("Button 1 clicked");
    }

    public void handleButtonR2(ActionEvent actionEvent) {
        System.out.println("Button 2 clicked");
    }

    public void handleButtonR3(ActionEvent actionEvent) {
        System.out.println("Button 3 clicked");
    }

    public void handleButtonR4(ActionEvent actionEvent) {
        System.out.println("Button 4 clicked");
    }

    public void handleButtonR5(ActionEvent actionEvent) {
        System.out.println("Button 5 clicked");
    }

    public void handleButtonR6(ActionEvent actionEvent) {
        System.out.println("Button 6 clicked");
    }

    public void handleButtonR7(ActionEvent actionEvent) {
        System.out.println("Button 7 clicked");
    }

    public void handleButtonR8(ActionEvent actionEvent) {
        System.out.println("Button 8 clicked");
    }

    public void handleButtonR9(ActionEvent actionEvent) {
        System.out.println("Button 9 clicked");
    }
}
