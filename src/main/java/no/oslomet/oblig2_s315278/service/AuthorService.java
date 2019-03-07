package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Author;

import java.util.List;
public interface AuthorService {

    List<Author> getAllAuthors();
    Author getAuthor(Long id);
    void addAuthor(Author author);
    void deleteAuthor(Long id);
}
