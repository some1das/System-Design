package LLD.structuralDesignPattern.decorator_pattern.good_code;

import LLD.structuralDesignPattern.decorator_pattern.good_code.Pizza;

abstract class PizzaDecorator implements Pizza{
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza = pizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}
