package creational.factory.bad_code;

public class Car implements Transport{

    @Override
    public void deliver() {
        System.out.println("Deliver By Car");
    }
    
}
