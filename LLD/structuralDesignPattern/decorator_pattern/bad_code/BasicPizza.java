package LLD.structuralDesignPattern.decorator_pattern.bad_code;

public class BasicPizza implements Pizza{

    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 5.00;
    }
}
