package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ConcreteWeatherStation;


public class Gui extends Application  {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);

        // Create station
        ConcreteWeatherStation station = new ConcreteWeatherStation();

        // Create observers
        WeatherObserver obs1 = new WeatherObserver("Observer 1", station);
        WeatherObserver obs2 = new WeatherObserver("Observer 2", station);

        // Register observers
        station.addObserver(obs1);
        station.addObserver(obs2);

        root.getChildren().addAll(obs1, obs2);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Weather Station Simulator");
        primaryStage.show();

        // Start station thread
        station.start();

        // After 15 seconds, remove one observer
        new Thread(() -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {}
            station.removeObserver(obs1);
            System.out.println("Observer 1 removed");
        }).start();
    }

}
