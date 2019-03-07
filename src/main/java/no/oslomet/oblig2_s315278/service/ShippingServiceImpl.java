package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Shipping;
import no.oslomet.oblig2_s315278.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Transactional
    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }

    @Transactional
    public Shipping getShipping(Long id) {
        return shippingRepository.findById(id).get();
    }

    @Transactional
    public void addShipping(Shipping shipping) {
        shippingRepository.save(shipping);
    }

    @Transactional
    public void deleteShipping(Long id) {
        shippingRepository.deleteById(id);
    }
}
