package LLD.structuralDesignPattern.composite_pattern.solution;

public class FileSystemApp {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.php");
        FileSystemComponent file2 = new File("file2.php");
        FileSystemComponent file3 = new File("file3.php");

        Folder folder1 = new Folder("documents");

        folder1.addComponent(file1);
        folder1.addComponent(file2);
        folder1.addComponent(file3);

        // Sub folder
        Folder subFolder = new Folder("child_folder");

        FileSystemComponent file4 = new File("file4.py");
        FileSystemComponent file5 = new File("file5.py");
        FileSystemComponent file6 = new File("file6.py"); 
        
        subFolder.addComponent(file4);
        subFolder.addComponent(file5);
        subFolder.addComponent(file6);

        folder1.addComponent(subFolder);

        folder1.showDetails();

    }
}
