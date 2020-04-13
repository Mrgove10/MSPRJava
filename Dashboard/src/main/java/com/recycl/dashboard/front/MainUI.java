package com.recycl.dashboard.front;

import com.recycl.dashboard.front.controllers.ScreenController;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.skins.BarChartItem;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class MainUI extends Application {

    private static final double TILE_SIZE = 150;
    private static final Random RND = new Random();
    private Tile barChartTile;
    private long lastTimerCall;
    private AnimationTimer timer;

    @Override
    public void init() {
        System.out.println("Starting UI");
        BarChartItem barChartItem1 = new BarChartItem("mark", 47, Tile.BLUE);
        BarChartItem barChartItem2 = new BarChartItem("Adrien", 47, Tile.RED);
        BarChartItem barChartItem3 = new BarChartItem("edouard", 47, Tile.GREEN);
        BarChartItem barChartItem4 = new BarChartItem("lou", 47, Tile.ORANGE);

        barChartItem1.setFormatString("%.2f");
        barChartItem2.setFormatString("%.2f");
        barChartItem3.setFormatString("%.2f");
        barChartItem4.setFormatString("%.2f");

        barChartTile = TileBuilder.create()
                .prefSize(TILE_SIZE, TILE_SIZE)
                .skinType(Tile.SkinType.BAR_CHART)
                .title("BarChart Tile")
                .text("Whatever text")
                .barChartItems(barChartItem1, barChartItem2, barChartItem3, barChartItem4)
                .decimals(0)
                .build();
        lastTimerCall = System.nanoTime();
        timer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                if (now > lastTimerCall + 1_000_000_000) {

                    barChartTile.getBarChartItems().get(RND.nextInt(3)).setValue(RND.nextDouble() * 80);

                    lastTimerCall = now;
                }
            }
        };
    }

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
            Scene scene = new Scene(root, 640, 480);


           /* Scene scene = new Scene(root, 640, 480);

            stage.setScene(scene);
            stage.show();
            timer.start();*/

            ScreenController screenController = new ScreenController(scene);
            // screenController.addScreen("login", FXMLLoader.load(getClass().getResource("login.fxml")));
            //  screenController.addScreen("main", FXMLLoader.load(getClass().getResource( "main.fxml" )));
            // screenController.addScreen("test", FXMLLoader.load(getClass().getResource( "test.fxml" )));
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

