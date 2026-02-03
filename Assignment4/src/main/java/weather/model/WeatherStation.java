package weather.model;

import java.util.Random;

public class WeatherStation extends Observable implements Runnable {
    private static final double MIN_TEMPERATURE = -30.0;
    private static final double MAX_TEMPERATURE = 50.0;
    private static final double TEMPERATURE_CHANGE = 1.0;
    private static final int MIN_UPDATE_INTERVAL = 1000; // 1 second
    private static final int MAX_UPDATE_INTERVAL = 5000; // 5 seconds

    private double temperature;
    private Random random;
    private volatile boolean running = true;

    public WeatherStation() {
        random = new Random();
        // Set initial random temperature
        temperature = MIN_TEMPERATURE + (MAX_TEMPERATURE - MIN_TEMPERATURE) * random.nextDouble();
        System.out.printf("Weather Station initialized with temperature: %.1f°C%n", temperature);
    }

    public double getTemperature() {
        return temperature;
    }

    private void updateTemperature() {
        // Randomly increase or decrease temperature
        double change = random.nextBoolean() ? TEMPERATURE_CHANGE : -TEMPERATURE_CHANGE;
        double newTemperature = temperature + change;

        // Ensure temperature stays within bounds
        if (newTemperature < MIN_TEMPERATURE) {
            temperature = MIN_TEMPERATURE;
        } else if (newTemperature > MAX_TEMPERATURE) {
            temperature = MAX_TEMPERATURE;
        } else {
            temperature = newTemperature;
        }

        // Notify observers about the change
        notifyObservers();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                // Random sleep interval between 1-5 seconds
                int sleepTime = MIN_UPDATE_INTERVAL + random.nextInt(MAX_UPDATE_INTERVAL - MIN_UPDATE_INTERVAL);
                Thread.sleep(sleepTime);

                // Update temperature
                updateTemperature();
            } catch (InterruptedException e) {
                System.out.println("Weather station thread interrupted");
                break;
            }
        }
        System.out.println("Weather station stopped");
    }
}
