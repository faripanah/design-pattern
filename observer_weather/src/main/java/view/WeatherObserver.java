package view;
import javafx.application.Platform;
import javafx.scene.control.Label;
import model.ConcreteWeatherStation;
import model.Observer;

public class WeatherObserver extends Label implements Observer {
    private String name;
    private ConcreteWeatherStation station;
    public WeatherObserver(String name, ConcreteWeatherStation station) {
        this.name = name;
        this.station = station;
        setText(name + "wating for update...");
    }
    @Override
    public void update() {
        int temp = station.getTemperature(); // "pull" data from subject
        //observers updating UI directly
        Platform.runLater(() -> setText(name + " sees temperature: " + temp + "°C"));
    }


}
