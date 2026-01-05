package behavioural.observer_pattern;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Mobile mobile = new Mobile();

        station.attach(mobile);
        station.attach(new Screen());

        station.notifyUpdate("Update 1");

        station.detach(mobile);

        station.notifyUpdate("Update 2");
    }
}
