package maps;

import tiles.BuildingTile;
import tiles.ForestTile;
import tiles.RoadTile;
import tiles.Tile;

import java.util.Random;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int tileType = random.nextInt(3);
        return switch (tileType) {
            case 0 -> new RoadTile();
            case 1 -> new ForestTile();
            default -> new BuildingTile();
        };
    }
}
