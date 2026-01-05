package behavioural.observer_pattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    List<Device> devices = new ArrayList<>();

    @Override
    public void attach(Device o) {
        devices.add(o);
    }

    @Override
    public void detach(Device o) {
        devices.remove(o);
    }

    @Override
    public void notifyUpdate(String message) {
        for(Device d: devices) {
            d.displayMessage(message);
        }
    }    
}
