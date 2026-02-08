package behavioural.iterator_pattern.bad_code;

public class BadClient {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBood(new Book("Java"));
        collection.addBood(new Book("C++"));
        collection.addBood(new Book("Go"));

        for(int i = 0; i < collection.getBooks().size(); i++) {
            System.out.println(collection.getBooks().get(i));
        }
    }
}
