package designpatterns.observerPattern;

public class Main {
    public static void main(String[] args) {

        WeatherForcast weatherForcast = new WeatherForcast(10);
        IObserver mobileDisplay = new MobileDisplay();
        IObserver tVDisplay = new TVDisplay();

        weatherForcast.addSubScriber(mobileDisplay);
        weatherForcast.addSubScriber(tVDisplay);

        weatherForcast.setWeather(20);
        weatherForcast.setWeather(20);

        weatherForcast.removeSubScriber(tVDisplay);
        weatherForcast.setWeather(10);
    }
}
