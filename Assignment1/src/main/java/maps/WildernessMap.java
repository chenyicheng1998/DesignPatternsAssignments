package maps;

import tiles.*;
import java.util.Random;

public class WildernessMap extends Map {
    private final Random random = new Random();

    public WildernessMap() {
        super();
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int tileType = random.nextInt(3);
        switch (tileType) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            default:
                return new ForestTile();
        }
    }
}
