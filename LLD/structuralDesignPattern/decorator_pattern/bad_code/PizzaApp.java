package LLD.structuralDesignPattern.decorator_pattern.bad_code;

public class PizzaApp {
    public static void main(String[] args) {
        Pizza pizza = new CheeseOlivePizza();

        System.out.println(pizza.getDescription());
    }
}
