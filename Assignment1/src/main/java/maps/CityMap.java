package maps;

import tiles.*;
import java.util.Random;

public class CityMap extends Map {
    private final Random random = new Random();

    public CityMap() {
        super();
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            default:
                return new BuildingTile();
        }
    }
}
