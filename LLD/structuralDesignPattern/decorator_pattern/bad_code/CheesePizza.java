package LLD.structuralDesignPattern.decorator_pattern.bad_code;

public class CheesePizza extends BasicPizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2;
    }
}
