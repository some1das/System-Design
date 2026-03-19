package LLD.structuralDesignPattern.decorator_pattern.bad_code;

public class CheeseOlivePizza extends CheesePizza{
    @Override
    public String getDescription() {
        return super.getDescription() + ", Olive";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1;
    }
}
