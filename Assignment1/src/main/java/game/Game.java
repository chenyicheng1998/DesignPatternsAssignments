package game;

import maps.*;

/**
 * Main game class that demonstrates the Factory Method pattern.
 */
public class Game {

    public static void main(String[] args) {
        // Create and display a city map
        Map cityMap = new CityMap();
        cityMap.display();

        System.out.println();

        // Create and display a wilderness map
        Map wildernessMap = new WildernessMap();
        wildernessMap.display();
    }
}
