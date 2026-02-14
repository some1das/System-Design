package creational.factory.bad_code;

public class Bike implements Transport{
    @Override
    public void deliver() {
        System.out.println("Deliver By Bike");
    }
}
