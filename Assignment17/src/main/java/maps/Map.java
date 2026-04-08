package maps;

import tiles.Tile;

public abstract class Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;

    protected Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
    }

    // Factory Method implemented by concrete map types.
    protected abstract Tile createTile();

    protected void generateMap() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tiles[row][col] = createTile();
            }
        }
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

