package model;
import java.util.*;
//abstract subject
public abstract class  WeatherStation extends Thread {

    private  List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObserver(){
        for(Observer observer : observers){
            observer.update();
        }
    }

    public abstract int getTemperature();
    public abstract void setTemperatureRandomly();




}
