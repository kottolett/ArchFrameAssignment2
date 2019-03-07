package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Book;
import no.oslomet.oblig2_s315278.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public List<Book> getAllBooks() { return bookRepository.findAll(); }

    @Transactional
    public Book getBook(Long isbn) {
        return bookRepository.findById(isbn).get();
    }

    @Transactional
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long isbn) {
        bookRepository.deleteById(isbn);
    }

    @Transactional
    public void buyBooks(List<Book> books) {
        for (Book book : books) {
            book.setQuantity(book.getQuantity()-1);
        }
    }
}
