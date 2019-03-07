package no.oslomet.oblig2_s315278.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.util.List;

@Entity
@Indexed
@Data
@NoArgsConstructor
public class Book {

    @Id
    private Long isbn;
    @Field(store = Store.NO)
    private String title;
    @Field
    private String releaseYear;
    private Integer quantity;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_isbn"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<Orders> orders;

    public Book(Long isbn, String title, String releaseYear, Integer quantity) {
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseYear;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return this.title;
    }
}
