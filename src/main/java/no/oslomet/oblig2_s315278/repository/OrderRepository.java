package no.oslomet.oblig2_s315278.repository;

import no.oslomet.oblig2_s315278.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
}
