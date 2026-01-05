package behavioural.observer_pattern;

public interface Subject {
    void attach(Device o);
    void detach(Device o);
    void notifyUpdate(String message);
}
