package creational.builder_pattern.good_code;

public class GoodClient {
    public static void main(String[] args) {
        Car car1 = new Car.Builder("Audi", "Q3").description("Best Speed").price(10000000.0).build();
    }
}
