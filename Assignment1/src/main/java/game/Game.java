package game;

import maps.*;

/**
 * Main game class that demonstrates the Factory Method pattern.
 */
public class Game {

    /**
     * Factory method to create a map.
     */
    public static Map createMap(int mapType) {
        if (mapType == 1) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }

    public static void main(String[] args) {
        // Create and display a city map
        Map gameMap = createMap(1);
        gameMap.display();
    }
}
