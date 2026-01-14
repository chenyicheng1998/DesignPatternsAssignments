package tiles;

/**
 * Abstract class representing a tile on the map.
 */
public abstract class Tile {

    public abstract char getCharacter();

    public abstract String getType();

    public abstract void action();
}
