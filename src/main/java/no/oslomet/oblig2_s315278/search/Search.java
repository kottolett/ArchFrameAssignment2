package no.oslomet.oblig2_s315278.search;

import no.oslomet.oblig2_s315278.model.Book;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class Search {
    @PersistenceContext
    private EntityManager entityManager;

    public List search(String text) {
        FullTextEntityManager fullTextEntityManager =
                org.hibernate.search.jpa.Search.getFullTextEntityManager(entityManager);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Book.class).get();

        org.apache.lucene.search.Query query = queryBuilder
                .keyword()
                .onFields("isbn", "title", "releaseYear")
                .matching(text)
                .createQuery();

        org.hibernate.search.jpa.FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(query, Book.class);

        @SuppressWarnings("unchecked")
        List results = jpaQuery.getResultList();

        return results;
    }
}
