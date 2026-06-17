package designpatterns.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherForcast implements IObservable {

    double temprature;
    List<IObserver> subscribersList;

    WeatherForcast(double temprature) {
        this.temprature = temprature;
        subscribersList = new ArrayList<>();
    }

    @Override
    public void addSubScriber(IObserver observer) {
        subscribersList.add(observer);
    }

    @Override
    public void removeSubScriber(IObserver observer) {
        subscribersList.remove(observer);
    }

    void setWeather(double newTemprature) {

        if (newTemprature != temprature) {
            temprature = newTemprature;
            notifySubScriber();
        }else {
            System.out.println("No changes in the newTemprature" + newTemprature);
        }
    }

    @Override
    public void notifySubScriber() {
        subscribersList.forEach(s -> s.update(temprature));
    }
}
