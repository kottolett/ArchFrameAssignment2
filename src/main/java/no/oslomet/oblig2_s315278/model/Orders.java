package no.oslomet.oblig2_s315278.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;

    @ManyToOne
    @JoinColumn
    private Shipping shipping;

    @ManyToMany(cascade = CascadeType.MERGE )
    @JoinTable(name = "book_orders", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "book_isbn"))
    private List<Book> books;

    public Orders(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.date;
    }
}
