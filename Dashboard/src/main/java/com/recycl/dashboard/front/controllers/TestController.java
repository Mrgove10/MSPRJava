package com.recycl.dashboard.front.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.TableView;
import org.controlsfx.control.MasterDetailPane;
import org.controlsfx.control.PropertySheet;

public class TestController {
    @FXML
    private void initialize() {
        MasterDetailPane pane = new MasterDetailPane();
        pane.setMasterNode(new TableView());
        pane.setDetailNode(new PropertySheet());
        pane.setDetailSide(Side.RIGHT);
        pane.setShowDetailNode(true);
    }
}
