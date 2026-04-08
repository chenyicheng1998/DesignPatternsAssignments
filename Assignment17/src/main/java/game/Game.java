package game;

import graphics.TileGraphic;
import graphics.TileGraphicFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import maps.CityMap;
import maps.Map;
import maps.WildernessMap;
import tiles.Tile;

public class Game extends Application {
    private static final int TILE_SIZE = 32;
    private static final int MAP_WIDTH = 30;
    private static final int MAP_HEIGHT = 18;

    @Override
    public void start(Stage stage) {
        Map map = createMap();

        TileGraphicFactory graphicFactory = new TileGraphicFactory();
        Canvas canvas = new Canvas(map.getWidth() * TILE_SIZE, map.getHeight() * TILE_SIZE);
        drawMap(canvas.getGraphicsContext2D(), map, graphicFactory);

        System.out.println("Generated map type: " + map.getClass().getSimpleName());
        System.out.println("Shared tile graphics in cache: " + graphicFactory.getSharedGraphicCount());

        stage.setTitle("RPG Map - Factory Method + Flyweight");
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
    }

    private Map createMap() {
        if (Math.random() < 0.5) {
            return new CityMap(MAP_WIDTH, MAP_HEIGHT);
        }
        return new WildernessMap(MAP_WIDTH, MAP_HEIGHT);
    }

    private void drawMap(GraphicsContext gc, Map map, TileGraphicFactory graphicFactory) {
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                Tile tile = map.getTile(row, col);
                TileGraphic tileGraphic = graphicFactory.getGraphic(tile.getType());
                // row/col coordinates are extrinsic state used during rendering.
                tileGraphic.render(gc, col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
