package LLD.structuralDesignPattern.proxy_pattern;

public class Client {
    public static void main(String[] args) {
        ProxyImage img = new ProxyImage("dog.png");

        img.display();
        img.display();
        
    }
}
