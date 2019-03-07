package no.oslomet.oblig2_s315278.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

    @Override
    public String toString() {
        return this.name;
    }

    public Category(String name) {
        this.name = name;
    }
}
