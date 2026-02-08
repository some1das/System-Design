package behavioural.iterator_pattern.good_code;

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

    public Iterator<Book> createIterator() {
        return new BookIterator(this.books);
    }

    // Another class
    private class BookIterator implements Iterator<Book> {
        private List<Book> books;

        private int position = 0;

        public BookIterator(List<Book> books) {
            this.books = books;
        }

        @Override
        public boolean hasNext() {
            return position < this.books.size();
        }

        @Override
        public Book next() {
            return books.get(position++);
        }
    }
}
