package LLD.structuralDesignPattern.composite_pattern.problem;

public class FileSystemApp {
    public static void main(String[] args) {
        File file1 = new File("file1.php");
        File file2 = new File("file2.php");
        File file3 = new File("file3.php");

        Folder folder1 = new Folder("documents");

        folder1.addFile(file1);
        folder1.addFile(file2);
        folder1.addFile(file3);
    }
}
