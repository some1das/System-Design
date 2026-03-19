package LLD.structuralDesignPattern.proxy_pattern;

public class ProxyImage {
    private String fileName;

    private Image image;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    public void display() {
        if(image == null) {
            image = new RealImage(fileName);
        }
        image.display();
    }
}
