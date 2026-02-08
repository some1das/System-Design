package behavioural.iterator_pattern.bad_code;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {
    
    private List<Book> books = new ArrayList<>();

    public void addBood(Book book) {
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return this.books;
    }
}
