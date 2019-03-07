package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Author;
import no.oslomet.oblig2_s315278.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public List<Author> getAllAuthors() { return authorRepository.findAll(); }

    @Transactional
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).get();
    }

    @Transactional
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
