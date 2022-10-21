package pl.coderslab;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockBookService implements BookService {
    private Book book;
    private List<Book> books;
    private static Long nextId = 4L;


    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion",
                "programming"));
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        nextId++;
        books.add(book);
    }

    @Override
    public void editBook(Long id, Book book) {
        for (Book bookToEdit : books) {
            if (bookToEdit.getId().equals(id)) {
                int index = books.indexOf(bookToEdit);
                book.setId(bookToEdit.getId());
                books.set(index, book);
            }
        }
    }

    @Override
    public Book getBook(Long id) {
        for (Book bookToGet : books) {
            if (bookToGet.getId() == id) {
                return bookToGet;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(Long id) {
        books.removeIf(b -> b.getId() == id);
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
