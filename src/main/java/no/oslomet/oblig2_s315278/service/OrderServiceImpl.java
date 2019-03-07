package no.oslomet.oblig2_s315278.service;

import no.oslomet.oblig2_s315278.model.Orders;
import no.oslomet.oblig2_s315278.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<Orders> getAllOrders() { return orderRepository.findAll(); }

    @Transactional
    public Orders getOrder(Long id) {
        return orderRepository.findById(id).get();
    }

    @Transactional
    public void addOrder(Orders order) {
        orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
