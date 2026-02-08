package behavioural.iterator_pattern.good_code;

public class GoodClient {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();

        collection.addBood(new Book("Java"));
        collection.addBood(new Book("C++"));
        collection.addBood(new Book("Go"));

        Iterator<Book> bookItr = collection.createIterator();

        while (bookItr.hasNext()) {
            System.out.println(bookItr.next());
        }
    }
}
