package LLD.structuralDesignPattern.proxy_pattern;

public class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk..." + this.fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + this.fileName);
    }
    
}
