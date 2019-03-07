package no.oslomet.oblig2_s315278.repository;

import no.oslomet.oblig2_s315278.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}
