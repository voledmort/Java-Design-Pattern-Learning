package observer.service.impl;

import observer.service.Subject;

import java.util.ArrayList;
import java.util.Observer;

public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float himidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i > 0) observers.remove(i);
    }

    @Override
    public void notifyObserver() {
        observers.forEach((observer) -> {
            observer.update(temperature, himidity, pressure);
        });
    }

    public void measurementsChanged(){
        notifyObserver();
    }

    public void setMeasurements(float temperature, float himidity, float pressure){
        this.temperature = temperature;
        this.himidity = himidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
