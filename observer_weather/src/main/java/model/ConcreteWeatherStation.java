package model;
import java.util.Random;
//concrete subject:
public class ConcreteWeatherStation extends WeatherStation {
    private int temperature = 20; //default temp
    private final int MIN_TEMP= -10;
    private final int MAX_TEMP = 40;
    private  Random rand = new Random();
    private boolean running = true;

    @Override
    public int getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperatureRandomly() {
        int change = rand.nextInt(5) - 2; // -2 to +2
        temperature += change;

        if (temperature < MIN_TEMP) temperature = MIN_TEMP;
        if (temperature > MAX_TEMP) temperature = MAX_TEMP;

        notifyObserver(); // inherited from abstract class

    }
    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep((rand.nextInt(5) + 1) * 1000); // 1-5 sec
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            setTemperatureRandomly();
        }
    }
}
