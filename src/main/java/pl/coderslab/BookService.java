package pl.coderslab;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    void addBook(Book book);

    Book getBook(Long id);

    void deleteBook(Long id);

    void editBook(Long id, Book book);

}
