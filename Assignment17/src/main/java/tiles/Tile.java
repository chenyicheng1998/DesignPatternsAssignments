package tiles;

public abstract class Tile {
    private final TileType type;

    protected Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }
}

