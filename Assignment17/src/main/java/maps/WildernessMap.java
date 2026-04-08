package maps;

import tiles.ForestTile;
import tiles.SwampTile;
import tiles.Tile;
import tiles.WaterTile;

import java.util.Random;

public class WildernessMap extends Map {
    private final Random random = new Random();

    public WildernessMap(int width, int height) {
        super(width, height);
        generateMap();
    }

    @Override
    protected Tile createTile() {
        int tileType = random.nextInt(3);
        return switch (tileType) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }
}
