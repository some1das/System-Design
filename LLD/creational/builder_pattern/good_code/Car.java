package creational.builder_pattern.good_code;

public class Car {
    // Required Parameters
    private String brand;
    private String model;

    // Optional Parameters
    private String description;
    private double price;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.description = builder.description;
        this.price = builder.price;
    }

    

    public static class Builder {
        // Required Parameters
        private String brand;
        private String model;

        // Optional Parameters
        private String description;
        private double price;

        public Builder(String brand, String model) {
            this.brand = brand;
            this.model = model;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
