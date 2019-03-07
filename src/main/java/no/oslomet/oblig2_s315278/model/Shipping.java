package no.oslomet.oblig2_s315278.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL)
    private List<Orders> orders;

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    public Shipping(String firstName, String lastName, String address, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postalCode = postalCode;
    }
}
