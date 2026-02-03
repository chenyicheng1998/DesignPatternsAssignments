package weather;

import weather.model.WeatherStation;
import weather.view.WeatherObserver;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Weather Station Simulator ===\n");

        // Create weather station
        WeatherStation weatherStation = new WeatherStation();

        // Create observers
        WeatherObserver observer1 = new WeatherObserver("Observer 1 - Phone App", weatherStation);
        WeatherObserver observer2 = new WeatherObserver("Observer 2 - Desktop Widget", weatherStation);
        WeatherObserver observer3 = new WeatherObserver("Observer 3 - Smart Watch", weatherStation);

        // Register observers
        weatherStation.addObserver(observer1);
        weatherStation.addObserver(observer2);
        weatherStation.addObserver(observer3);

        System.out.println("\nAll observers registered. Starting weather station...\n");

        // Start weather station thread
        Thread weatherThread = new Thread(weatherStation);
        weatherThread.start();

        // Let the simulation run for 15 seconds
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        // Remove one observer
        System.out.println("\n=== Removing Observer 2 - Desktop Widget ===\n");
        weatherStation.removeObserver(observer2);

        // Let the simulation continue for another 15 seconds
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        // Stop the weather station
        System.out.println("\n=== Stopping Weather Station ===");
        weatherStation.stop();

        // Wait for the thread to finish
        try {
            weatherThread.join();
        } catch (InterruptedException e) {
            System.err.println("Error waiting for weather thread: " + e.getMessage());
        }

        System.out.println("\nSimulation completed.");
    }
}
