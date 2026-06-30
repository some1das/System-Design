package LLD.structuralDesignPattern.composite_pattern.solution;

public class File implements FileSystemComponent{
    String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: "+ name);
    }
}
