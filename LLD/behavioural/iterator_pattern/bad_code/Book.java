package behavioural.iterator_pattern.bad_code;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book { Title =  '" + this.title + "'}"; 
    }
}
