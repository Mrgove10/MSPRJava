package com.recycl.dashboard.front.controllers;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.skins.BarChartItem;
import javafx.fxml.FXML;

public class MainController {
    private static final double TILE_SIZE = 150;
    @FXML
    public Tile testTileFX;
    private BarChartItem barChartItem1 = new BarChartItem("mark", 47, Tile.BLUE);
    private BarChartItem barChartItem2 = new BarChartItem("Adrien", 47, Tile.RED);
    private BarChartItem barChartItem3 = new BarChartItem("edouard", 47, Tile.GREEN);
    private BarChartItem barChartItem4 = new BarChartItem("lou", 47, Tile.ORANGE);

    @FXML
    private void initialize() {
        System.out.println("I");
        SetStyle();
    }

    private void SetStyle() {
        System.out.println("ss");
        barChartItem1.setFormatString("%.2f");
        barChartItem2.setFormatString("%.2f");
        barChartItem3.setFormatString("%.2f");
        barChartItem4.setFormatString("%.2f");

        testTileFX.setPrefSize(TILE_SIZE, TILE_SIZE);
        testTileFX.setTitle("BarChart Tile");
        testTileFX.setText("Whatever text");
        testTileFX.setBarChartItems(barChartItem1, barChartItem2, barChartItem3, barChartItem4);
        testTileFX.setDecimals(0);
    }

}
