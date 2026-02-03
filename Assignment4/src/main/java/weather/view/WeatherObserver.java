package weather.view;

import weather.model.WeatherStation;

public class WeatherObserver implements Observer {
    private String observerName;
    private WeatherStation weatherStation;

    public WeatherObserver(String observerName, WeatherStation weatherStation) {
        this.observerName = observerName;
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        double currentTemperature = weatherStation.getTemperature();
        System.out.printf("[%s] Temperature updated: %.1f°C%n", observerName, currentTemperature);
    }

    public String getObserverName() {
        return observerName;
    }
}
