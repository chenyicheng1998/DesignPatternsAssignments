package maps;

import tiles.Tile;

/**
 * Abstract class representing a game map.
 */
public abstract class Map {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;
    private Tile[][] tiles;

    public Map() {
        tiles = new Tile[WIDTH][HEIGHT];
    }

    /**
     * Factory Method: creates a tile of random type.
     */
    protected abstract Tile createTile();

    protected void generateMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                tiles[i][j] = createTile();
            }
        }
    }

    /**
     * Displays the map as a matrix of characters.
     */
    public void display() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(tiles[j][i].getCharacter() + " ");
            }
            System.out.println();
        }
    }
}
