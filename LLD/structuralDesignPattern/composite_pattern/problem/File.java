package LLD.structuralDesignPattern.composite_pattern.problem;

public class File {
    String name;

    public File(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("File: "+ name);
    }
}
