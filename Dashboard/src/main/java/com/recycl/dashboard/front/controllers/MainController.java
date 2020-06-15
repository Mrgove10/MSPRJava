package com.recycl.dashboard.front.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;


public class MainController {
    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;

    @FXML
    private void initialize() {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("Item.fxml")));

                //give the items some effect

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #1620A1");
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #53639F");
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #02030A");
            pnlOverview.toFront();
        }
        if(actionEvent.getSource()==btnOrders)
        {
            pnlOrders.setStyle("-fx-background-color : #464F67");
            pnlOrders.toFront();
        }
    }
    /*@FXML
    public Tile testTileFX;

    private static final double TILE_SIZE = 150;

    Random rand = new Random();


    private final BarChartItem barChartItem1 = new BarChartItem("mark", rand.nextInt(100), Tile.BLUE);
    private final BarChartItem barChartItem2 = new BarChartItem("Adrien",  rand.nextInt(100), Tile.RED);
    private final BarChartItem barChartItem3 = new BarChartItem("edouard",  rand.nextInt(100), Tile.GREEN);
    private final BarChartItem barChartItem4 = new BarChartItem("lou",  rand.nextInt(100), Tile.ORANGE);

    @FXML
    private void initialize() {
        barChartItem1.setFormatString("%.2f");
        barChartItem2.setFormatString("%.2f");
        barChartItem3.setFormatString("%.2f");
        barChartItem4.setFormatString("%.2f");

        testTileFX.setPrefSize(TILE_SIZE, TILE_SIZE);
        testTileFX.setTitle("BarChart Tile");
        testTileFX.setText("Whatever text");
        testTileFX.setBarChartItems(barChartItem1, barChartItem2, barChartItem3, barChartItem4);
        testTileFX.setDecimals(0);
    }*/
}
