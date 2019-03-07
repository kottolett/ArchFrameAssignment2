package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBook(Long isbn);
    void addBook(Book book);
    void deleteBook(Long isbn);
    void buyBooks(List<Book> books);
}
