package com.recycl.dashboard;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.skins.BarChartItem;
import eu.hansolo.tilesfx.tools.FlowGridPane;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    private static final double TILE_SIZE = 150;
    private static final Random RND = new Random();
    private BarChartItem barChartItem1;
    private Tile barChartTile;
    private AnimationTimer timer;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() {

        barChartItem1 = new BarChartItem("Gerrit", 47, Tile.BLUE);

        barChartItem1.setFormatString("%.2f");

        barChartTile = TileBuilder.create()
                .prefSize(TILE_SIZE, TILE_SIZE)
                .skinType(Tile.SkinType.BAR_CHART)
                .title("BarChart Tile")
                .text("Whatever text")
                .barChartItems(barChartItem1/*, barChartItem2, barChartItem3, barChartItem4*/)
                .decimals(0)
                .build();
        barChartTile.getBarChartItems().get(0).setValue(RND.nextDouble() * 80);

    }

    @Override
    public void start(Stage stage) {

     /*   String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");*/

        FlowGridPane pane = new FlowGridPane(7, 6, barChartTile);


       // Scene scene = new Scene(new StackPane(l), 640, 480);
        Scene scene = new Scene(pane, 640, 480);
        stage.setTitle("TilesFX Dashboard using Medusa");
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() {
        System.exit(0);
    }
}



