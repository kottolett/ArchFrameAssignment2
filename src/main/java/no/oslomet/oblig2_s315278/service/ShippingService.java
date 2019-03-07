package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Shipping;

import java.util.List;

public interface ShippingService {

    List<Shipping> getAllShipping();
    Shipping getShipping(Long id);
    void addShipping(Shipping shipping);
    void deleteShipping(Long id);

}
